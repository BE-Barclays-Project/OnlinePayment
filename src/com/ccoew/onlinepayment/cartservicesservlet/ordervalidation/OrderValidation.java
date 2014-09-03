package com.ccoew.onlinepayment.cartservicesservlet.ordervalidation;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ccoew.onlinepayment.book.Book;
import com.ccoew.onlinepayment.datatransfer.ExcelToCollectionTransfer;

public class OrderValidation {

	private HashMap<Integer, Book> cart;
	private double payment;

	public OrderValidation() {
		super();
		this.cart = new HashMap<Integer, Book>();
		this.payment = 0;
	}

	public HashMap<Integer, Book> processOrder(HttpServletRequest request) {
		String[] selectedBooks = request.getParameterValues("book");
		String[] quantities = request.getParameterValues("quantity");
		
		for (int i = 0; i < selectedBooks.length; i++) {
			int bookCode = Integer.parseInt(selectedBooks[i]);
			Book book = ExcelToCollectionTransfer.getBooks().get(bookCode);
			int userQuantity = Integer.parseInt(quantities[i]);
			int availQuantity = book.getQuantity();
			if (verifyQuantity(availQuantity, userQuantity)) {
				ExcelToCollectionTransfer.getBooks().remove(bookCode);
				book.setQuantity(availQuantity - userQuantity);
				ExcelToCollectionTransfer.getBooks().put(bookCode, book);
				book.setQuantity(userQuantity);
				getCart().put(bookCode, book);
			}
		}

		return getCart();
	}

	private boolean verifyQuantity(int availQuantity, int userQuantity) {
		if (availQuantity >= userQuantity)
			return true;
		return false;
	}

	public double calcPayment() {
		double payment = 0;
		for (Map.Entry<Integer, Book> book : getCart().entrySet()) {
			payment += (book.getValue().getQuantity() * book.getValue()
					.getPrice());
		}
		setPayment(payment);
		return payment;
	}

	public HashMap<Integer, Book> getCart() {
		return cart;
	}

	public void setCart(HashMap<Integer, Book> cart) {
		this.cart = cart;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

}
