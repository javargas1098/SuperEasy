package edu.eci.arsw.persistences;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
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
import javassist.bytecode.ExceptionsAttribute;

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
	public List<Auction> findAll() throws SQLException, ParseException {
		System.out.println("////////////////////////////////////////////aquiiiii");
		String query = "SELECT * FROM subastas;";
		List<Auction> auctions = new ArrayList<Auction>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Auction auction = new Auction();
				auction.setIdSubasta(rs.getString("id_subasta"));
				auction.setHoraIni(new Timestamp(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("hora_ini")).getTime()));
				auction.setHoraFin(new Timestamp(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("hora_fin")).getTime()));
				auction.setEstado(Integer.parseInt(rs.getString("estado")));
				auction.setPrecioSugerido(Integer.parseInt(rs.getString("precio_sugerido")));
				auction.setPrecioActual(Integer.parseInt(rs.getString("precio_actual")));
				auction.setSeller(
						UserPostgresRepository.getUserById(Integer.parseInt(rs.getString("id_seller"))).getEmail());
				auction.setBidders(getBidders(rs.getString("id_subasta")));
				auction.setItem(getItem(rs.getString("items_item_id")));

				auctions.add(auction);
			}
			connection.close();
			return auctions;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
		

	}

	@Override
	public List<User> getBidders(String idSubasta) {
		String query = "SELECT users_id FROM bidders WHERE id_subasta = '" + idSubasta + "' ;";
		List<User> users = new ArrayList<User>();
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				User user = UserPostgresRepository.getUserById(Long.parseLong(rs.getString("users_id")));
				users.add(user);
			}
			connection.close();
			return users;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Item getItem(String idItem) throws SQLException {
		System.out.println(idItem);
		String query = "SELECT * FROM items WHERE item_id = '" + idItem + "';";
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			Item item = new Item();
			while (rs.next()) {

				item.setId(rs.getString("item_id"));
				item.setDescripcion(rs.getString("description"));
				item.setMarca(rs.getString("marca"));
				item.setModelo(rs.getString("modelo"));
			}
			connection.close();
			return item;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(Auction auction) throws SQLException {
		// YYYY-MM-DD HH:mm por si falla
		System.out.println(
				"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		System.out.println(auction.getIdSubasta());
		// System.out.println(UserPostgresRepository.getUserByEmail(auction.getSeller()).getId());

		String query = "INSERT into subastas(id_subasta,estado,hora_ini,hora_fin,precio_sugerido,precio_actual,id_seller,items_item_id) VALUES('"
				+ auction.getIdSubasta() + "','" + 1 + "',TO_TIMESTAMP('" + auction.getHoraIni()
				+ "','YYYY-MM-DD HH24:MI:SS:MS'),TO_TIMESTAMP('" + auction.getHoraFin()
				+ "','YYYY-MM-DD HH24:MI:SS:MS')," + auction.getPrecioSugerido() + "," + auction.getPrecioSugerido()
				+ "," + UserPostgresRepository.getUserByEmail(auction.getSeller()).getId() + ",'"
				+ auction.getItem().getId() + "');";
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public String saveItem(Item item) {
		String query = "INSERT into items(item_id,description,marca,modelo) VALUES('" + item.getId() + "','"
				+ item.getDescripcion() + "','" + item.getMarca() + "','" + item.getModelo() + "');";
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
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

	@Override
	public Auction find(String id) {
		String query = "SELECT * FROM subastas WHERE id_subasta =" + id + ";";
		List<Auction> auctions = new ArrayList<Auction>();
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			connection.close();
			Auction auction = new Auction();
			auction.setIdSubasta(rs.getString("id_subasta"));
			auction.setEstado(Integer.parseInt(rs.getString("estado")));
			auction.setHoraIni((Timestamp) new SimpleDateFormat("YYYY-MM-DD HH:mm").parse(rs.getString("hora_ini")));
			auction.setHoraFin((Timestamp) new SimpleDateFormat("YYYY-MM-DD HH:mm").parse(rs.getString("hora_fin")));
			auction.setPrecioSugerido(Integer.parseInt(rs.getString("precio_sugerido")));
			auction.setPrecioActual(Integer.parseInt(rs.getString("precio_actual")));
			auction.setSeller(
					UserPostgresRepository.getUserById(Integer.parseInt(rs.getString("id_seller"))).getEmail());
			auction.setBidders(getBidders(rs.getString("id_subasta")));
			auction.setItem(getItem(rs.getString("id_subasta")));

			auctions.add(auction);

			return auction;
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public void Bid(String idsubasta, int newPrice) throws SQLException {
		String query = "UPDATE subastas SET precio_actual=" + newPrice + " WHERE idsubasta=" + idsubasta + ";";
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			connection.close();
		}
	}
}