package edu.eci.arsw.persistence.ipml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.repository.UserRepository;
@Component
@Qualifier("UserRepositoryPersistence")
public class UserRepositoryPersistence implements UserRepository{
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUsername;
	@Value("${spring.datasource.password}")
	private String dbPassword;
	
	
	private DataSource userdataSource;
	
	

	

	@Override
	public List<User> findAll()  {
		try {
			if(userdataSource==null) {
				userdataSource= gendata();
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
		
		String query= "SELECT * FROM users;";
		List<User> users=new ArrayList<User>();
		try (Connection connection = userdataSource.getConnection()) {
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
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User GetUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(User usuario) {
		// TODO Auto-generated method stub
		
	}
	
	private DataSource gendata() throws SQLException{
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