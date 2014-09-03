package com.ccoew.onlinepayment.datatransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ccoew.onlinepayment.book.Book;

public class CollectionToExcelTransfer {

	public static void update(HashMap<Integer, Book> shoppingCart) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File(
				"C:/Barclays/OnlinePayment/OnlinePayment/Inventory.xls"));
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet hssfSheet = hssfWorkbook.getSheet("Books");

		for (Map.Entry<Integer, Book> book : shoppingCart
				.entrySet()) {

			Iterator<Row> rowIterator = hssfSheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (book.getKey() == row.getCell(0).getNumericCellValue()) {
					Cell cell = row.getCell(6);
					int updatedQty = (int) cell.getNumericCellValue()
							- book.getValue().getQuantity();
					row.getCell(6).setCellValue(updatedQty);
					break;
				}
			}
		}
		fileInputStream.close();
		FileOutputStream fileOutputStream = new FileOutputStream(new File(
				"C:/Barclays/OnlinePayment/OnlinePayment/Inventory.xls"));
		hssfWorkbook.write(fileOutputStream);
		fileOutputStream.close();
	}

}
