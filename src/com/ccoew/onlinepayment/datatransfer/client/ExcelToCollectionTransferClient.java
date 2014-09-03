package com.ccoew.onlinepayment.datatransfer.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ccoew.onlinepayment.creditcard.CreditCard;

public class ExcelToCollectionTransferClient {
	private static HashMap<String, CreditCard> creditCardUsers = new HashMap<String, CreditCard>();

	public static void transferData() throws IOException,
			ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(new File(
				"C:/Barclays/OnlinePayment/OnlinePayment/CreditCardUsers.xls"));

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet hssfSheet = hssfWorkbook.getSheet("Clients");

		Iterator<Row> rowIterator = hssfSheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();

			String cardNumber = null;
			String ccv = null;
			String cardHolder = null;
			String expMonth = null;
			String expYear = null;
			double balance = 0;

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				cardNumber = cell.getStringCellValue();
				cell = cellIterator.next();
				ccv = cell.getStringCellValue();
				cell = cellIterator.next();
				cardHolder = cell.getStringCellValue();
				cell = cellIterator.next();
				expMonth = cell.getStringCellValue();
				cell = cellIterator.next();
				expYear = cell.getStringCellValue();
				cell = cellIterator.next();
				balance = cell.getNumericCellValue();

			}
			CreditCard creditCard = new CreditCard(cardNumber, ccv, cardHolder,
					expMonth, expYear, balance);
			creditCardUsers.put(creditCard.getCardNumber(), creditCard);
		}

		fileInputStream.close();
	}

	public static HashMap<String, CreditCard> getCreditCardUsers() {
		return creditCardUsers;
	}

	private static void setCreditCardUsers(
			HashMap<String, CreditCard> creditCardUsers) {
		ExcelToCollectionTransferClient.creditCardUsers = creditCardUsers;
	}

}
