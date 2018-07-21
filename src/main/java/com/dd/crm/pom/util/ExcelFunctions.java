package com.dd.crm.pom.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctions {
    public String filename = null;
    public String filepath = null;
    public FileInputStream inputstream = null;
    public FileOutputStream outputstream = null;
    private XSSFWorkbook newWorkbook = null;
    private XSSFWorkbook newdestWorkbook = null;
    private XSSFSheet newSheet = null;
    private XSSFSheet newdestSheet = null;
    private XSSFRow newRow = null;
    private XSSFRow destRow = null;
    private XSSFCell newCell = null;
    private XSSFCell destCell = null;
    private File file = null;
    
    
    public ExcelFunctions(String filename) {
    	 file = new File(filename);
    	try {
    		inputstream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("im in fileinputsteam block & exception is --" +e.getMessage());
		}
    	  
    	try {
			newWorkbook = new XSSFWorkbook(inputstream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   // 	newSheet = newWorkbook.getSheetAt(0);
   // 	try {
	//		newWorkbook.write(inputstream);
	//	} catch (IOException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//		System.out.println("im in workbook creation block & exception is --" +e.getMessage());
	//	}
    	
  //  	if(inputstream != null) {
   // 		try {
    //			inputstream.close();
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//			System.out.println("im in closing fileinputsteam block & exception is --" +e.getMessage());
		//	}
   // 	}
    	
   // 	if(newWorkbook != null) {
    //		try {
    //			newWorkbook.();
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//			System.out.println("im in newWorkbook clsoing block & exception is --" +e.getMessage());
		//	}
    //	}
    } 
    
    public int getRowCount(String sheetname) {
    	int index = -1;
    //	int index = newWorkbook.getSheetIndex(sheetname);
    //	if (index == -1) {
    //		System.out.println("In if block");
    //		return 0;
    //	}
    //	else {
    //		System.out.println("In else block");
    	     newSheet = newWorkbook.getSheet(sheetname);
    	     int rowcount = newSheet.getLastRowNum();
 //   	System.out.println("No of rows in Sheet"+ sheetname +"--" +rowcount +1);
    	     return (rowcount +1);
   	}
    
    public String getCellData(String sheetname, String colname, int rownum) {
    	int col_num = -1;
    	 newSheet = newWorkbook.getSheet(sheetname);
    	 newRow = newSheet.getRow(1);
    	 for (int count = 0; count < newRow.getLastCellNum(); count++) {
    		 if (newRow.getCell(count).toString().trim().equalsIgnoreCase(colname.trim()))  {
    			 System.out.println("Column name matched found in col # --" +count);
    			 col_num = count;
    			 break;
    		 }
    		 else {
    			 System.out.println("No col name match found");
    			 System.out.println("Column name is --- " +colname);
    		 }
    	 }
    	 newRow = newSheet.getRow(rownum - 1);
    	 newCell = newRow.getCell(col_num);
    	 String cellData = newCell.toString();
    	 return cellData;
    }	 
    	 public String getCellData(String sheetName,int colNum,int rownum){
    			try{
    				if(rownum <=0)
    					return "";
    			
    			int index = newWorkbook.getSheetIndex(sheetName);

    			if(index==-1)
    				return "";
    			
    		
    			newSheet = newWorkbook.getSheetAt(index);
    			newRow = newSheet.getRow(rownum-1);
    			if(newRow==null) {
    				return "";
    			}
    			
    			newCell = newRow.getCell(colNum);
    			if(newCell==null) {
    				return "";
    				
    			}
    			
    			
    	//if(newCell.getCellType()==Cell.CELL_TYPE_STRING)
    			else {
    			  return newCell.getStringCellValue();
    			  
    			}  
   // 		  else if(newCell.getCellType()==Cell.CELL_TYPE_NUMERIC || newCell.getCellType()==Cell.CELL_TYPE_FORMULA ){
    			  
   // 			  String cellText  = String.valueOf(newCell.getNumericCellValue());
    			 /* if (HSSFDateUtil.isCellDateFormatted(cell)) {
    		           // format in form of M/D/YY
    				  double d = cell.getNumericCellValue();

    				  Calendar cal =Calendar.getInstance();
    				  cal.setTime(HSSFDateUtil.getJavaDate(d));
    		            cellText =
    		             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
    		           cellText = cal.get(Calendar.MONTH)+1 + "/" +
    		                      cal.get(Calendar.DAY_OF_MONTH) + "/" +
    		                      cellText;
    		           
    		          // System.out.println(cellText);

    		         }

    			  */
    			  
  //  			  return cellText;
   /// 		  }else if(newCell.getCellType()==Cell.CELL_TYPE_BLANK)
    //		      return "";
    //		  else 
    //			  return String.valueOf(newCell.getBooleanCellValue());
    			}
    			catch(Exception e){
    				
    				e.printStackTrace();
    				return "row "+rownum+" or column "+colNum +" does not exist  in xls";
    			}
    		}

    
    
    public boolean setCellData(String sheetname, String colname, int rownum, String newdata) throws Exception  {
    	int col_num = -1;
   	 newSheet = newWorkbook.getSheet(sheetname);
   	 newRow = newSheet.getRow(1);
   	 for (int count = 0; count < newRow.getLastCellNum(); count++) {
   		 if (newRow.getCell(count).toString().trim().equalsIgnoreCase(colname.trim()))  {
   			 System.out.println("Column name matched found in col # --" +count);
   			 col_num = count;
   			 break;
   		 }
   		 else {
   			 System.out.println("No col name match found");
   		 }
   	 }
   	 newRow = newSheet.getRow(rownum - 1);
   	 newCell = newRow.getCell(col_num);
   	 String cellData = newCell.toString();
   	 System.out.println("Existing data --" +cellData);
   	 inputstream.close();
   	 
//     File destfile = new File("F:\\Test Data\\Framework\\TestSuiteB.xlsx");
  //   newWorkbook = new XSSFWorkbook();
    outputstream = new FileOutputStream(file);
 //    newWorkbook = new XSSFWorkbook();
  //   newSheet = newWorkbook.getSheet(sheetname); 
  //   newRow = newSheet.getRow(rownum - 1);
//     newCell = newRow.getCell(col_num);
	 
       
 
  //	 outputstream = new FileOutputStream(destfile);
   	 
   	newSheet.autoSizeColumn(col_num);
   	 XSSFCellStyle cs = newWorkbook.createCellStyle();
   	 cs.setWrapText(true);
   	newCell.setCellStyle(cs);
   	newCell.setCellValue(newdata);
   	if ((newCell.getStringCellValue().trim()).equalsIgnoreCase(newdata.trim()))  {
   		System.out.println("New data set successfully");
   		System.out.println(newCell.getStringCellValue().trim());
   //		outputstream = new FileOutputStream(destfile);
  // 		inputstream.close();
   		outputstream.close();
   		newWorkbook.write(outputstream);
 //   	outputstream.close();
   	   
   		return true;
   	}
   	else {
   		System.out.println("New data couldnt be set");
   		return false;
   	}
   	
   	
   		
 }
   	
   	
   	 
    
    
    
    
    
    public static void main(String[] args) throws Exception {
    	System.out.println("In main function");
    	ExcelFunctions xls = new ExcelFunctions("F:\\Test Data\\Framework\\TestSuiteA.xlsx");
   // 	int rowcount = xls.getRowCount("Data");
   // 	System.out.println( xls.getRowCount("Data"));
 //   	System.out.println("No of rows in Sheet--" +rowcount);
    	
  //  	String cellData = xls.getCellData("Data", "Password", 4);
   // 	System.out.println("Cell data in 4th row & Password clumn is --" + cellData);
    	System.out.println(xls.setCellData("Data", "Username", 4, "Hello World"));
    }
}
