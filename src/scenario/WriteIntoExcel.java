/**
 * 
 */
package scenario;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Ankit.Mittal
 *
 */
public class WriteIntoExcel {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public void write(String fileName, String columnName, String value, String sheetName, String action, int rowNumber
			) throws Exception
	{
		FileInputStream fIS=new FileInputStream(fileName);
		FileOutputStream fOS=null;
		
		Workbook wb=WorkbookFactory.create(fIS);
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.getRow(0);
		Cell cell=null;
				
		int col_Num=-1;
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(columnName))
			{
				col_Num=i;
			}
		}
		if(action=="Insert")
		{
			int newRow=sheet.getPhysicalNumberOfRows();
			row=sheet.getRow(newRow);
			if(row==null)
			{
				row=sheet.createRow(newRow);
			}
		}
		else if(action=="Update")
		{
			int newRow=rowNumber;
			row=sheet.getRow(newRow);
			if(row==null)
			{
				row=sheet.createRow(newRow);
			}
		}
		
		if(col_Num>-1)
		{
			cell=row.getCell(col_Num);
			if(cell==null)
			{
				cell=row.createCell(col_Num);
			}
			
			cell.setCellValue(value);
			fOS=new FileOutputStream(fileName);
			wb.write(fOS);
			System.out.println("success");
			fOS.close();
		}
		else
		{
			System.out.println("Column is not available");
		}
		
	}
	public static void main(String[] args) throws Exception 
	{
		String fileName="D:\\aaa.xlsx";
		String columnName="ankit123";
		String value="abc1";
		String sheetName="Sheet1";
		int rowNumber=3;
		WriteIntoExcel aaa=new WriteIntoExcel();
		if(rowNumber>-1)
		{
			String action="Update";
			aaa.write(fileName, columnName, value, sheetName,action,rowNumber);
		}
		else
		{
			String action="Insert";
			aaa.write(fileName, columnName, value, sheetName,action,rowNumber);
		}
	}

}