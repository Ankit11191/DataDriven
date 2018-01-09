/**
 * 
 */
package scenario;

/**
 * @author Ankit.Mittal
 *
 */
public class WriteIntoExcelSheet {

public static void writeIntoFile(int rowcount, int colCount, String filename) {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("JavaBook");

		int rowCount = 0;

		ArrayList<ArrayList<Object>> bookData = writeInExcel.createdata(rowcount, colCount, "");

		for (ArrayList<Object> aBook : bookData) {
			Row row = sheet.createRow(rowCount++);

			int columnCount = 0;

			for (Object field : aBook) {
				Cell cell = row.createCell(columnCount++);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

		}

		String filepath = System.getProperty("user.dir") + "\\OutputFiles\\" + filename + ".xls";
		String zipFileName = filepath+".zip";
		
		if (new File(filepath).canWrite()) {
			System.out.println("file is open, Please close your excel file " + filename + " to write new content");
		} else {
			try (FileOutputStream outputStream = new FileOutputStream(filepath)) {
				workbook.write(outputStream);
				System.out.println("Successfully write into excel file " + filename
						+ " which available at following path" + filepath +" in zipped format");
				outputStream.close();
				zipFile(new File(filepath), zipFileName);
				new File(filepath).delete();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<ArrayList<Object>> createdata(int rowcount, int colCount, Object data) {
		ArrayList<ArrayList<Object>> rowData = new ArrayList<ArrayList<Object>>();
		for (int i = 0; i < rowcount; i++) {
			ArrayList<Object> coldata = new ArrayList<Object>();

			for (int j = 0; j < colCount; j++) {
				coldata.add(i + j);
			}
			rowData.add(coldata);
		}
		return rowData;
	}
	
********************//Start To Zip generated file at same location//************************************
	 private static void zipFile(File file, String zipFileName) {
	        try {
	            FileOutputStream fos = new FileOutputStream(zipFileName);
	            ZipOutputStream zos = new ZipOutputStream(fos);
	            
	            ZipEntry ze = new ZipEntry(file.getName());
	            zos.putNextEntry(ze);

	            FileInputStream fis = new FileInputStream(file);
	            byte[] buffer = new byte[1024];
	            int len;
	            while ((len = fis.read(buffer)) > 0) {
	                zos.write(buffer, 0, len);
	            }
	            
	            zos.closeEntry();

	            zos.close();
	            
	            fis.close();
	            
	            fos.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
********************//End To Zip generated file at same location//************************************
}
