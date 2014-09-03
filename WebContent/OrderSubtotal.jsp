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
	<form action="EditOrProceedServlet" method="post">
		<h1>Amazon</h1>
		<h3>Order Subtotal :</h3>
		<%
			Map<Integer, Book> cart = (HashMap<Integer, Book>) session
					.getAttribute("cart");
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
				for (Map.Entry<Integer, Book> cartBook : cart.entrySet()) {
			%>
			<tr>
				<td><%=cartBook.getValue().getTitle()%></td>
				<td><%=cartBook.getValue().getAuthor()%></td>
				<td><%=cartBook.getValue().getPublication()%></td>
				<td><%=cartBook.getValue().getRating()%></td>
				<td><%=cartBook.getValue().getPrice()%></td>
				<td><%=cartBook.getValue().getQuantity()%></td>
			</tr>
			<%
				}
			%>
			<tr></tr>
			<tr>
				<td>Total Payment : <%=session.getAttribute("payment")%>
				</td>
			</tr>
			<tr>
			<br>
			<td><br> <br> <br> <input
					type="submit" value="Edit cart" name="edit"
					onclick="history.back();"></td>
				<td><br> <br> <br> <input
					type="submit" value="Proceed to checkout >>" name="proceed"></td>
				
			</tr>
		</table>
	</form>

</body>
</html>