package self;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class readFile1
{
	public static String str(String filepath) {
		StringBuffer stringBuffer = null;
		try {
			File file = new File(filepath);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
}

public class updateInvioce {
	
	public static void main(String[] args) throws IOException 
	{
				Scanner scanner=new Scanner(System.in);
				System.out.println("Enter Path or press enter for below default path :");
						System.out.println( "(D:/sb340/new template/SBI3_Invoices.txt)");
				String Fpath="D:/sb340/new template/SBI3_Invoices.txt";
				String text=readFile1.str(Fpath);
				
				System.out.println("Enter value or press enter for default value(ANKITINV-)");
				String searchTerm = "ANKITINV-";
								
				String sPattern = Pattern.quote(searchTerm) + "\\w*\\b";
				StringBuilder result = new StringBuilder();
				Pattern pattern = Pattern.compile(sPattern);
			    Matcher matcher = pattern.matcher(text);
			    while (matcher.find()) {
			        result.append(matcher.group()).append(' ');
			    }
			    String fromValue = result.toString().trim();
			    
			    
			    Path path = Paths.get(Fpath);
			    Charset charset = StandardCharsets.UTF_8;
			    
				String content = new String(Files.readAllBytes(path), charset);
				content = content.replaceAll(fromValue, searchTerm+System.currentTimeMillis());
				Files.write(path, content.getBytes(charset));
				System.out.println("File Upadte");
				
				scanner.close();
				
	}
}
