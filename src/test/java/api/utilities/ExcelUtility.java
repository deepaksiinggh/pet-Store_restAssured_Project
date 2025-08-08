package api.utilities;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public String path;
	public FileInputStream fs;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int getrowCount(String sheetName) throws IOException {
		fs = new FileInputStream(path);
		wb = new XSSFWorkbook(fs);
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		wb.close();
		fs.close();
		System.out.println(rowCount);
		return rowCount;	
	}
	
	
	public int getcellCount(String sheetName,int rowNum) throws IOException {
		fs = new FileInputStream(path);
		wb = new XSSFWorkbook(fs);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		fs.close();
		wb.close();
		return cellCount;
		
	}

	public String getcellData(String sheetName,int rownum,int colnum ) throws IOException {
		fs =new FileInputStream(path);
		wb = new XSSFWorkbook(fs);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data=" ";
		}
		
		wb.close();
		fs.close();
		
		return data;
		
	}
	
	
}
