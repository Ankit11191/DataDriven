package unusedScenarios;

import java.sql.*;
		
class JDBC 
{
	static Connection conn;
	public static void main(String[] abc) throws ClassNotFoundException, SQLException{

	String URL = "jdbc:oracle:thin:@dc1qa2matdb01.prod.tangoe.com:1521/";
	String Uname = "C##CORE";
	String Pass = "Welcome1";
	String DBname="AC";
		try{
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection(URL + DBname, Uname, Pass);
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs= stmt.executeQuery("SELECT * FROM BI_JOB");//String query = "Select * from EMP";
		System.out.println("aaa");
			while(rs.next())
			{
				System.out.println(rs.getString(0));
			}
		}
		catch(SQLException e)
		{
				e.getStackTrace();
		}
		finally
		{
			conn.close();
		}
}}