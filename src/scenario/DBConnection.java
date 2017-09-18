package scenario;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DBConnection {

	static Connection conn = null;
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public static Map callDB(String query) throws SQLException {

		String URL = "jdbc:oracle:thin:@dc1qa2matdb01.prod.tangoe.com:1521/";
		String Uname = "C##CORE";
		String Pass = "Welcome1";
		String DBname = "AC";
		Object keys = null;
		Object values = null;
		Map<Object, Object> hashMap = new HashMap<Object, Object>();
		Map<Object, Object> hashMap1 = new HashMap<Object, Object>();
		
		ResultSet rs = null;
		ResultSetMetaData rsMD ;
		Iterator<Map.Entry<Object, Object>> itr = hashMap.entrySet().iterator();
		Statement stmt = null;

		try {
			// load driver
			Class.forName("oracle.jdbc.OracleDriver");

			System.out.println("Connecting to database...");
			// Creating connection
			conn = DriverManager.getConnection(URL + DBname, Uname, Pass);
			// Connection open
			System.out.println("conn open");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);// 
			rs= stmt.executeQuery(query);
			rsMD= rs.getMetaData();

			int Columncount = rsMD.getColumnCount();
			int rowcount=0;

			while(rs.next())
			{		rowcount++;		}
			
			List<HashMap<Object, Object>> ListofHash = new ArrayList<HashMap<Object, Object>>();
			
			System.out.println("Total Number Of Columns " + Columncount);
			System.out.println("Total Number Of Columns " + rowcount);
				rs.beforeFirst();	
			for (int i = 1; i <= rowcount; i++) 
			{
				if (rs.next()) 
				{
					System.out.println("============================Record number"+ i);
					for (int j = 1; j <= Columncount; j++) 
					{
						keys = rsMD.getColumnName(j);
						values = rs.getString(j);
					}
				}
				hashMap.put(keys, values);
			}
			hashMap1.putAll(hashMap);//(Map<keys, values>);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		finally 
		{
			conn.close();
			stmt.close();
			rs.close();
			if (conn != null)
				conn.close();
			System.out.println("===============================");
			System.out.println(".....  conn has closed.........");
		}
		return (HashMap) hashMap1;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws SQLException
	{
		String q= "select id,phase_name,phase_status,created_by,bill_name,BULK_LOAD_IDENTIFIER "
				+ "from containers(BI_JOB) where ID in (102100,104100,105100)";//

		HashMap<Object,Object> abc=new HashMap<Object, Object>(callDB(q));		
		for (Map.Entry ankit : abc.entrySet()) 
		{
			System.out.println(ankit.getKey() + " - "
					+ ankit.getValue());}
		}
	}