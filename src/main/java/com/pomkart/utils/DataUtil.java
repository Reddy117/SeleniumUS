package com.pomkart.utils;

import java.util.Hashtable;

public class DataUtil {

	public static Object[][] getData(String tcName,String sheetName,Xl_Utils x){
		
		int tcStartRow=0;
		
		while(!x.getCellData(sheetName, 0, tcStartRow).equals(tcName)) {
			tcStartRow++;
		}
		
		//System.out.println(tcStartRow);
		
		int cols=0;
		int colStartRow=tcStartRow+1;
		
		while(!x.getCellData(sheetName, cols, colStartRow).equals("N")) {
			cols++;
		}
		
	//	System.out.println(cols);
		
		int rows=0;
		int dataStartRow=tcStartRow+2;
		
		while(!x.getCellData(sheetName, 0, dataStartRow+rows).equals("N")) {
			rows++;
		}
	//	System.out.println(rows);
		Object[][] data=new Object[rows][1];
		int index=0;
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRow;rNum<dataStartRow+rows;rNum++) {
			table=new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++) {
				//data[index][cNum]=data[index][cNum]=x.getCellData(sheetName, cNum, rNum);
				String key=x.getCellData(sheetName, cNum, colStartRow);
				String value=x.getCellData(sheetName, cNum, rNum);
				//System.out.println(value);
				table.put(key, value);
			}
			data[index][0]=table;
			index++;
		}
		return data;
		
	}
}
