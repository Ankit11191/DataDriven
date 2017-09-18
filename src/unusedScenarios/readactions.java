package unusedScenarios;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import scenario.BaseClass;
import scenario.ReadFromWorkbook;
import scenario.methodFactory;

public class readactions extends BaseClass {

	static final Logger logger=Logger.getLogger(readactions.class);
	@Test
	public static void values() throws Exception {
		
		PropertyConfigurator.configure("log4j.properties");
		
		ArrayList<ArrayList<String>> name=ReadFromWorkbook.cellval("TC_File_name");
		ArrayList<String> inner=new ArrayList<String>();
		for(int i=0;i<name.size();i++)
		{
			inner= name.get(i);	
			String[] ivalue=inner.toArray(new String[0]);
			System.out.println(i+":"+inner);
			methodFactory.methods(ivalue);
			logger.info(i+":"+inner);
		}
	}
}