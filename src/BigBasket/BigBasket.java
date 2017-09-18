package BigBasket;

import java.io.*;

import org.openqa.selenium.*;

import scenario.BrowserSet;
import scenario.ReadProerties;
import scenario.ScreenShot;
import scenario.ScrollToView;
import scenario.SetMethod;
import scenario.WriteInFile;

public class BigBasket {
	static String value1 = null;

	public static void main(String[] arg) throws Exception 
	{
		BrowserSet.SelectBrowser();
		SetMethod.click(ReadProerties.propsObjectsSplit("select_City"));

		WebElement product = SetMethod.select(ReadProerties
				.propsObjectsSplit("iput"));

		@SuppressWarnings("unused")
		File productname = new File("C://External_jars//selenium-java-2.53.0//"
				+ ReadProerties.propsObjectsSplit("File_name"));

//		Workbook wb = Workbook.Workbook(productname);
//
//		Sheet sh = wb.getSheet(0);
//		int rownum = sh.getRows();
//		int colnum = sh.getColumns();
//		for (int i = 0; i < rownum; i++)
//			for (int j = 0; j < colnum; j++) {
//				WriteInFile.writing(sh.getCell(i, j).getContents());
//				value1 = sh.getCell(i, j).getContents();
//
//			}
		product.sendKeys(value1);

		product.sendKeys(Keys.ENTER);

		ScrollToView stv = new ScrollToView();
		stv.Scrolling(ReadProerties.propsObjectsSplit("product_name"));

		ScreenShot.takesanp();

		String product_name = SetMethod.gettext(ReadProerties
				.propsObjectsSplit("product_name"));
		WriteInFile.writing(product_name);

		String Quantity = SetMethod.gettext(ReadProerties
				.propsObjectsSplit("Quantity"));
		WriteInFile.writing(Quantity);

		String price = SetMethod.gettext(ReadProerties
				.propsObjectsSplit("price"));
		WriteInFile.writing(price);

		BrowserSet.drivreturn().quit();
	}

}