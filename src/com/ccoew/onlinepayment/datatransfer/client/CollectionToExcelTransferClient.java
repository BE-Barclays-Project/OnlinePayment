package com.ccoew.onlinepayment.datatransfer.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CollectionToExcelTransferClient {

	public static void update(String cardNumber, double payment)
			throws IOException {

		FileInputStream fileInputStream = new FileInputStream(new File(
				"C:/Barclays/OnlinePayment/OnlinePayment/CreditCardUsers.xls"));
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet hssfSheet = hssfWorkbook.getSheet("Clients");

		Iterator<Row> rowIterator = hssfSheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (row.getCell(0).getStringCellValue().equals(cardNumber)) {
				Cell cell = row.getCell(5);
				double updatedBalance = cell.getNumericCellValue() - payment;
				//System.out.println("updated balance"+updatedBalance);
				row.getCell(5).setCellValue(updatedBalance);
				Logger log = Logger.getAnonymousLogger();
				log.info("balance updated");
				break;
			}
		}

		fileInputStream.close();

		FileOutputStream fileOutputStream = new FileOutputStream(new File(
				"C:/Barclays/OnlinePayment/OnlinePayment/CreditCardUsers.xls"));
		hssfWorkbook.write(fileOutputStream);
		fileOutputStream.close();
	}

}
