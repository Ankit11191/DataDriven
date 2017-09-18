package scenario;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Proivder {

	//String filename="DataProvider.xls";
	
	@Test(dataProvider="rovider")
	public void show(Object tion, Object alue)
	{
		System.out.println(tion);
		System.out.println(alue);
		System.out.println("*********************************************");
	}

	@DataProvider(name="rovider")
	public static Object[][] dataProvider()
		{
		Object[][] info=null;
			try {
				FileInputStream fileInputStream = new FileInputStream(".\\SourceFiles\\DataProvider.xls");
				Workbook workbook=WorkbookFactory.create(fileInputStream);
				Sheet sheet=workbook.getSheet("dataprovider");
				int rowcount=sheet.getPhysicalNumberOfRows();
				int columnCount=sheet.rowIterator().next().getPhysicalNumberOfCells();
				info=new Object[rowcount-1][columnCount];

				for(int i=1;i<rowcount;i++)
				{
					Row row=sheet.getRow(i);
					for(int j=0;j<columnCount;j++)
					{
						Cell cell=row.getCell(j);
						 switch (cell.getCellType())
						 {						 
						 case Cell.CELL_TYPE_STRING:
							 	info[i-1][j]=cell.getStringCellValue();
							 break;

						 case Cell.CELL_TYPE_NUMERIC:
							 	info[i-1][j]=cell.getNumericCellValue();
							 break;
						 default:
							 	info[i-1][j]=cell.getDateCellValue();
							 break;
						 }
					}
				}			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return info;
		}
}
