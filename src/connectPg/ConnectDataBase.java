package connectPg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDataBase {

	// Data base path.
	static final String URL = "jdbc:postgresql://localhost:5432/postgres";

	// Data base user name.
	static final String USER = "postgres";

	// Data base user password.
	static final String PASS = "1234567";

	// This method is supposed to make db connection.
	public static Connection makeConnection() throws ClassNotFoundException, SQLException {
//		DriverManager.registerDriver(new org.postgresql.Driver());
		Class.forName("org.postgresql.Driver");

		// This object contains all DB parameters we previously settled
		Connection connect = DriverManager.getConnection(URL, USER, PASS);

		if (connect != null) {
			System.out.println("Connection has been created successfully");
			return connect;
		}
		return null; // null should be returned in case there's no satisfied conditional.
	}
}
