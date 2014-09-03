<%@page import="java.util.ArrayList"%>
<%@page import="com.ccoew.onlinepayment.book.Book"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Subtotal</title>

</head>
<body>
	<h1>Amazon</h1>
	<h3>
		Previous Purchases by
		<%=(String) session.getAttribute("userName")%>
		:
	</h3>
	<%
		ArrayList<Book> cart = (ArrayList<Book>) session
				.getAttribute("totalPurchase");
	%>

	<table>

		<tr>
			<th>Book</th>
			<th>Author</th>
			<th>Publication</th>
			<th>Rating</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%
			for (int i = 0; i < cart.size(); i++) {
		%>
		<tr>
			<td><%=cart.get(i).getTitle()%></td>
			<td><%=cart.get(i).getAuthor()%></td>
			<td><%=cart.get(i).getPublication()%></td>
			<td><%=cart.get(i).getRating()%></td>
			<td><%=cart.get(i).getPrice()%></td>
			<td><%=cart.get(i).getQuantity()%></td>
		</tr>
		<%
			}
		%>
		<tr>

			<td><br> <br>
			<input type="button" value="Go for another purchase!" name="again"
				onclick="location.href='AmazonHome.html';"></td>
			<td><input type="button" value="Exit!" name="exit"
				onclick="location.href='ThankYou.html';"></td>
		</tr>
	</table>

</body>
</html>