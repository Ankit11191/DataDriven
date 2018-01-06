package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class callDataBaseColumnwsie {
	
	static Connection conn = null;
	
	//DB credentials
	final static String URL = "jdbc:postgresql://localhost:5431/";
	final static String Uname = "postgres";
	final static String Pass = "password";
	final static String DBname = "postgres";
	
	//DB Query
	final static String query = "select * from emp";
	
	//Method to call Database column wise
	public static Map<Object, ArrayList<Object>> callDBs(String query) throws SQLException {

		Map<Object, ArrayList<Object>> hashMap = new HashMap<Object, ArrayList<Object>>();

		ResultSet rs = null;
		ResultSetMetaData rsMD;

		try {
			Class.forName("org.postgresql.Driver");

			conn = DriverManager.getConnection(URL + DBname, Uname,Pass);

			rs = conn.createStatement().executeQuery(query);
			rsMD = rs.getMetaData();

			while(rs.next())
			{
	            for(int i=1;i<=rsMD.getColumnCount();i++) {
	                String strColumnName = rsMD.getColumnName(i);
	                Object columnValue = rs.getObject(i);
	                if(hashMap.containsKey(strColumnName)){
	                    hashMap.get(strColumnName).add(columnValue);
	                }else{
	                	ArrayList<Object> resultList = new ArrayList<>();
	                    resultList.add(columnValue);
	                    hashMap.put(strColumnName,resultList);
	                }
	            }
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			conn.close();	rs.close();
			if (conn != null)
				conn.close();
		}
		return hashMap;
	}
	
	public static void main(String[] args) throws SQLException {

		HashMap<Object, ArrayList<Object>> abc = new HashMap<Object, ArrayList<Object>>(callDBs(query));

		for (Map.Entry<Object, ArrayList<Object>> ankit : abc.entrySet()) {
			for(Object value:ankit.getValue()) 
			{
				System.out.print (ankit.getKey() + ":" + value);
			}
			System.out.println();
		}
	}
}
