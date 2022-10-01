package Com.proj.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyHelper {

	public static Connection getConnectionObject() {
		String url="jdbc:mysql://localhost:3306/student_app_jdbc";
		String user="root";
		String password="soumya";
		Connection connection=null;
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return connection;

	}

}
