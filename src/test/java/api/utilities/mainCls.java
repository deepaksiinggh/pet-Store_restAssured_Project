package api.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class mainCls {

	
	public static void main(String[] args) throws IOException {
//		File fs = new File("testData\\Userdata_Generated.xlsx");
//		System.out.println(fs.exists());
//		ExcelUtility el = new ExcelUtility("testData\\Userdata_Generated.xlsx");
//		System.out.println(el.rowCount("Sheet1"));
		
		
//		XSSFWorkbook wb = new XSSFWorkbook("testData\\Userdata_Generated.xlsx");
//		XSSFSheet sheet = wb.getSheet("Sheet1");
//		int rowCount = sheet.getLastRowNum();
//		System.out.println(rowCount);
		
		DataProviders data = new DataProviders();
		String datas[][]= data.getData();
		for(String[] datass:datas) {
			System.out.println(Arrays.toString(datass));
		}
	}
}
