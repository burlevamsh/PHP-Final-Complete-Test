package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSLFile {

	public static Object[][] getXLSXFile(String fileName) {
		Object[][] data = null;
		File file = new File(fileName);
		try {
			FileInputStream fis = new FileInputStream(file);

			Workbook workbook = new XSSFWorkbook(fis);
			
			Sheet sheet1 = workbook.getSheet("Sheet1");
			

			int totalRows = (sheet1.getLastRowNum() - sheet1.getFirstRowNum()) + 1;

			List<String[]> lines = new ArrayList<String[]>();

			for (int i = 0; i < totalRows; i++) {
				Row row = sheet1.getRow(i);
				int totalCols = row.getLastCellNum() - row.getFirstCellNum();
				String[] line = new String[totalCols];
				for (int j = 0; j < totalCols; j++) {
					Cell cell = row.getCell(j);
					if(cell.getCellType()==CellType.STRING)
					line[j] = cell.getStringCellValue();
					
			}
				lines.add(line);
			}
			String[][] sdata = new String[lines.size()][0];
			data = lines.toArray(sdata);
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;

	}

}
