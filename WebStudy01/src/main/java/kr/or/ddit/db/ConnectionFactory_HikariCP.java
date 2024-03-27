package kr.or.ddit.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



/**
 * Factory Object[Method] Pattern
 *  : 객체의 생성을 전담하는 객체를 별도 운영하는 구조.
 *
 */
public class ConnectionFactory_HikariCP {
	private static String url;
	private static String user;
	private static String password;
	private static DataSource dataSource;
	private static String driverClassName;
	
	

	static {
		try(
			InputStream is = ConnectionFactory_HikariCP.class.getResourceAsStream("./DbInfo.properties");
		) {
			Properties props = new Properties();
			props.load(is);
			
			HikariConfig config = new HikariConfig();
			driverClassName = props.getProperty("driverClassName");
			
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			
			
			config.setDriverClassName(driverClassName);
			config.setJdbcUrl(url);
			config.setUsername(user);
			config.setPassword(password);
			
			config.setAutoCommit(true);
			config.setMaximumPoolSize(5);
			config.setMinimumIdle(3);
			config.setConnectionTimeout(2000);
			config.setConnectionTestQuery("SELECT SYSDATE FROM DUAL");
			
			dataSource = new HikariDataSource(config);
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} //constant pool 에 로딩됨.
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = dataSource.getConnection();
		return conn;
	}
}
