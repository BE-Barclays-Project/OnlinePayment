package com.ccoew.onlinepayment.cartservicesservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccoew.onlinepayment.cartservicesservlet.ordervalidation.OrderValidation;

/**
 * Servlet implementation class CartServicesServlet
 */
public class CartServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServicesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String[] selectedBooks = request.getParameterValues("book");
		String[] quantities = request.getParameterValues("quantity");
		session.setAttribute("selectedBooks", selectedBooks);
		session.setAttribute("quantities", quantities);
		
		OrderValidation shoppingCart = new OrderValidation();
		request.setAttribute("cart", shoppingCart.processOrder(request));
		//CollectionToExcelTransfer.update(shoppingCart.getCart());
		request.setAttribute("payment", shoppingCart.calcPayment());

		session.setAttribute("cart", shoppingCart.getCart());
		session.setAttribute("payment", shoppingCart.getPayment());
		session.setMaxInactiveInterval(20*60);

		request.getRequestDispatcher("OrderSubtotal.jsp").forward(request,
				response);

	}

}
