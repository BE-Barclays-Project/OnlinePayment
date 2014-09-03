<%@page import="com.ccoew.onlinepayment.customer.Customer"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ccoew.onlinepayment.book.Book"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details of transaction</title>
</head>
<body>
	<form action="ViewPurchasesServlet" method="get">
		<h1>Amazon</h1>
		<h3>Details Of Transaction:</h3>
		<%
			HashMap<Integer, Book> books = (HashMap<Integer, Book>) session
					.getAttribute("cart");
			Customer customer = (Customer) session.getAttribute("customer");
			double payment = (Double) session.getAttribute("payment");
			String cardType = (String) session.getAttribute("cardType");
			Date date = new Date();
			int day = date.getDate();
			int month = date.getMonth();
			int year = date.getYear();
		%>
		<p>
			Order: <br>
		<table>
			<tr>
				<th>Book</th>
				<th>Author</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<%
				for (Map.Entry<Integer, Book> book : books.entrySet()) {
			%>
			<tr>
				<td><%=book.getValue().getTitle()%></td>
				<td><%=book.getValue().getAuthor()%></td>
				<td><%=book.getValue().getPrice()%></td>
				<td><%=book.getValue().getQuantity()%></td>
			</tr>
			<%
				}
			%>
		</table>
		</p>
		<p>
			Amount:
			<%=payment%></p>
		<p>
			Card Type:
			<%=cardType%></p>
		<p>
			Date of transaction:
			<%
			year += 1900;
			month++;
		%>
			<%=day%>/<%=month%>/<%=year%>
		</p>
		<p>
			Customer Details: <br>
		<table>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Contact Number</th>
			</tr>

			<tr>
				<td><%=customer.getName()%></td>
				<td><%=customer.getEmailAddress()%></td>
				<td><%=customer.getContactNumber()%></td>
			</tr>

			<tr>
				<br>
				<br>
				<td><input type="button" value="Go for another purchase!"
					name="again" onclick="location.href='AmazonHome.html';"></td>
				<td><input type="button" value="Exit!" name="exit"
					onclick="location.href='ThankYou.html';"></td>
				<td><input type="submit" value="View Purchases>>" name="view"></td>
			</tr>

		</table>
		</p>
	</form>
</body>
</html>