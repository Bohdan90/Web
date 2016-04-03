package BDconnectToForum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ConnectFoForum {
	private int index = 0;

	private HashMap<Integer, String> usersMap = new HashMap<Integer, String>();

	public void addText(String text) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/login", "root", "");
			Statement st = con.createStatement();
			String sqlSETdates = ("INSERT INTO `forummessages`(`id`, `text`) VALUES  ("
					+ index++ + "," + "'" + text + "'" + ")");
			st.executeUpdate(sqlSETdates);
			con.close();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public HashMap getText() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/login", "root", "");
			Statement st = con.createStatement();
			String sqlGetDates = ("SELECT * FROM forummessages");
			ResultSet rs = st.executeQuery(sqlGetDates);
			while (rs.next()) {
				usersMap.put(rs.getInt("id"), rs.getString("text"));
				System.out.println(rs.getRow() + ". " + rs.getString("text")
						+ "!!! FROM GET ID TEXT !!!" );
			}
			con.close();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return usersMap;
	}
}
