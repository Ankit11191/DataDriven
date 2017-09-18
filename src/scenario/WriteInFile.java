package scenario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WriteInFile {
	private static File f = null;

	public static void writing(String text) throws IOException
	{
		String fileName = new SimpleDateFormat("yyyyMMdd'.txt'")
				.format(Calendar.getInstance().getTime());
		f = new File(".\\OutPutFiles\\" + fileName);

		if (!f.exists()) 
		{
			f.createNewFile();
		}	
			
		FileWriter Fwriter =new FileWriter(f,true);
		BufferedWriter Bwriter=new BufferedWriter(Fwriter);
		Bwriter.write("\n"+text);
		Bwriter.close();
	}	
}
