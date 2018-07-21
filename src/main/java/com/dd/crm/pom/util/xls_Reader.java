package com.dd.crm.pom.util;

    import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.chrome.ChromeDriver;

//	public class ReadExcelFiles {
	public class xls_Reader {
	
		public xls_Reader(String filepath, String filename, String sheetname) {
			// TODO Auto-generated constructor stub
			try {
				excelreadfunction(filepath, filename, sheetname);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			}
			
		}
		
		public xls_Reader() {
			// TODO Auto-generated constructor stub
		}


	//	public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
	            
		//	System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver_win32\\chromedriver_win32_2ndMarch\\chromedriver.exe");
		//	ChromeDriver driver = new ChromeDriver();
		//	driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		//	driver.manage().window().maximize();
			
	//		String filepath = "F:\\Test Data";
	//		xls_Reader readexcelfile = new xls_Reader();
	//		readexcelfile.excelreadfunction(filepath,"Test Excel.xlsx","Resident Details");
	//		
	//	}
	    
		
		public void excelreadfunction(String filepath, String filename, String sheetname) throws IOException {
			
			File file = new File(filepath + "\\" + filename);
			FileInputStream inputstream = new FileInputStream(file);
			Workbook readexcelworkbook = null;
			
			String excelfileextsn = filename.substring(filename.indexOf("."));
			   
			  if (excelfileextsn.equalsIgnoreCase(".xlsx"))  {
				  readexcelworkbook = new XSSFWorkbook(inputstream);
			  }
			  
			  else {
				  if (excelfileextsn.equalsIgnoreCase(".xls"))  {
				  readexcelworkbook = new HSSFWorkbook(inputstream);
			 
				  }
				  
			  }  
			  
			  Sheet readexcelsheet = readexcelworkbook.getSheet(sheetname);
	     	  String rowname = "Login Test";
	//		  String rowname = "Login Test";
	     	  int rowcount = 0;
			  rowcount = readexcelsheet.getLastRowNum() ;
			  System.out.println("Number of rows" +rowcount);
		      int testrowstartnum = 0;
	//	      while(readexcelsheet.)
		      int datarownum = 0;
		      int datastartrownum = 0;
		      int finaldatarownum = 0;
		      int totcolnum = 0;
		      int i = 0;
		      int finalk = 0;
		      Row row = readexcelsheet.getRow(i);
		      
	//	      for (int i = 0; i<rowcount;i++)  {
		      while(row != null) {
	//	    	          if (datarow.getCell(1).getStringCellValue() == "Opera") {
	//	           			            	    break;      
	//	  	   	         }
	//	    	  Row row = readexcelsheet.getRow(i);
	//	    	  System.out.println(row.getCell(i).getStringCellValue());
	//	    	     for (int j = 0; j <row.getLastCellNum(); j++) {
	//		    	    	 System.out.print(row.getCell(j).toString() + "||");
		      
	  //       	         if(row != null && row.getCell(0)!= null && row.getCell(0).toString() !=rowname) {
		    	         if((row == null) && i < rowcount) {
		    	            System.out.println("In 1st if loop");
	        	        	testrowstartnum ++;
	        	        	 
	        	         }
	//	    	         if((row != null) && (row.getCell(0).toString() != "Login Test")) {
	//	    	        	 System.out.println("In 2nd if loop");
	//	    	        	 System.out.println("Test name in 2nd loop:"+ row.getCell(0).toString());
	//	    	        	 testrowstartnum ++;
	//	    	         }
	//	    	         else  {
		    	        	 
		    	        	 if((row != null) && row.getCell(0).toString().equalsIgnoreCase("Login Test") ) {
	         	        	      System.out.println("Match found in row number ----" +testrowstartnum);
	         	        	      System.out.println("Test name ---" +row.getCell(0).toString());
	         	        	      System.out.println("rowname:      " +rowname);
	         	        	      System.out.println("Starting row number for the required data" +testrowstartnum);
	         			          int colrowstartnum = testrowstartnum + 1;
	         			          System.out.println("Starting row number for the columns" +colrowstartnum);
	         			          totcolnum = 0;
	         		//	          for (int i = 0; i<rowcount;i++)  {
	         			          Row colrow = readexcelsheet.getRow(colrowstartnum);
	         			          for(int j =0; j < colrow.getLastCellNum(); j++) {
	         			    	       if(!colrow.getCell(j).toString().equals("")) {
	         			    		         totcolnum++;
	         			    		  
	         			    	       }
	         			          }
	         			      
	         			           System.out.println("Number of data columns" +totcolnum);
	         			           datastartrownum = testrowstartnum + 2;
	         			           datarownum = 1;
	         			           int k =datastartrownum;
	         			           finalk = k-1;
	         			           Row datarow =null;
	//         			       for (int k =datastartrownum; row.getCell(0) != null; k++) {
	         			   
	         				        datarow = readexcelsheet.getRow(finalk);
	         				       System.out.println("Value of k:    " +finalk);
	//         				       while (datarow != null) {
	         				      while ((datarow != null) && (!datarow.getCell(1).getStringCellValue().equals("Opera"))) {
	         					         System.out.println("Inside while loop");
	         					         System.out.println("datarownum---" +datarownum + "       before incrementing finalk" +finalk);
	         					         datarownum++; 
	         					         System.out.println("datarownum---after incrementing" +datarownum );
	         					         finalk++;
	         					         System.out.println(" after incrementing finalk" +finalk);
	         					         datarow = readexcelsheet.getRow(finalk);  
	         					         System.out.println("Browser name ---" + datarow.getCell(1).getStringCellValue()) ;
	         					         if (datarow.getCell(1).getStringCellValue() == "Opera") {
        				            	    break; 				      
	         				       
	         				           }   
	         				       
	         				             System.out.println("Number of data rows-" +(finalk-1));
	         				       }   
	         				        
	       //  				         if (datarow.getCell(1).getStringCellValue() == "Opera") {
         	//			            	    break;      
	        // 				         }
		    	        	 }	       
	    
	         			      
		    	        	 
		 //   	        	        i++;
		    	        	        row = readexcelsheet.getRow(8);
	         			    
	         			    	 
	         			//    	int datastartrownum1 = testrowstartnum + 2;
	         			//    	System.out.println("Data starts at row #-" +datastartrownum);
	         			//    	finaldatarownum = datastartrownum + datarownum;
	         			    	
	         	        	 
	//	    	        	 }
	//         	         }
	     	    	//
		      
		                       int keystartsat = 1;
		                       int datastartsat = 2;
	                           Hashtable <String, String> table = new Hashtable <String, String> ();
		                       for(int itercol = 1; itercol <=5; itercol++)  {
		                    	     Row  keyrow = readexcelsheet.getRow(keystartsat);
		                    	     for(int iterval = 1; iterval <= 5; iterval++)  {
		                    	    	 
		                    	             Row valuerow = readexcelsheet.getRow(datastartsat);
	//	                    	             table =  new Hashtable <String, String> ();
  			                                 String key = keyrow.getCell((iterval-1)).getStringCellValue();
//	    			System.out.print(key +"------");
		                                    String data = valuerow.getCell(iterval-1).getStringCellValue();
			                                table.put(key, data);
	//		                                 datastartsat++;
			                                 System.out.println("Row #---" +itercol + "    Column #---" +(iterval-1));
			                                 System.out.println("Key----" +key+"                Value-------"+data);
		                    	     }
		                    	     System.out.println();
		                    	     System.out.println("------------------------------------------------");
		                    	     datastartsat++;
	                         	}
		                          System.out.println(table);
	//	myData [sel] [1] = table;
	//	sel++;
	//	System.out.println("------------------------------------");
	                }
	
		     }
	
	}
	  


		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		
		
		
	 
	 
	

