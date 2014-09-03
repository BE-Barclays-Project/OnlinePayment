<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.ccoew.onlinepayment.book.Book"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book shelf</title>

<script type="text/javascript">

	function enableQtyBox(i, flag) {
		if (flag) {
			document.bookShelf.quantity[i].disabled = false;
		} else {
			document.bookShelf.quantity[i].value = "";
			document.bookShelf.quantity[i].disabled = true;
		}
		validateQty(i);
	}

	function validateQty(i){
		for ( var j = 0; j < i; j++) {
			if(document.bookShelf.book[j].checked){
				if(document.bookShelf.quantity[j].value==""){
					document.getElementById(j+"q").innerHTML="**Enter the quantity";
					return false;
				}else{
					if(document.bookShelf.quantity[j].value==0){
						document.getElementById(j+"q").innerHTML="**Enter non-zero quantity";
						return false;
					}else{
						if(!isValidQuantity(document.bookShelf.quantity[j].value)){
							document.getElementById(j+"q").innerHTML="**Enter valid quantity";
							return false;
						}
					}
				}
			}
		}document.getElementById(j+"q").innerHTML="";
		
		return true;
	}
	
	function isValidQuantity(qty){
		
		for ( var i = 0; i < qty.length; i++) {
			//document.write(qty.charAt(i));
			if(qty.charAt(i)<'0'||qty.charAt(i)>'9'/*!isDigit(qty.charAt(i))*/){
				return false;
			}
		}
		return true;
	}
	
</script>

</head>

<body>

	<form action="CartServicesServlet" method="post" name="bookShelf">
		<center>
			<h1>Amazon</h1>
			<h3>Book Shelf</h3>

			<%
				Map<Integer, Book> books = (HashMap<Integer, Book>) request
						.getAttribute("books");
				String[] selectedBooks = (String[]) session
						.getAttribute("selectedBooks");
				String[] quantities = (String[]) session.getAttribute("quantities");
			%>

			<table cellpadding="20">
				<tr>
					<th></th>
					<th>Book</th>
					<th>Author</th>
					<th>Publication</th>
					<th>Rating</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Qty</th>
				</tr>
				<%
					int i = 0;
					int j = 0;
					for (Map.Entry<Integer, Book> book : books.entrySet()) {
				%>
				<tr>

					<%
						if (selectedBooks != null && j < selectedBooks.length
									&& book.getKey() == Integer.parseInt(selectedBooks[j])) {
					%>

					<td><input type="checkbox" name="book"
						value=<%=book.getKey()%> id=<%=i%>
						onclick="enableQtyBox(this.id,this.checked)" checked="checked"/></td>
					<td><%=book.getValue().getTitle()%></td>
					<td><%=book.getValue().getAuthor()%></td>
					<td><%=book.getValue().getPublication()%></td>
					<td><%=book.getValue().getRating()%></td>
					<td><%=book.getValue().getPrice()%></td>
					<td><%=book.getValue().getQuantity()%></td>
					<td><input type="text" name="quantity"
						value=<%=quantities[j]%> size="2" id=<%=i%>
						onchange="return validateQty(<%=i%>)" /> <%
 	j++;
 		} else {
 %>
					<td><input type="checkbox" name="book"
						value=<%=book.getKey()%> id=<%=i%>
						onclick="enableQtyBox(this.id,this.checked)"
						/></td>
					<td><%=book.getValue().getTitle()%></td>
					<td><%=book.getValue().getAuthor()%></td>
					<td><%=book.getValue().getPublication()%></td>
					<td><%=book.getValue().getRating()%></td>
					<td><%=book.getValue().getPrice()%></td>
					<td><%=book.getValue().getQuantity()%></td>
					<td><input type="text" name="quantity" value="" size="2"
						disabled="disabled" id=<%=i%>
						onchange="return validateQty(<%=i%>)" /> <%
 	}
 %> <span id=<%=i + "q"%>></span></td>
				</tr>

				<%
					i++;
					}
				%>
				<tr>
					<td align="right"><br> <br> <br> <input
						type="submit" value="Go!" onclick="return validateQty(<%=i%>)"></td>
				</tr>
			</table>
		</center>
	</form>

</body>
</html>