package javaScript;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

@SuppressWarnings("unused")
public class seleniumEmail {

	static List<String> fileList;

	private static final String OUTPUT_ZIP_FILE = ".\\test-output\\output.zip";
    private static File SOURCE_FOLDER = new File(".\\test-output\\");
    
    @SuppressWarnings("resource")
	public static void main(String[] agr)
	{
    	fileList = new ArrayList<String>();
    	
		String setpath=".\\test-output\\";
		File file=new File(setpath);
		String zipFileName = file.getName().concat(".zip");

			try 
			{
				FileOutputStream fos = new FileOutputStream(zipFileName);
		        ZipOutputStream zos = new ZipOutputStream(fos);
		        ZipEntry e=new ZipEntry(".\\test-output\\output.zip");
		        zos.putNextEntry(e);
			// Create the attachment
				EmailAttachment attachment = new EmailAttachment();
			//	attachment.setPath("C:\\External_jars\\commons-email-1.4\\LICENSE.txt");
				attachment.setPath(".\\test-output\\");
				attachment.setDisposition(EmailAttachment.ATTACHMENT);
				attachment.setDescription("output.zip");
				attachment.setName("test_output.zip");
	
			// Create the email message
				MultiPartEmail email=new MultiPartEmail();
				email.setHostName("smtp.gmail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator("mittal.ankit91@gmail.com", "Ankit@147"));
				email.setSSLOnConnect(true);
				email.setFrom("abc@xyz.com");
				email.setSubject("test");
				email.setMsg("Pelase Find test Report for : ");
				email.addTo("ankit.mittal@tangoe.com");
				email.attach(attachment);
	
			email.send();
			System.out.println("email send");
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
