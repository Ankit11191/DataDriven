package scenario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetDBconnection 
{
	private static Statement getconnection()
	{
		Statement stmt=null;
		String DriverPAth = null;
		try{
		String[] URL = ReadProerties.propsObjectsSplit("URL");
		String[] Uname = ReadProerties.propsObjectsSplit("Uname");
		String[] Pass = ReadProerties.propsObjectsSplit("Pass");
		String[] DBname = ReadProerties.propsObjectsSplit("DBname");
		//String[] DriverPAth=ReadProerties.propsObjectsSplit("DriverPAth");
		{
			String[] Driver=ReadProerties.propsObjectsSplit("DriverPAth");
			switch (Driver[0]) 
			{
			case "Oracle":
				DriverPAth="oracle.jdbc.OracleDriver";
				break;
			case "Postgres":
				DriverPAth="org.postgresql.Driver";
				break;
				
			default:
				System.out.println("sorry no driver has selected");
				break;
			}
		}
		Class.forName(DriverPAth);

		System.out.println("Connecting to database...");
		// Creating connection
		Connection conn = DriverManager.getConnection(URL[0] + DBname[0], Uname[0], Pass[0]);
		// Connection open
		System.out.println("conn open");
		stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);// 
		}
		catch (Exception e)
		{
			
			System.out.println(e.getMessage());
		}
		return stmt;
		
	}
	
	public static ResultSet Readgetdata(String[] query)
	{
		ResultSet res = null;
		try {
			res = getconnection().executeQuery(query[0]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("executed");
		return res;
	}
	
	public static void insertdata(String[] query)
	{
		try {
				getconnection().executeUpdate(query[0]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("executed");
	}
	
	public static String getStatement()
	{
		Statement stat=getconnection();
		return stat.toString();
	}
	
}
