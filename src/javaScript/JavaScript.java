package javaScript;

public class JavaScript {
	public static void main(String[] args) {
		String json="[{'name':'billing telephone number','value':'3413576848'},"
				+ "{'name':'billing telephone number','value':'3413576848'}]";
		String NewJson= json.replace("]", "").replace("[", "").replace("{", "").replace("}", "").replace("'", "");
		
		for(String string1:NewJson.split(",",0))
		{
			for (String string3:string1.split(":",0))
			{
				System.out.print(string3+"   ");
			}
			System.out.println("");
		}
		
		
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);",SetMethod.select(sElement));
	}
}
