package com.letUsLearn.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Derbytest {
	public static void main(String[] args) throws SQLException {
		Connection conn;
		conn = getconnection("jdbc:derby:/Database/Derby/DB-Data;create=true");
		showTables(conn);

		String string1 = "select c.dices, c.sides, c.ROLLEDVALUE, c.stotal, d.total from (select a.dices dices,a.sides sides, b.ROLLEDVALUE ROLLEDVALUE, sum(b.TIMES) stotal "
				+ "from dds a, ddsdetails b " + "where a.id=b.dds_id " + "group by a.dices ,a.sides, b.ROLLEDVALUE) c, "
				+ "(select dices, sides, sum(rolls) total from dds group by dices ,sides) d "
				+ "where c.dices=d.dices and c.sides=d.sides";

		// fetch(conn, string1, true);

	}

	private static void showTables(Connection conn) throws SQLException {
		ArrayList<String[]> tables = fetch(conn, "select TABLENAME from  sys.systables where TABLETYPE='T'", false);
		for (String[] strings : tables) {
			for (String string : strings) {
				fetch(conn, "select * from " + string, true);
			}
		}
	}

	private static void print(ArrayList<String[]> s) {
		System.out.println("=====================================================================");
		for (String[] strings : s) {
			for (String string : strings) {
				System.out.print(string + "\t");
			}
			System.out.println("");
		}
	}

	private static ArrayList<String[]> fetch(Connection conn, String query, boolean metadata) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
		resultSetMetaData.getColumnCount();
		int j = resultSetMetaData.getColumnCount();
		String[] s = new String[j];
		if (metadata) {
			for (int i = 1; i <= j; i++) {
				s[i - 1] = resultSetMetaData.getColumnName(i);
			}
			list.add(s);
		}
		while (rs.next()) {
			s = new String[j];
			for (int i = 1; i <= j; i++) {
				s[i - 1] = rs.getString(i);
			}
			list.add(s);
		}
		rs.close();
		stmt.close();
		print(list);
		return list;
	}

	private static Connection getconnection(String dbURL) throws SQLException {
		Connection conn = DriverManager.getConnection(dbURL);
		return conn;
	}
}
