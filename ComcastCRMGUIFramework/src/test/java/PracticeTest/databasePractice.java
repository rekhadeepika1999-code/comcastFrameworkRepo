package PracticeTest;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.random.RandomGenerator;

import com.mysql.cj.jdbc.Driver;

public class databasePractice {
	public static void main(String[] args) throws Exception {
		// create db
		Driver d = new Driver();
		DriverManager.registerDriver(d);

		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "root");
		Statement statement = con.createStatement();

		RandomGenerator r =  RandomGenerator.getDefault();
		String dbName = "TP" + r.nextInt(1,999);

		ResultSet dbs = statement.executeQuery("show databases;");
		while (dbs.next()) {
			if (!(dbs.getString("Database").equals(dbName))) {
				statement.execute("create database " + dbName + ";");
				System.out.println(dbName+" database created");
				statement.execute("use " + dbName + ";");
				statement.execute("create table Abcd(Sr_no INT , city varchar(30));");
				break;
			}
		}
		statement.execute("use " + dbName + ";");
		System.out.println("db using");
		
		String tbl = "Batch" + r.nextInt(1,9999);
		ResultSet tables = statement.executeQuery("show tables;");

		while (tables.next() ) {
			if (!(tables.getString("Tables_in_" + dbName).equals(tbl))) {
				String q="create table "+tbl+"(empid int,empName varchar(30));";
				statement.execute(q);
				System.out.println(tbl+" table created");
				break;
			}
		}
		Thread.sleep(3000);
		con.close();
	}
}


