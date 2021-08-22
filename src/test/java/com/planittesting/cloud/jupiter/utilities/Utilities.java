package com.planittesting.cloud.jupiter.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.planittesting.cloud.jupiter.base.Base;

public class Utilities extends Base {

	// Read data for all the rows and columns in excel sheet
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {
		String sheetName = m.getName();

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount();

		Object[][] data = new Object[rows][cols];

		for (int rowNum = 1; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 1][colNum] = excel.getCellData(rowNum, colNum);

			}

		}

		return data;

	}
}
