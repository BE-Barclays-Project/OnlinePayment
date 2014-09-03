package com.ccoew.onlinepayment.datatransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ccoew.onlinepayment.customer.Customer;

public class SaveCustomerDetailsInExcel {

	public static void put(Customer customer) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File(
				"C:/Barclays/OnlinePayment/OnlinePayment/Customers.xls"));
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet hssfSheet = hssfWorkbook.getSheet("Customers");

		Iterator<Row> rowIterator = hssfSheet.iterator();
		int rowNo = 0;
		while (rowIterator.hasNext()) {
			rowIterator.next();
			rowNo++;
		}

		Row row = hssfSheet.createRow(rowNo);
		Cell cell = row.createCell(0);
		cell.setCellValue(customer.getName().getFirstName());
		cell = row.createCell(1);
		cell.setCellValue(customer.getEmailAddress().getEmailAddress());
		cell = row.createCell(2);
		// cell.setCellValue(customer.getCountry().getCounrty());
		// cell = row.createCell(3);
		cell.setCellValue(customer.getContactNumber().getContactNumber());
		cell = row.createCell(3);
		cell.setCellValue(customer.getPayment());

		fileInputStream.close();
		FileOutputStream fileOutputStream = new FileOutputStream(new File(
				"C:/Barclays/OnlinePayment/OnlinePayment/Customers.xls"));
		hssfWorkbook.write(fileOutputStream);
		fileOutputStream.close();
	}

}
