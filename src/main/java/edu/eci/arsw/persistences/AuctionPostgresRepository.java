package edu.eci.arsw.persistences;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import edu.eci.arsw.model.Auction;
import edu.eci.arsw.model.EstadoSubasta;
import edu.eci.arsw.model.Item;
import edu.eci.arsw.model.User;
import edu.eci.arsw.persistences.repositories.IAuctionRepository;
import edu.eci.arsw.persistences.repositories.IUserRepository;

@Component
@Qualifier("AuctionPostgresRepository")
public class AuctionPostgresRepository implements IAuctionRepository {
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUsername;
	@Value("${spring.datasource.password}")
	private String dbPassword;

	@Autowired
	private DataSource dataSource;
	@Autowired
	private IUserRepository UserPostgresRepository;

	@Override
	public List<Auction> findAll() {
		String query = "SELECT * FROM subastas;";
		List<Auction> auctions = new ArrayList<Auction>();
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			connection.close();
			while (rs.next()) {
				Auction auction = new Auction();
				auction.setIdSubasta(Long.parseLong(rs.getString("id_subasta")));
				auction.setEstado(EstadoSubasta.valueOf(rs.getString("estado")));
				auction.setHoraIni(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(rs.getString("hora_ini")));
				auction.setHoraFin(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(rs.getString("hora_fin")));
				auction.setPrecioSugerido(Integer.parseInt(rs.getString("precio_sugerido")));
				auction.setSeller(
						UserPostgresRepository.getUserById(Integer.parseInt(rs.getString("id_seller"))).getEmail());
				auction.setBidders(getBidders(Long.parseLong(rs.getString("id_subasta"))));
				auction.setItem(getItem(Long.parseLong(rs.getString("id_subasta"))));

				auctions.add(auction);
			}
			return auctions;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> getBidders(long idSubasta) {
		String query = "SELECT users_id WHERE id_subasta = " + idSubasta + " FROM bidders;";
		List<User> users = new ArrayList<User>();
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			connection.close();
			while (rs.next()) {
				User user = UserPostgresRepository.getUserById(Long.parseLong(rs.getString("users_id")));
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Item getItem(long idSubasta) {
		String query = "SELECT * WHERE id_subasta = " + idSubasta + " FROM items;";
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			connection.close();

			Item item = new Item();

			item.setId(Long.parseLong(rs.getString("item_id")));
			item.setDescripcion(rs.getString("description"));
			item.setMarca(rs.getString("marca"));
			item.setModelo(rs.getString("modelo"));

			return item;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Auction find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Auction auction) {
		String query = "INSERT into subastas(id_subasta,estado,hora_ini,hora_fin,precio_sugerido,id_seller,items_item_id) VALUES((Select CASE WHEN EXISTS(SELECT id_subasta FROM subastas WHERE id_subasta=1) THEN max(id_subasta)+1 ELSE 1 END FROM subastas)"
				+ ",'" + auction.getEstado() + "','" + auction.getHoraIni() + "','" + auction.getHoraFin() + "','"
				+ auction.getPrecioSugerido() + "','" + UserPostgresRepository.getUserByEmail(auction.getSeller()).getId()
				+ auction.getItem().getId() + "');";
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			connection.close();
			return auction.getIdSubasta();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Long saveItem(Item item) {
		String query = "INSERT into items(item_id,description,marca,modelo) VALUES("
				+ "(Select CASE WHEN EXISTS(SELECT item_id FROM items WHERE item_id=1) THEN max(item_id)+1 ELSE 1 END FROM items)"
				+ ",'" + item.getDescripcion() + "','" + item.getMarca() + "','" + item.getModelo() + "');";
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			connection.close();
			return item.getId();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Auction entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Auction o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub

	}

	@Bean
	private DataSource dataSource() throws SQLException {
		if (dbUrl == null || dbUrl.isEmpty()) {
			return new HikariDataSource();
		} else {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(dbUrl);
			config.setUsername(dbUsername);
			config.setPassword(dbPassword);
			return new HikariDataSource(config);
		}
	}
}
