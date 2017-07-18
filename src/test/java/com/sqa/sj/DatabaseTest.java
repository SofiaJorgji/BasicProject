package com.sqa.sj;

import java.sql.*;

import org.testng.annotations.*;

import com.sqa.sj.helpers.*;
import com.sqa.sj.helpers.enums.*;
import com.sqa.sj.helpers.exceptions.*;

public class DatabaseTest {

	@Test
	public void testDataHelper() throws ClassNotFoundException, DataTypesMismatchException, SQLException,
			DataTypesCountException, DataTypesTypeException {
		Object[][] data = DataHelper.evalDatabaseTable("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/sqa",
				"root", "root", "employee", 0, 0, new DataType[] { DataType.INT, DataType.STRING, DataType.STRING,
						DataType.INT, DataType.STRING, DataType.FLOAT });
		System.out.println(DataHelper.displayData(data));
	}

	@Test
	public void testDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		// if I have 3306 port, I don't need to put it
		Connection dbconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqa", "root", "root");
		Statement stmt = dbconn.createStatement();
		// ResultSet rs = stmt.executeQuery("select userName, userPass from
		// employee ");
		ResultSet rs = stmt.executeQuery("select * from employee ");
		// ResultSet rs = stmt.excecuteUpdate("select * from employee "); if we
		// are
		// updating
		while (rs.next()) {
			// String userName = rs.getString(1); 1: column 1
			// String userPass = rs.getString(2);
			// System.out.println("user=" + userName + " password=" + userPass);
			String name = rs.getString(2);
			int age = rs.getInt("age");
			String jobTitle = rs.getString("jobTitle");
			System.out.println("Name: " + name + "(" + age + ")\t\tJob title: " + jobTitle);
		}
		rs.close();
		stmt.close();
		dbconn.close();
	}
}
