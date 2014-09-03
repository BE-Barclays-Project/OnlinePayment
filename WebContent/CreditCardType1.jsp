<%@page import="java.util.Date"%>
<%@page
	import="com.ccoew.onlinepayment.validations.CreditCardSpecificValidator"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Credit card type</title>
<script type="text/javascript">
	function checkValidity() {

		if (document.cardDetails.cardNumber.value == "") {
			document.getElementById("cno").innerHTML = "**Enter Credit card number";
			return false;
		} else {
			document.getElementById("cno").innerHTML = "";
		}
		if (!isValidNumber(document.cardDetails.cardNumber.value)) {
			document.getElementById("cno").innerHTML = "**Enter correct Credit card number";
			return false;
		} else {
			document.getElementById("cno").innerHTML = "";
		}
		if (document.cardDetails.cardHolder.value == "") {
			//alert("Card Holder can not be empty.!!!");
			document.getElementById("name").innerHTML = "**Enter Credit card holder";
			return false;
		} else {
			document.getElementById("name").innerHTML = "";
		}
		if (!isValidAlpha(document.cardDetails.cardHolder.value)) {
			document.getElementById("name").innerHTML = "**Enter correct Credit card holder";
			return false;
		} else {
			document.getElementById("name").innerHTML = "";
		}
		if (document.cardDetails.cvc.value == "") {
			document.getElementById("cvc").innerHTML = "**Enter the CVC";
			document.cardDetails.cvc.focus();
			return false;
		} else {
			document.getElementById("cvc").innerHTML = "";
		}
		if (!isValidNumber(document.cardDetails.cvc.value)) {
			document.getElementById("cvc").innerHTML = "**Enter correct CVC";
			return false;
		} else {
			document.getElementById("cvc").innerHTML = "";
		}
		if (document.cardDetails.month.value == "month") {
			document.getElementById("month").innerHTML = "**Enter the month";
			return false;
		} else {
			document.getElementById("month").innerHTML = "";
		}
		if (document.cardDetails.year.value == "year") {
			document.getElementById("year").innerHTML = "**Enter the year";
			return false;
		} else {
			document.getElementById("year").innerHTML = "";
		}

		return true;
	}
	function isValidNumber(num) {
		for ( var i = 0; i < num.length; i++) {
			if (num.charAt(i) < '0' || num.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	function isValidAlpha(name) {
		for ( var i = 0; i < name.length; i++) {
			if ((name.charAt(i) < 'A' || name.charAt(i) > 'z')
					&& name.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}
</script>
</head>
<body background="back.jpg">
	<center>
		<form name="cardDetails" action="CreditCardDetailsServlet"
			method="post">
			<br> <br> <br>

			<table>
				<%
					String cardNumber = (String) session.getAttribute("cardNumber");
					String cardHolder = (String) session.getAttribute("cardHolder");
					String expMonth = (String) session.getAttribute("expMonth");
					String expYear = (String) session.getAttribute("expYear");
					String cvc = (String) session.getAttribute("cvc");
				%>


				<tr>
					<td>Card Number:</td>
					<%
						if (cardNumber == null) {
					%>
					<td><input type="text" value="" name="cardNumber" width="20"
						onchange="return checkValidity()"> <%
 	} else {
 %>
					<td><input type="text" value=<%=cardNumber%> name="cardNumber"
						width="20" onchange="return checkValidity()"> <%
 	}
 %> <span id="cno"></span> <%
 	if (request.getAttribute("n") != null) {
 		if ((Integer) request.getAttribute("n") == 1) {
 %><%="**" + request.getAttribute("error")%> <%
 	}
 	}
 %></td>
				</tr>
				<tr>
					<td>Card Holder:</td>
					<%
						if (cardHolder == null) {
					%>
					<td><input type="text" value="" name="cardHolder" width="20"
						onchange="return checkValidity()"> <%
 	} else {
 %>
					<td><input type="text" value=<%=cardHolder%> name="cardHolder"
						width="20" onchange="return checkValidity()"> <%
 	}
 %><span id="name"></span></td>
				</tr>

				<tr>
					<td>CVC:</td>
					<%
						if (cvc == null) {
					%>
					<td><input type="text" value="" name="cvc" width="4"
						onchange="return checkValidity()"> <%
 	} else {
 %>
					<td><input type="text" value=<%=cvc%> name="cvc" width="4"
						onchange="return checkValidity()"> <%
 	}
 %> <span id="cvc"></span> <%
 	if (request.getAttribute("n") != null) {
 		if ((Integer) request.getAttribute("n") == 2) {
 %><%="**" + request.getAttribute("error")%> <%
 	}
 	}
 %></td>
				</tr>

				<tr>
					<td>Card Expiry Date:&nbsp; <%
 	if (expMonth == null) {
 %>
					<td><select size="1" name="month" value="month"
						onchange="return checkValidity()">
							<option>month</option>
							<option>jan</option>
							<option>feb</option>
							<option>mar</option>
							<option>apr</option>
							<option>may</option>
							<option>june</option>
							<option>july</option>
							<option>aug</option>
							<option>sep</option>
							<option>oct</option>
							<option>nov</option>
							<option>dec</option>
					</select> <%
 	} else {
 %>
					<td><select size="1" name="month" value=<%=expMonth%>
						onchange="return checkValidity()">
							<option><%=expMonth%></option>
							<option>jan</option>
							<option>feb</option>
							<option>mar</option>
							<option>apr</option>
							<option>may</option>
							<option>june</option>
							<option>july</option>
							<option>Aug</option>
							<option>Sep</option>
							<option>Oct</option>
							<option>Nov</option>
							<option>Dec</option>
					</select> <%
 	}
 	if (expYear == null) {
 %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select size="1" name="year"
						value="year" onchange="return checkValidity()">
							<%
								Date date = new Date();
									//date.setYear(2014);
							%>
							<option>Year</option>
							<%
								for (int i = 0; i < 5; i++) {
							%>

							<option><%=(date.getYear() + i + 1900)%></option>
							<%
								}
							%>
					</select> <%
 	} else {
 %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select
						size="1" name="year" value=<%=expYear %>
						onchange="return checkValidity()">
							<%
								Date date = new Date();
									//date.setYear(2014);
							%>
							<option>Year</option>
							<%
								for (int i = 0; i < 5; i++) {
							%>

							<option><%=(date.getYear() + i + 1900)%></option>
							<%
								}
							%>
					</select></td>

				
					<%
						}
					%>
					<span id="month"></span>
					<span id="year"></span>
					</td>
				</tr>

				<tr>
					<td><br> <%
 	if (request.getAttribute("n") != null) {
 		if ((Integer) request.getAttribute("n") == 3) {
 %><%="**" + request.getAttribute("error")%> <%
 	}
 	}
 %><br> <br></td>
				</tr>
				<tr>
					<br>
					<td><input type="button" value="<<Back" name="back"
						onclick="location.href='UserDetails.jsp';"></td>
					<td><input type="submit" value="Confirm Payment"
						name="confirm>>" onclick="return checkValidity()"></td>
				</tr>
			</table>

		</form>
	</center>
</body>
</html>