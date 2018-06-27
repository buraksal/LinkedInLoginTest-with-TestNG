package ExcelRead;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	
	XSSFWorkbook wb;
	//To go to Sheet, 0 for Sheet1
	XSSFSheet sheet1;
	/**
	 * @param excelPath Path to Excel File
	 */
	public ExcelDataConfig(String excelPath) {
		
		try
		{
			//Excel Path is given to Java
			File src= new File(excelPath);
			//To Get Information inside Excel as Bytes
			FileInputStream fis= new FileInputStream(src);
			//To Connect Excel
			wb= new XSSFWorkbook(fis);
			
			
		}
		catch(Exception e){
			//Print Error Message
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 
	 * @param sheetNumber SheetNumber of Excel
	 * @param row Row Number of Data
	 * @param column Column Number of Data
	 * @return Data is returned
	 */
	public String getData(int sheetNumber, int row, int column) {
		
		sheet1= wb.getSheetAt(sheetNumber);
		//Gets Data
		String data= sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	/**
	 * 
	 * @param sheetIndex SheetNumber
	 * @return total row number
	 */
	public int getRowCount(int sheetIndex) {
		
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		
		return row;
	
	}
	
	

}
