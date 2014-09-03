package com.ccoew.onlinepayment.creditcarddetailsservlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccoew.onlinepayment.authenticateuser.AuthenticateUser;
import com.ccoew.onlinepayment.book.Book;
import com.ccoew.onlinepayment.creditcard.CreditCard;
import com.ccoew.onlinepayment.customer.Customer;
import com.ccoew.onlinepayment.datatransfer.CollectionToExcelTransfer;
import com.ccoew.onlinepayment.datatransfer.SaveCustomerDetailsInExcel;
import com.ccoew.onlinepayment.datatransfer.client.CollectionToExcelTransferClient;
import com.ccoew.onlinepayment.validations.CreditCardSpecificValidator;

/**
 * Servlet implementation class CreditCardDetailsServlet
 */
public class CreditCardDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreditCardDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			validateCreditCardUserInput(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void validateCreditCardUserInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			ClassNotFoundException {

		String cardNumber = request.getParameter("cardNumber");
		String cardHolder = request.getParameter("cardHolder");
		String expMonth = request.getParameter("month");
		String expYear = request.getParameter("year");
		String cvc = request.getParameter("cvc");

		HttpSession session = request.getSession();

		// Logger log = Logger.getAnonymousLogger();
		// System.out.println(cardNumber);
		
		session.setAttribute("cardNumber", cardNumber);
		session.setAttribute("cardHolder", cardHolder);
		session.setAttribute("expMonth", expMonth);
		session.setAttribute("expYear", expYear);
		session.setAttribute("cvc", cvc);
		
		if (CreditCardSpecificValidator.isCreditCardNumberValid(cardNumber)) {
			CreditCard creditCard = new CreditCard(cardNumber, cvc, cardHolder,
					expMonth, expYear);
			// System.out.println(creditCard);
			if (CreditCardSpecificValidator.isCCVValid(
					creditCard.getCardType(), creditCard.getCcv())) {
				// log.info("validated");
				if (AuthenticateUser.authenticate(creditCard,
						(double) session.getAttribute("payment"))) {
					CollectionToExcelTransferClient.update(
							creditCard.getCardNumber(),
							(double) session.getAttribute("payment"));
					CollectionToExcelTransfer
							.update((HashMap<Integer, Book>) session
									.getAttribute("cart"));
					SaveCustomerDetailsInExcel.put((Customer) session
							.getAttribute("customer"));
					// log.info("payment done");
					// request.setAttribute("payment",
					// OrderValidation.getPayment());
					session.setAttribute("cardType", creditCard.getCardType());
					// request.setAttribute("cardType",
					// creditCard.getCardType());
					// request.getRequestDispatcher("UserDetails1.jsp").forward(request,
					// response);
					request.getRequestDispatcher("DetailsOfTransaction.jsp")
							.forward(request, response);

				} else {
					errorInputData("Invalid Credit card no.", 1, request,
							response);
				}

			} else {
				errorInputData("Invalid cvc", 2, request, response);
			}
		} else {
			errorInputData("User not authenticated", 3, request, response);
		}

	}

	private void errorInputData(String error, int n,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Logger log = Logger.getAnonymousLogger();
		// log.info("error");
		request.setAttribute("n", n);
		request.setAttribute("error", error);
		request.getRequestDispatcher("CreditCardType1.jsp").forward(request,
				response);
	}

}
