package com.ccoew.onlinepayment.viewpurchasesservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccoew.onlinepayment.book.Book;

/**
 * Servlet implementation class ViewPurchasesServlet
 */
public class ViewPurchasesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewPurchasesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		ArrayList<Book> cart = new ArrayList<Book>();
		for (Map.Entry<Integer, Book> book : ((HashMap<Integer, Book>) session
				.getAttribute("cart")).entrySet()) {
			cart.add(book.getValue());
		}

		if (session.getAttribute("totalPurchase") == null) {
			session.setAttribute("totalPurchase", cart);
		} else {
			session.setAttribute("totalPurchase", ((ArrayList<Book>) session
					.getAttribute("totalPurchase")).addAll(cart));
		}
//System.out.println((ArrayList<Book>) session
//		.getAttribute("totalPurchase"));

		request.getRequestDispatcher("ViewPurchases.jsp").forward(request, response);

	}
}
