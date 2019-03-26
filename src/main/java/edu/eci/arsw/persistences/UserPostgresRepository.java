package edu.eci.arsw.persistences;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistences.repositories.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("UserPostgresRepository")
public class UserPostgresRepository implements IUserRepository {

	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUsername;
	@Value("${spring.datasource.password}")
	private String dbPassword;

	@Autowired
	private DataSource dataSource;

	@Override
	public List<User> findAll() {

		String query = "SELECT * FROM users;";
		List<User> users = new ArrayList<User>();
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setId(Long.parseLong(rs.getString("id_users")));
				user.setEmail(rs.getString("email"));
				user.setNumber(rs.getString("phone"));
				user.setJairitos(Integer.parseInt(rs.getString("jairitos")));
				user.setJairitosBenefit(Integer.parseInt(rs.getString("jairitosfavor")));
				user.setJairitosCongelados(Integer.parseInt(rs.getString("jairitoscongelados")));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void createUser(User usuario) {
		String query = "INSERT into users(id,name,phone,email,password,jairitos,jairitosfavor,jairitoscongelados) VALUES("
				+ "2" + "," + usuario.getName() + "," + usuario.getNumber() + "," + usuario.getEmail() + ","
				+ usuario.getPassword() + "," + "0, 0 , 0+);";
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
		// TODO Auto-generated method stub
	}

	@Override
	public User find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(User o) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getUserById(long idUser) {
		// TODO Auto-generated method stub
		return null;
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
