package scenario;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;

/**
 * @author Ankit.Mittal
 *
 */
public class ReadFromWorkbook {


	public static ArrayList<ArrayList<String>> cellval(String FileName) throws Exception {

		String[] file_name=ReadProerties.propsObjectsSplit(FileName);

		FileInputStream productname = new FileInputStream("./SourceFiles/"+file_name[0]);

		Workbook wb = WorkbookFactory.create(productname);

		Sheet sh = wb.getSheetAt(0);
		Iterator<Row> itrrow = sh.rowIterator();
		
		Row row;
		Cell cell;
		
		ArrayList<ArrayList<String>> rowvalue=new ArrayList<ArrayList<String>>();

		DataFormatter dataFormatter=new DataFormatter();	
		
		while (itrrow.hasNext()) {
			row = itrrow.next();
			if(row.getRowNum()>0)
			{
				ArrayList<String> cellvalue=new ArrayList<String>();
				Iterator<Cell> Itrcell=row.cellIterator();

				System.out.println(Itrcell);
				while(Itrcell.hasNext())
				{
					cell=Itrcell.next();
					cellvalue.add(dataFormatter.formatCellValue(cell));						
				}	
			rowvalue.add(cellvalue);
			}
		}
		
		return rowvalue;

	}
}