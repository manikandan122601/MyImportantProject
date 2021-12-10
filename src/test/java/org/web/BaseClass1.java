package org.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseClass1 {
	
		public static String getData(int rowNumber,int cellNumber) throws IOException {
			
		File f = new File("C:\\Users\\Mani\\eclipse-workspace\\Sample\\ExcelBook\\SERVICE BLOCK -PSP HOSPITAL HEATLOAD ESTIMATION 107 Deg C.xlsx");
		
        FileInputStream fin = new FileInputStream(f);
        
        Workbook w = new XSSFWorkbook(fin);
        
        Sheet s = w.getSheet("CSSD");
        
        Row r = s.getRow(rowNumber);
        
        Cell c = r.getCell(cellNumber);
        
        int cellType = c.getCellType();
        
        String value = " ";
        
        if(cellType == 1) {
        	
        value = c.getStringCellValue();
        } else if (cellType == 0) {
        
        	if (DateUtil.isCellDateFormatted(c)) {
        		Date d = (Date) c.getDateCellValue();
        		
        		SimpleDateFormat sim =new SimpleDateFormat("dd, MMMM, yyyy");
        		
        		value = sim.format(d);
        	} else {
				double d = c.getNumericCellValue();
				long l = (long) d;
				value = String.valueOf(1);
				
			}              		
        	       	
        }
        return value;
        	
        }
  
}		


