package unusedScenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class LoadProperties {

	private static Properties pageElementProperties = new Properties();
	@SuppressWarnings("rawtypes")
	private static ThreadLocal threadLocalFileName = new ThreadLocal();

	@SuppressWarnings("unchecked")
	public Properties loadpros(String propfilepath) throws URISyntaxException,
			FileNotFoundException, IOException 
		{
		URL url = getClass().getClassLoader().getResource(propfilepath);
		File fileinfolder = new File(url.toURI());
		String[] filesinDir = fileinfolder.list();

		if (filesinDir != null) {
			String fname = "";
			for (int i = 0; i < filesinDir.length; i++) 
			{
				fname = filesinDir[i];
				if (!fname.contains(".")) 
				{
					loadpros(propfilepath + "/" + fname);
				}
				else if (fname.endsWith(".properties")) 
				{
					threadLocalFileName.set(fname);
					fname = fileinfolder + "\\" + fname;
					pageElementProperties.load( new FileInputStream(new File(fname)));
				}
			}
		}
		return pageElementProperties;
	}
}
