package in.com.connetionfacatry;



import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnetionFactory {
	private static HikariDataSource dataSource = null;

	public static Connection getConnection() throws Exception {
		try {
			if (dataSource == null) {
				FileInputStream fis = new FileInputStream(
						"C:\\vineetha\\AdVjava\\LoginRegestration\\src\\db.properties");
				Properties p = new Properties();
				p.load(fis);
				String url = p.getProperty("db.url");
				String uname = p.getProperty("db.username");
				String pwd = p.getProperty("db.password");
				String driver = p.getProperty("db.driver");

				HikariConfig config = new HikariConfig();
				config.setJdbcUrl(url);
				config.setUsername(uname);
				config.setPassword(pwd);
				config.setDriverClassName(driver);
				dataSource = new HikariDataSource(config);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource.getConnection();

	}
}
