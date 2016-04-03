package BDconnectToUsers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SQLconnect {
	private int index = 0;

	private String name;
	private int age;
	private HashMap<String, String> usersMap = new HashMap<String, String>();

	public void addUser(int age, String userName) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/login", "root", "");
			Statement st = con.createStatement();
			String sqlSETdates = ("INSERT INTO `users`(`id`, `age`, `name`) VALUES  ("
					+ index++ + "," + age + "," + "'" + userName + "'" + ")");
			st.executeUpdate(sqlSETdates);
			con.close();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public HashMap getUser() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/login", "root", "");
			Statement st = con.createStatement();
			String sqlGetDates = ("SELECT * FROM users");
			ResultSet rs = st.executeQuery(sqlGetDates);
			while (rs.next()) {
				usersMap.put(rs.getString("name"), rs.getString("age"));
				System.out.println(rs.getRow() + ". " + rs.getString("name")
						+ rs.getString("age") + "!!! FROM GET USER !!!");
			}
			con.close();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return usersMap;
	}
}