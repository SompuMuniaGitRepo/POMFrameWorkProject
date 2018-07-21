package com.dd.crm.pom.util;

import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReturnTwoDObjArray {
	
	public static Object [] [] getObjArrayData (String testname, ExcelFunctions xls) {
		
		int testStartRowNum = 1;
		while(!xls.getCellData("Data", 0, testStartRowNum).equalsIgnoreCase(testname))  {
			testStartRowNum ++;
		}
		System.out.println("Row number of test is  = " +testStartRowNum);
         
	     int colStartRowNum = testStartRowNum + 1;
	     int totColsNum = 0;
	     
	     while(!xls.getCellData("Data", totColsNum, colStartRowNum).equals("")) {
	    	 totColsNum ++;
	     }
		
		System.out.println("Total number of columns" +totColsNum);
		int dataStartRowNum = testStartRowNum + 2;
		int totRows = 0;
		
		while(!xls.getCellData("Data",0, dataStartRowNum).equals(""))  {
			dataStartRowNum++;
			totRows ++;
		}
		
		System.out.println("Total number of rows = " +totRows);
		dataStartRowNum = testStartRowNum + 2;
		int finalrows = dataStartRowNum +totRows;
		Hashtable <String, String> table = null;
		Object [] [] myData = new Object [totRows][1];
		int i = 0;
		for(int rnum = dataStartRowNum; rnum <  finalrows; rnum++) {
			   table = new Hashtable <String, String> ();
	           for(int cnum = 0; cnum < totColsNum; cnum ++)  {
	        	   String data = xls.getCellData("Data", cnum, rnum);
	 //       	   System.out.print(data);
	        	   String key =  xls.getCellData("Data", cnum, colStartRowNum);
	//        	   System.out.print(key + "-" + data + "  ||  ");
	        	   table.put(key, data);
	        	   
	        	   
	           }
	           
	           System.out.println(table);
	           myData [i] [0] = table;
        	   i++;
	           System.out.println();
	           System.out.println("---------------------------------------------------------------------");
		}	

	//	return ReturnTwoDObjArray.getObjArrayData(rowname, readexcelsheet);
		return myData;

	}
//	return myData;

		
	}

