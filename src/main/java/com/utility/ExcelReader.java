package com.utility;

import java.io.FileInputStream;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	//public static final String EXCELFILELOCATION = "./Data.xlsx";
		public static final String FILELOCATION = ("C:\\Users\\workspace\\AutomationTest\\TestData\\Data.xlsx");
		private static FileInputStream fis;
		private static XSSFWorkbook workbook;
		private static XSSFSheet sheet;
		private static XSSFRow row;
		
	    public static void loadExcel() throws Exception{
	    	System.out.println("Excel Data loding...");

	    	File file = new File(FILELOCATION);
	    	fis = new FileInputStream(file);
	    	workbook = new XSSFWorkbook(fis);
	    	sheet = workbook.getSheet("TestData");
	    	fis.close();
	    }
	    
	    public static Map<String,Map<String, String>> getData() throws Exception{
	    	
	    	if (sheet == null){
	    		loadExcel();
	    	}
	    	
	    	Map<String,Map<String, String>> superMap = new HashMap<String,Map<String, String>>();
	    	Map<String, String> DataMap = new HashMap<String, String>();
	    	
	    	for(int i=1;i < sheet.getLastRowNum() +1; i++){
	    		row = sheet.getRow(i);
	    	String keyCell = row.getCell(0).getStringCellValue();
	   
	    	int colNum = row.getLastCellNum();
	    	for(int j=1; j<colNum; j++){
	    		String Value = row.getCell(j).getStringCellValue();
	    		
	    		DataMap.put(keyCell, Value);
	    	}
	    	
	    	superMap.put("MasterData", DataMap);
	    	
	    	
	    	}
	    	return superMap;
	    }
	    
	    public static String getValue(String Key) throws Exception{
	    	Map<String, String> Data_Map = getData().get("MasterData");
	    	String r_Value = Data_Map.get(Key);
	    	
	    	return r_Value;
	    }
	    
	    public static void main(String[] args) throws Exception{
	    	System.out.println(getValue("baseUrl"));
	    }

}
