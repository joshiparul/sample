package pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveCount {

	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	/**
	 * @param args
	 * @throws SQLException
	 */

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
			e.printStackTrace();
		}

		// replace "hive" here with the name of the user the queries should run
		// as
		Connection con = DriverManager.getConnection("jdbc:hive2://10.119.32.86:10000", "haas", "syntel123$");
		Statement stmt = con.createStatement();
		String table_name = "Sales_Demo";
		// stmt.execute("drop table if exists " + table_name);
		// stmt.execute("create table " + table_name +
		// " (id int,name string,location String)");
		// show tables
		// String sql = "show tables '" + table_name + "'";
		String sql = "show tables";
		System.out.println("Running: " + sql);
		ResultSet res = stmt.executeQuery(sql);
		if (res.next()) {
			System.out.println(res.getString(1));
		}
		// describe table
		sql = "describe " + table_name;
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1) + "\t" + res.getString(2));
		}

		// load data into table
		// NOTE: filepath has to be local to the hive server
		// NOTE: /tmp/a.txt is a ctrl-A separated file with two fields per line
		// fileUtils.readFileToString(hive.txt);
		// String filepath = "/home/AK5022418.txt";

		// sql = "load data local inpath '"+ '/home/AK5022418/hive.txt' +
		// "' into table " + usecase_hive;
		// //sql =
		// "load data local inpath '/home/AK5022418/hive.txt' into table
		// usecase_hive";
		// System.out.println("Running: " + sql);
		// stmt.execute(sql);

		// select * query
		/*
		 * sql = "select * from " + table_name; System.out.println("Running: " +
		 * sql); res = stmt.executeQuery(sql); while (res.next()) {
		 * System.out.println(String.valueOf(res.getInt(1)) + "\t" +
		 * res.getString(2)); }
		 */

		// regular hive query
		sql = "select count(*) from " + table_name;
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1));
		}

		// execute statement for view
		stmt.executeQuery("CREATE VIEW Sales_Demo_view AS SELECT * FROM Sales_Demo WHERE Transaction_Id<=20");
		System.out.println("check point");
		// System.out.println(res1);
		con.close();

	}

	/*
	 * private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	 * public static void main(String[] args) throws SQLException,
	 * ClassNotFoundException {
	 * 
	 * 
	 * // Register driver and create driver instance Class.forName(driverName);
	 * 
	 * // get connection Connection con =
	 * DriverManager.getConnection("jdbc:hive2://10.119.32.86:10000/default",
	 * "", "");
	 * 
	 * // create statement Statement stmt = con.createStatement();
	 * 
	 * // execute statement for table creation //stmt.executeQuery(
	 * "Drop table Sales_Demo"); stmt.executeQuery("CREATE TABLE IF NOT EXISTS "
	 * +
	 * " Sales_Demo (Transaction_Id int,Product string,Price int,Payment_Type string,Name string,City string,State string,Country string,Latitude float,Longitude float)"
	 * +" ROW FORMAT DELIMITED" +" FIELDS TERMINATED BY ‘,’;");
	 * System.out.println("Sales_Demo table has been created");
	 * 
	 * // execute statement for load data stmt.executeQuery(
	 * "LOAD DATA INPATH '/user/haas/Sales_dir/SalesJanSample.csv'" +
	 * "INTO TABLE Sales_Demo;"); System.out.println(
	 * "Load Data into Sales_Demo successful");
	 * 
	 * // execute statement for view stmt.executeQuery(
	 * "CREATE VIEW Sales_Demo_view AS" +"SELECT * FROM Sales_Demo" +
	 * "WHERE Transaction_Id>20;"); System.out.println("View data can be seen");
	 * con.close(); }
	 */

}

// import java.sql.SQLException;
// import java.sql.Connection;
// import java.sql.ResultSet;
// import java.sql.Statement;
// import java.sql.DriverManager;
//
//
// public class HiveCount {
//
// private static String driverName = "org.apache.hive.jdbc.HiveDriver";
// public static void main(String[] args) throws SQLException,
// ClassNotFoundException {
//
//
// // Register driver and create driver instance
// Class.forName(driverName);
//
// // get connection
// Connection con =
// DriverManager.getConnection("jdbc:hive2://10.119.32.86:10000/default", "",
// "");
//
// // create statement
// Statement stmt = con.createStatement();
//
// // execute statement for table creation
// stmt.executeQuery("Drop table Sales_Demo");
// stmt.executeQuery("CREATE TABLE IF NOT EXISTS "
// +" Sales_Demo (Transaction_Id int,Product string,Price int,Payment_Type
// string,Name string,City string,State string,Country string,Latitude
// float,Longitude float)"
// +" ROW FORMAT DELIMITED"
// +" FIELDS TERMINATED BY ‘,’;");
// System.out.println("Sales_Demo table has been created");
//
// // execute statement for load data
// stmt.executeQuery("LOAD DATA INPATH
// '/user/haas/Sales_dir/SalesJanSample.csv'" + "INTO TABLE Sales_Demo;");
// System.out.println("Load Data into Sales_Demo successful");
//
// // execute statement for view
// ResultSet res = stmt.executeQuery("CREATE VIEW Sales_Demo_view AS"
// +"SELECT * FROM Sales_Demo"
// +"WHERE Transaction_Id>20;");
// System.out.println("View data can be seen");
// con.close();
// }
// }