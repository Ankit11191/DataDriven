/**
 * 
 */
package readTestcases;

import java.util.ArrayList;



import org.apache.poi.ss.usermodel.Cell;

/**
 * @author Ankit.Mittal
 *
 */
public class Read 
{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void readForTestCase(ArrayList SD) throws Exception {
		for (int i = 1; i < SD.size(); i++) {

			ArrayList<Object> row = (ArrayList<Object>) SD.get(i);
		//		Iterator<Row> row = sh.rowIterator();
			for (int j = 0; j <row.size(); j++) {
//				ArrayList<Object> Column = (ArrayList<Object>) SD.get(j);
				Cell[] cell0= (Cell[]) row.get(j);
//				int value=cell0.getColumnIndex();
//				Iterator<Cell> celliterator= (Iterator<Cell>) cell0.;
				
				System.out.print(cell0[1].toString());
//				System.out.print(" " + cellvalue1);
//				System.out.print(" " +cellvalue2);
				
			}
			System.out.println("");
		}
	}
}
