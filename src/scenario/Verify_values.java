package scenario;

import org.junit.Assert;

public class Verify_values 
{
//	public static  boolean verifyText() 
//	{
//		boolean truefalse=Assert.assertTrue(condition);
//		return truefalse;
//		
//	}
	
	public Verify_values(String string)
	{
			try
			{
				Assert.assertFalse("message", 1==2);
				System.out.println();
				
			}
			catch(Error e)
			{
				System.out.println(e.getMessage());
			}
	}
	public static void main(String[] args) {
		new Verify_values("messahe");
		}
	public static void Verify_Text() {
		// TODO Auto-generated method stub
		
	}
	}