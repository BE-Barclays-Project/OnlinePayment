package com.ccoew.onlinepayment.userdetailsservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccoew.onlinepayment.address.AppartmentName;
import com.ccoew.onlinepayment.address.City;
import com.ccoew.onlinepayment.address.PinCode;
import com.ccoew.onlinepayment.carduserdetails.Address;
import com.ccoew.onlinepayment.carduserdetails.ContactNumber;
import com.ccoew.onlinepayment.carduserdetails.Country;
import com.ccoew.onlinepayment.carduserdetails.EmailAddress;
import com.ccoew.onlinepayment.carduserdetails.Name;
import com.ccoew.onlinepayment.carduserdetails.State;
import com.ccoew.onlinepayment.customer.Customer;

/**
 * Servlet implementation class UserDetailsServlet
 */
public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		String flatNo = request.getParameter("flatno");
		String apartmentName = request.getParameter("apartmentname");
		String streetName = request.getParameter("streetname");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String contactNumber = request.getParameter("contactNumber");

		HttpSession session = request.getSession();

		session.setAttribute("userName", userName);
		session.setAttribute("email", email);
		session.setAttribute("flatNo", flatNo);
		session.setAttribute("apartmentName", apartmentName);
		session.setAttribute("streetName", streetName);
		session.setAttribute("city", city);
		session.setAttribute("state", state);
		session.setAttribute("zip", zip);
		session.setAttribute("country", country);
		session.setAttribute("contactNumber", contactNumber);

		Name name = Name.nameCreater(userName);
		EmailAddress emailAddress = EmailAddress.emailAddressCreator(email);
		Address address = new Address(Integer.parseInt(flatNo),
				AppartmentName.Creater(apartmentName), streetName,
				City.CreaterC(city), PinCode.Creater(Integer.parseInt(zip)));
		Country userCountry = Country.countryCreator(country);
		ContactNumber contact = ContactNumber
				.contactNumberCreator(contactNumber);

		Customer customer = new Customer(name, emailAddress,
				Integer.parseInt(flatNo), address, streetName,
				State.stateCreater(state), userCountry, contact,
				(double) session.getAttribute("payment"));

		/* put user data in excel */

		session.setAttribute("customer", customer);
		// request.setAttribute("customer", customer);
		request.getRequestDispatcher("CreditCardType1.jsp").forward(request,
				response);
	}
}
