package edu.eci.arsw.persistences;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistences.repositories.IUserRepository;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.w3c.dom.css.CSSStyleSheet;

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

	

	@Autowired
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

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
	public User find(Long id) {

		String query = "SELECT * FROM users WHERE id_users = " + id + ";";
		User user = new User();
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			user.setName(rs.getString("name"));
			user.setId(Long.parseLong(rs.getString("id_users")));
			user.setEmail(rs.getString("email"));
			user.setNumber(rs.getString("phone"));
			user.setJairitos(Integer.parseInt(rs.getString("jairitos")));
			user.setJairitosBenefit(Integer.parseInt(rs.getString("jairitosfavor")));
			user.setJairitosCongelados(Integer.parseInt(rs.getString("jairitoscongelados")));
			user.setPassword(rs.getString("password"));

			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(User usuario) {

		String query = "INSERT into users(id_users,name,phone,email,password,jairitos,jairitosfavor,jairitoscongelados) VALUES((Select CASE WHEN EXISTS(SELECT id_users FROM users WHERE id_users=1) THEN max(id_users)+1 ELSE 1 END FROM users),'"
				+ usuario.getName() + "','" + usuario.getNumber() + "','" + usuario.getEmail() + "','"
				+ usuario.getPassword() + "'," + "0, 0 , 0);";
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
	public void update(User entity) {

	}

	// Delete by email
	@Override
	public void delete(User o) {
		String query = "DELETE FROM users WHERE email = " + o.getEmail() + ";";

		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		
		Statement stmt = null;
		String query = "SELECT * FROM users WHERE email ='" + email + "';";
		User user = new User();
		try (Connection connection = dataSource.getConnection()) {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				user.setName(rs.getString("name"));
				user.setId(Long.parseLong(rs.getString("id_users")));
				user.setEmail(rs.getString("email"));
				user.setNumber(rs.getString("phone"));
				user.setJairitos(Integer.parseInt(rs.getString("jairitos")));
				user.setJairitosBenefit(Integer.parseInt(rs.getString("jairitosfavor")));
				user.setJairitosCongelados(Integer.parseInt(rs.getString("jairitoscongelados")));
				user.setPassword(rs.getString("password"));
				connection.close();
				return user;

			} else {
				connection.close();
				return null;
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	@Override
	public User getUserById(long idUser) throws SQLException {

		String query = "SELECT * FROM users WHERE id_users =" + idUser + ";";
		
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			User user = new User();
			user.setName(rs.getString("name"));
			user.setId(Long.parseLong(rs.getString("id_users")));
			user.setEmail(rs.getString("email"));
			user.setNumber(rs.getString("phone"));
			user.setJairitos(Integer.parseInt(rs.getString("jairitos")));
			user.setJairitosBenefit(Integer.parseInt(rs.getString("jairitosfavor")));
			user.setJairitosCongelados(Integer.parseInt(rs.getString("jairitoscongelados")));
			user.setPassword(rs.getString("password"));
			connection.close();
			return user;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateJairitos(String email, int value) throws SQLException {
		
		String query = "update users set jairitos="+value+" where email='"+email+"';";
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			 stmt.executeUpdate(query);
			connection.close();
		}
		
	}

	@Override
	public void updateCongelados(String email, int value) throws SQLException{
		
		String query = "update users set jairitoscongelados="+value+" where email='"+email+"';";
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			 stmt.executeUpdate(query);
			connection.close();
		}
		
	}

}
