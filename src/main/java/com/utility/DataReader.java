package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	//public static DataReader ExcelObj;
	
	public static Object[][] getExceData(String Sheetname) throws Exception {

	    File file = new File("C://Users//Q846130//OneDrive - IQVIA//Desktop//EAF//Test_Data.xlsx");
	    FileInputStream fis = new FileInputStream(file);

	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheet(Sheetname);
	    //wb.close();
	    int lastRowNum = sheet.getLastRowNum() ;
	    int lastCellNum = sheet.getRow(0).getLastCellNum();
	    int col_num=0;
	    Object[][] obj = new Object[lastRowNum][1];

	    for (int i = 0; i < lastRowNum; i++) {
	      Map<Object, Object> datamap = new HashMap<Object, Object>();
	      for (int j = 0; j < lastCellNum; j++) {
	      datamap.put(sheet.getRow(i).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
	      }
	      obj[i][0] = datamap;

	    }
	    return  obj;
	  }
 
	}
	


