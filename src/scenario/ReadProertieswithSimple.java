package com.cucumber.framework.configreader;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class ReadProerties  {
	static Properties pageElementProperties = new Properties();
	private static Properties getObjectRepository(String propfilepath)
	{
		try{
		URL url = new Object(){}.getClass().getClassLoader().getResource(propfilepath);

		File fileinfolder = new File(url.toURI());
		String[] filesinDir = fileinfolder.list();

		if (filesinDir != null) {
			String fname = "";
			for (int i = 0; i < filesinDir.length; i++) {
				fname = filesinDir[i];
				if (!fname.contains(".")) {
					getObjectRepository(propfilepath + "/" + fname);
				} else if (fname.endsWith(".properties")) {
					pageElementProperties.load(new FileInputStream(new File(fileinfolder + "/" + fname)));	
				}
			}
		}
	}catch(Exception e)
	{e.getStackTrace();
		}
		return pageElementProperties;
	}
	
	public static String[] propsObjectsSplit(String objectname, int totalSeparate)
	 {		
			return getObjectRepository("\\resources").getProperty(objectname).split("=",totalSeparate);
	 }
	public static String[] propsObjectsSplit(String objectname)
	 {		
		try
		{
			return getObjectRepository("\\resources").getProperty(objectname).split("=");
		}
		catch(NullPointerException e)
        {
			return null;
        }
	 }
	public static void main(String[] args) {
		if(propsObjectsSplit("username")!= null)
		{
			for(String aaa:propsObjectsSplit("username")) 
			{
				System.out.println(aaa);
			}
		}
		else
		{
			System.out.println("Please enter correct object key");
		}
	}
}
