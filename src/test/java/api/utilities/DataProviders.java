package api.utilities;

import java.io.IOException;

public class DataProviders {

	public String[][] getData() throws IOException{
		String path = "testData\\Userdata_Generated.xlsx";
		ExcelUtility data = new ExcelUtility(path);
		String sheetName = "Sheet1";
		int row = data.getrowCount(sheetName);
		int  colCount = data.getcellCount(sheetName, 1);
		
		String apiData[][] = new String[row][colCount];
		
		for(int i=1;i<=row;i++) {
			for(int j=0;j<colCount;j++) {
				apiData[i-1][j]=data.getcellData(sheetName, i, j);
			}
		}
		
		return apiData;
	
	}
}
