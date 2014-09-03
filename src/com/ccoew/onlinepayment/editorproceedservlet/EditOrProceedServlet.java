package com.ccoew.onlinepayment.editorproceedservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccoew.onlinepayment.datatransfer.ExcelToCollectionTransfer;

/**
 * Servlet implementation class EditOrProceedServlet
 */
public class EditOrProceedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditOrProceedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> buttonClicked = request.getParameterNames();
		String button = buttonClicked.nextElement();
		if (button.equals("proceed")) {
			// request.getRequestDispatcher("CreditCardType1.jsp").forward(
			// request, response);
			request.getRequestDispatcher("UserDetails.jsp").forward(request,
					response);
		} else {
			if (button.equals("edit")) {
				System.out.println("edit");

				// getServletContext()
				// .getRequestDispatcher("CachingServlet.java").forward(
				// request, response);
				//
				try {
					request.setAttribute("books",
							ExcelToCollectionTransfer.transferData());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("BookShelf.jsp").forward(
						request, response);

				// response.sendRedirect("BookShelf.jsp");

			}
		}
	}

}
