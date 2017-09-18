package scenario;

import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LinkVerification extends BaseClass 
{

	@Test
	public static void call(){

		List<WebElement> ankit = SetMethod.list(ReadProerties.propsObjectsSplit("links"));

		System.out.println("size"+ankit.size());
			for(int i=0;i<ankit.size();i++)
			{
				verifyLinks(ankit.get(i).getAttribute("href"));
			}

	}
	@SuppressWarnings("static-access")
	public static void verifyLinks(String link)
	{
		try
		{
			URL url=new URL(link);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(3000);
			connection.connect();
			if(connection.getResponseCode()==200)
			{
				System.out.println(link+":"+connection.getResponseCode());
			}
			else
			{
				System.out.println(link+": :"+connection.HTTP_NOT_FOUND);
			}
		}
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
	}

}
