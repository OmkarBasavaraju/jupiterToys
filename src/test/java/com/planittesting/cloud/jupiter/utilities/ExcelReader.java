package com.planittesting.cloud.jupiter.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.planittesting.cloud.jupiter.base.Base;

public class ExcelReader extends Base {

	public String path;
	public FileInputStream fileinput;
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static int columnCount;
	public static int rowCount;

	// Creating the workbook to interact with excel file
	public ExcelReader(String path) {

		this.path = path;
		try {
			fileinput = new FileInputStream(path);
			workbook = WorkbookFactory.create(fileinput);
			sheet = workbook.getSheetAt(0);
			fileinput.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// Get the row count based on the sheet name
	public int getRowCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		return rowcount;
	}

	// Get the column count based on the sheet name
	public int getColumnCount() {
		row = sheet.getRow(0);
		columnCount = row.getLastCellNum();
		return columnCount;
	}

	// Get cell data
	public String getCellData(int rowCount, int colCount) {

		Row rowData = sheet.getRow(rowCount);
		Cell cellData = rowData.getCell(colCount);

		if (cellData.getCellType() == CellType.STRING) {
			return cellData.getStringCellValue();
		} else if (cellData.getCellType() == CellType.NUMERIC) {
			return Double.toString(cellData.getNumericCellValue());
		} else
			return ("Field is neither String or Numeric");
	}
}
