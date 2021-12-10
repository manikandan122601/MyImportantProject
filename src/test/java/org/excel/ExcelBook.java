package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelBook {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\Mani\\eclipse-workspace" 
				+ "\\Sample\\ExcelBook\\SERVICE BLOCK -PSP HOSPITAL HEATLOAD ESTIMATION 107 Deg C.xlsx");
		
		FileInputStream fin = new FileInputStream(f);
		     		
		Workbook w =new XSSFWorkbook(fin);
		
		Sheet s = w.getSheet("CSSD");
		
//		Row r = s.getRow(4);
//		
//		Cell c = r.getCell(8);
//		
//		System.out.println(c);
//		
		// physical number of rows 
		
		int prows = s.getPhysicalNumberOfRows();
		System.out.println("physical num of rows: " +prows); 
		
		Row r = s.getRow(5);
		
		int pcell = r.getPhysicalNumberOfCells();
		System.out.println("physical num of cell:"+ pcell);
		
		for(int i =0; i<s.getPhysicalNumberOfRows(); i++) {
			
			Row row = s.getRow(i);
		for(int j=0; j<row.getPhysicalNumberOfCells(); j++)	{
			
			Cell cell = row.getCell(j);
			
			// 1 ----> string
			// 0 ----> int or date
		int cellType = cell.getCellType();	
		if(cellType==1) {
			String value = cell.getStringCellValue();
			System.out.println(value);
					
		}
		else if (cellType==0) {
//			dateutil---> class
//			iscelldateformated-method-boolean
			if(DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd, MMMM, yyyy");
				String value = sim.format(d);
				System.out.println(value);
			}else {
				
				double d = cell.getNumericCellValue();
//				typecasting----> double to long
				
				long l = (long)d;
				 
				// long to string
				
				String value = String.valueOf(l);
				System.out.println(value);
				
			}
			
		}
				
		}
		
	}
	
	}
	
}
