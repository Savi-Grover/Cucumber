package com.ford.auto.managers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderManager {

	private String fileName;
	private String sheetName;
	private int sheetIndex;
	private XSSFWorkbook book;

	public ExcelReaderManager(ExcelReaderBuilder excelReaderBuilder) {
		this.fileName = excelReaderBuilder.fileName;
		this.sheetIndex = excelReaderBuilder.sheetIndex;
		this.sheetName = excelReaderBuilder.sheetName;
	}

	public static class ExcelReaderBuilder {

		private String fileName;
		private String sheetName;
		private int sheetIndex;

		public ExcelReaderBuilder setFileLocation(String location) {
			this.fileName = location;
			return this;
		}

		public ExcelReaderBuilder setSheet(String sheetName) {
			this.sheetName = sheetName;
			return this;
		}

		public ExcelReaderBuilder setSheet(int index) {
			this.sheetIndex = index;
			return this;
		}

		public ExcelReaderManager build() {
			return new ExcelReaderManager(this);
		}

	}

	private XSSFWorkbook getWorkBook(String filePath) throws InvalidFormatException, IOException {
		return new XSSFWorkbook(new File(filePath));
	}

	private XSSFSheet getWorkBookSheet(String fileName, String sheetName) throws InvalidFormatException, IOException {
		this.book = getWorkBook(fileName);
		return this.book.getSheet(sheetName);
	}

	private XSSFSheet getWorkBookSheet(String fileName, int sheetIndex) throws InvalidFormatException, IOException {
		this.book = getWorkBook(fileName);
		return this.book.getSheetAt(sheetIndex);
	}

	public List<List<String>> getSheetData() throws IOException{
		XSSFSheet sheet;
		List<List<String>> outerList = new LinkedList<>();
		
		try {
			sheet = getWorkBookSheet(fileName, sheetName);
			outerList = getSheetData(sheet);
		} catch (InvalidFormatException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			this.book.close();
		}
		return outerList;
	}
	
	public List<List<String>> getSheetDataAt() throws InvalidFormatException, IOException {
		
		XSSFSheet sheet;
		List<List<String>> outerList = new LinkedList<>();
		
		try {
			sheet = getWorkBookSheet(fileName, sheetIndex);
			outerList = getSheetData(sheet);
		} catch (InvalidFormatException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			this.book.close();
		}
		return outerList;
	}

	private List<List<String>> getSheetData(XSSFSheet sheet) {
		List<List<String>> outerList = new LinkedList<>();
		prepareOutterList(sheet, outerList);
		return Collections.unmodifiableList(outerList);
	}

	private void prepareOutterList(XSSFSheet sheet, List<List<String>> outerList) {
		for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
			List<String> innerList = new LinkedList<>();
			XSSFRow xssfRow = sheet.getRow(i);

			for (int j = xssfRow.getFirstCellNum(); j < xssfRow.getLastCellNum(); j++) {
				prepareInnerList(innerList, xssfRow, j);
			}
			outerList.add(Collections.unmodifiableList(innerList));
		}
	}

	public List <HashMap<String,String>> getSheetDataAsMap()
	{
		List <HashMap<String,String>> excelData = new ArrayList<>();
		XSSFSheet sheet;
		try{

			sheet = getWorkBookSheet(fileName, sheetName);
		//catch header row, so that you can use it as Key for your hashmap
		Row HeaderRow = sheet.getRow(0);
	//	 System.out.println("getPhysicalNumberOfRows()" + sheet.getPhysicalNumberOfRows());
		for(int r = 1; r<sheet.getPhysicalNumberOfRows();r++){
		Row CurrentRow = sheet.getRow(r);
		//each row of data is stored in new hashmap
		HashMap<String,String> currentRowMap = new HashMap<String,String>();
		 
		for(int c=0;c<CurrentRow.getPhysicalNumberOfCells();c++){
		//	System.out.println("CurrentRow.getPhysicalNumberOfCells()" + CurrentRow.getPhysicalNumberOfCells());
		Cell CurrentCell = CurrentRow.getCell(c);
		//System.out.print(CurrentCell.getStringCellValue() + "\t");
		currentRowMap.put(HeaderRow.getCell(c).getStringCellValue(),CurrentCell.getStringCellValue());
		// i.e hashmap<key, value> = <row(0)column(c), row(1)column(c)>
		}
		excelData.add(currentRowMap);
		}
//		wb.close();
//		fs.close();
		}
		catch(Exception e){
		e.printStackTrace();
		}
		 
		return excelData;
	}
	
	private void prepareInnerList(List<String> innerList, XSSFRow xssfRow, int j) {
		switch (xssfRow.getCell(j).getCellType()) {

		case BLANK:
			innerList.add("");
			break;

		case STRING:
			innerList.add(xssfRow.getCell(j).getStringCellValue());
			break;

		case NUMERIC:
			innerList.add(xssfRow.getCell(j).getNumericCellValue() + "");
			break;

		case BOOLEAN:
			innerList.add(xssfRow.getCell(j).getBooleanCellValue() + "");
			break;

		default:
			throw new IllegalArgumentException("Cannot read the column : " + j);
		}
	}
}
