package com.pomkart.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xl_Utils {

	public FileOutputStream out;
	public FileInputStream f;
	private XSSFWorkbook w;
	private XSSFSheet s;
	private XSSFRow r;
	private XSSFCell c;
	
	public Xl_Utils() {
		//http://cucumber.github.com/cucumber-eclipse/update-site
		try {
			f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData/POMData.xlsx");
			w=new XSSFWorkbook(f);
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	//Reads data from excel
	public String getCellData(String sheetName,int colNum,int rowNum) {
		try {
			s=w.getSheet(sheetName);
			r=s.getRow(rowNum);
			c=r.getCell(colNum);
			
			return c.getStringCellValue();
		}catch(Exception e) {
			return w+"Workbook not exist"+s+"sheet Not exist"+r+"row not exist"+c+"cell not exist";
		}
		
	}
	//Writes data inti excel
	public void setCellData(String sheetName,String colName,String data,String tcName) {
		try {
			s=w.getSheet(sheetName);
			r=s.getRow(0);
			
			int tcStartRow=0;
			while(!getCellData(sheetName, 0, tcStartRow).equals(tcName)) {
				tcStartRow++;
			}
			
			System.out.println("row is : "+tcStartRow);
			r =s.getRow(tcStartRow+1);
			int colNum=0;
			for(int i=0;i<r.getLastCellNum();i++) {
				System.out.println(r.getCell(i).getStringCellValue());
				if(r.getCell(i).getStringCellValue().equals(colName)) {
					colNum=i;
					break;
				}
			}
			System.out.println("colNum is : "+colNum);
			s.autoSizeColumn(colNum);
			//r=s.createRow(tcStartRow+2); 
			r=s.getRow(tcStartRow+2);
			//c=r.createCell(colNum);
			c=r.getCell(colNum);
			c.setCellValue(data);
			
			out=new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/TestData/POMData.xlsx");
			w.write(out);
			f.close();
			
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	 // returns the row count in a sheet
	 public int getRowCount(String sheetName){
	  int index = w.getSheetIndex(sheetName);
	  if(index==-1)
	   return 0;
	  else{
	  s = w.getSheetAt(index);
	  int number=s.getLastRowNum()+1;
	  return number;
	  }
	  
	 }
	 
	 // adds sheet to workbook
	 public boolean addSheet(String  sheetname){  
	  
	  FileOutputStream fileOut;
	  try {
	    w.createSheet(sheetname); 
	    fileOut = new FileOutputStream("");
	    w.write(fileOut);
	       fileOut.close();      
	  } catch (Exception e) {   
	   e.printStackTrace();
	   return false;
	  }
	  return true;
	 }
	 //removes sheet from workbook
	 public boolean removeSheet(String sheetName){  
		  int index = w.getSheetIndex(sheetName);
		  if(index==-1)
		   return false;
		  
		  FileOutputStream fileOut;
		  try {
		   w.removeSheetAt(index);
		   fileOut = new FileOutputStream("");
		   w.write(fileOut);
		      fileOut.close();      
		  } catch (Exception e) {   
		   e.printStackTrace();
		   return false;
		  }
		  return true;
		 }
	 
	 //Adds a column to workbook sheet
	 public boolean addColumn(String sheetName,String colName){
		  
		  try{    
		  
		   int index = w.getSheetIndex(sheetName);
		   if(index==-1)
		    return false;
		   
		 	  
		  s=w.getSheetAt(index);
		  
		  r = s.getRow(0);
		  if (r == null)
		   r = s.createRow(0);
		  
		  if(r.getLastCellNum() == -1)
		   c= r.createCell(0);
		  else
		   c = r.createCell(r.getLastCellNum());
		         
		         c.setCellValue(colName);
		         
		         out = new FileOutputStream("");
		   w.write(out);
		      out.close();      

		  }catch(Exception e){
		   e.printStackTrace();
		   return false;
		  }
		  
		  return true;
		  
		 }
	 
	// removes a column and all the contents
	 public boolean removeColumn(String sheetName, int colNum) {
	  try{
 
	  s=w.getSheet(sheetName);
	 
	  for(int i =0;i<getRowCount(sheetName);i++){
	   r=s.getRow(i); 
	   if(r!=null){
	    c=r.getCell(colNum);
	   
	     r.removeCell(c);
	    }
	   }
	  
	  out = new FileOutputStream("");
	  w.write(out);
	     out.close();
	  }
	  catch(Exception e){
	   e.printStackTrace();
	   return false;
	  }
	  return true;
	  
	 }
	
	// find whether sheets exists 
	 public boolean isSheetExist(String sheetName){
	  int index = w.getSheetIndex(sheetName);
	  if(index==-1){
	   index=w.getSheetIndex(sheetName.toUpperCase());
	    if(index==-1)
	     return false;
	    else
	     return true;
	  }
	  else
	   return true;
	 }
	 
	// returns number of columns in a sheet 
	 public int getColumnCount(String sheetName){
	  // check if sheet exists
	  if(!isSheetExist(sheetName))
	   return -1;
	  
	  s = w.getSheet(sheetName);
	  r = s.getRow(0);
	  
	  if(r==null)
	   return -1;
	  
	  return r.getLastCellNum();
	 }
	 
	public static void main(String[] args) {
		Xl_Utils x=new Xl_Utils();
		x.setCellData("Sheet1", "col5", "Hello", "TC3");
	}
}
