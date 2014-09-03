package com.ccoew.onlinepayment.datatransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ccoew.onlinepayment.book.Book;

public class ExcelToCollectionTransfer {
	private static HashMap<Integer, Book> books = new HashMap<Integer, Book>();

	public static HashMap<Integer, Book> transferData() throws IOException,
			ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(new File(
				"C:/Barclays/OnlinePayment/OnlinePayment/Inventory.xls"));
		// Class.forName("com.mysql.jdbc.Driver");
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet hssfSheet = hssfWorkbook.getSheet("Books");

		Iterator<Row> rowIterator = hssfSheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();

			int bookCode = 0;
			int quantity = 0;
			double price = 0;
			float rating = 0;
			String author = null;
			String title = null;
			String publication = null;

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				bookCode = (int) cell.getNumericCellValue();
				cell = cellIterator.next();
				title = cell.getStringCellValue();
				cell = cellIterator.next();
				author = cell.getStringCellValue();
				cell = cellIterator.next();
				publication = cell.getStringCellValue();
				cell = cellIterator.next();
				price = cell.getNumericCellValue();
				cell = cellIterator.next();
				rating = (float) cell.getNumericCellValue();
				cell = cellIterator.next();
				quantity = (int) cell.getNumericCellValue();
			}
			Book book = new Book(bookCode, title, author, publication, price,
					rating, quantity);
			books.put(book.getBookCode(), book);
		}

		fileInputStream.close();
		return books;

	}

	public static HashMap<Integer, Book> getBooks() {
		return books;
	}

	public static void setBooks(HashMap<Integer, Book> books) {
		ExcelToCollectionTransfer.books = books;
	}

}
