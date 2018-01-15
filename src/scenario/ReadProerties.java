package scenario;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class ReadProerties {
	private static Properties pageElementProperties = new Properties();
	@SuppressWarnings("rawtypes")
	// ThreadLocal class in Java enables you to create variables that can only
	// be read and written by the same thread. Thus, even if two threads are
	// executing the same code, and the code has a reference to a ThreadLocal
	// variable, then the two threads cannot see each other's ThreadLocal
	// variables
	private static ThreadLocal threadLocalFileName = new ThreadLocal();

	@SuppressWarnings("unchecked")
	public static Properties getObjectRepository(String propfilepath)
	{
		try{
		URL url = ReadProerties.class.getClassLoader()
				.getResource(propfilepath);
		//Uniform Resource Identifier (URI) 
		File fileinfolder = new File(url.toURI());
		String[] filesinDir = fileinfolder.list();

		if (filesinDir != null) {
			String fname = "";
			for (int i = 0; i < filesinDir.length; i++) {
				fname = filesinDir[i];
				if (!fname.contains(".")) {
					getObjectRepository(propfilepath + "/" + fname);
				} else if (fname.endsWith(".properties")) {
					threadLocalFileName.set(fname);
					fname = fileinfolder + "\\" + fname;
					pageElementProperties.load(new FileInputStream(new File(
							fname)));
				}
			}
		}
	}catch(Exception e)
	{e.getStackTrace();
		}
		return pageElementProperties;

	}
	public static String[] propsObjectsSplit(String objectname)
	 {
		int lng = getObjectRepository("\\Objects").getProperty(objectname)
				.split("=").length;
		// use ternary operator to initialize
		int aa = (lng > 2) ? 2 : lng;

		String[] values = getObjectRepository("\\Objects").getProperty(
				objectname).split("=", aa);
		return values;
	}
}
