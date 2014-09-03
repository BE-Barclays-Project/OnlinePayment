<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function checkNull() {

		if (document.UserDetails.name.value == "") {
			document.getElementById("n").innerHTML="**Enter name";
			return false;
		}else{
			document.getElementById("n").innerHTML="";
		}
		if (!isValidAlpha(document.UserDetails.name.value)) {
			document.getElementById("n").innerHTML="**Enter valid name";
			return false;
		}else{
			document.getElementById("n").innerHTML="";
		}
		if (document.UserDetails.email.value == "") {
			document.getElementById("e").innerHTML="**Enter email id";
			return false;
		}else{
			document.getElementById("e").innerHTML="";
		}
		if (!validateEmail()) {
			document.getElementById("e").innerHTML="**Enter valid email id";
			return false;
		}else {
			document.getElementById("e").innerHTML="";
					}
		if (document.UserDetails.flatno.value == "") {
			document.getElementById("f").innerHTML="**Enter flat no";
			return false;
		}else{
			document.getElementById("f").innerHTML="";
		}

		if (!isValidNumber(document.UserDetails.flatno.value)) {
			document.getElementById("f").innerHTML="**Enter valid flat no.";
			return false;
		}else{
			document.getElementById("f").innerHTML="";
		}
		if (document.UserDetails.apartmentname.value == "") {
			document.getElementById("an").innerHTML="**Enter apartment name";
			return false;
		}else {
			document.getElementById("an").innerHTML="";
		}
		if (!isValidAlpha(document.UserDetails.apartmentname.value)) {
			document.getElementById("an").innerHTML="**Enter valid apartment name";
			return false;
		}else {
			document.getElementById("an").innerHTML="";
		}
		if (document.UserDetails.streetname.value == "") {
			document.getElementById("s").innerHTML="**Enter street name";
			return false;
		}else {document.getElementById("s").innerHTML="";	
		}
		if (!isValidAlpha(document.UserDetails.streetname.value)) {
			document.getElementById("s").innerHTML="**Enter valid street name";
			return false;
		}else{
			document.getElementById("s").innerHTML="";	
		}
		if (document.UserDetails.city.value == "") {
			document.getElementById("c").innerHTML="**Enter city";
			return false;
		}else {
			document.getElementById("c").innerHTML="";
					}
		if (!isValidAlpha(document.UserDetails.city.value)) {
			document.getElementById("c").innerHTML="**Enter valid city name";
			return false;
		}else {
			document.getElementById("c").innerHTML="";
		}
		if (document.UserDetails.state.value == "") {
			document.getElementById("st").innerHTML="**Enter state";
			return false;
		}else {
			document.getElementById("st").innerHTML="";
		}
		if (!isValidAlpha(document.UserDetails.state.value)) {
			document.getElementById("st").innerHTML="**Enter valid state name";
			return false;
		}else {
			document.getElementById("st").innerHTML="";
		}
	
		if (document.UserDetails.zip.value == "") {
			document.getElementById("z").innerHTML="**Enter zip code";
			return false;
		}else {
			document.getElementById("z").innerHTML="";
		}
		
		
		/*if (!isValidNumber(document.UserDetails.zip.value)
				|| !isValidLength(document.UserDetails1.zip.value,6)) {
			document.getElementById("z").innerHTML="**Enter valid zip code";
			return false;
		}else {
			//document.write(document.UserDetails1.zip.value.length);
			document.getElementById("z").innerHTML="";
		}*/
		if (document.UserDetails.country.value == "") {
			document.getElementById("cy").innerHTML="**Enter country";
			return false;
		}else {
			document.getElementById("cy").innerHTML="";
		}
		if (!isValidAlpha(document.UserDetails.country.value)) {
			document.getElementById("cy").innerHTML="**Enter valid country";
			return false;
		}else {
			document.getElementById("cy").innerHTML="";
		}
		if (document.UserDetails.contactNumber.value == "") {
			document.getElementById("cn").innerHTML="**Enter contact number";
			return false;
		}else {
			document.getElementById("cn").innerHTML="";
		}
		if (!isValidNumber(document.UserDetails.contactNumber.value)){
			document.getElementById("cn").innerHTML="**Enter valid contact number";
			return false;
		}else {
			document.getElementById("cn").innerHTML="";
		}
		if(!isValidLength(document.UserDetails1.contactNumber.value,10)) {
			document.getElementById("cn").innerHTML="**Enter valid contact number";
			return false;
		}else {
			document.getElementById("cn").innerHTML="";
		}
		return true;
	}
	function isValidLength(num,length) {
		return num.length==length;
	}	
	function isValidNumber(num) {

		for ( var i = 0; i < num.length; i++) {
			if (!(num.charAt(i) >= '0' && num.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}
	function validateEmail() {
		var email=document.UserDetails.email.value;
	    var atpos = email.indexOf("@");
	    var dotpos = email.lastIndexOf(".");
	    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=email.length) {
	        return false;
	    }
	    return true;
	}
	function isValidAlpha(name) {
		var i;
		for (i = 0; i < name.length; i++) {

			if (!(name.charAt(i) >= 'A' && name.charAt(i) <= 'z')) {

				return false;
			}

		}
		return true;
	}
</script>
</head>
<body>
	<%
		request.setAttribute("cardType",
				(String) request.getAttribute("cardType"));
	%>
	<form name="UserDetails" action="UserDetailsServlet" method="post"
		onsubmit="return checkNull()">
		<table>
			<%
				String userName = (String) session.getAttribute("userName");
				String email = (String) session.getAttribute("email");
				String flatNo = (String) session.getAttribute("flatNo");
				String apartmentName = (String) session
						.getAttribute("apartmentName");
				String streetName = (String) session.getAttribute("streetName");
				String city = (String) session.getAttribute("city");
				String state = (String) session.getAttribute("state");
				String zip = (String) session.getAttribute("zip");
				String country = (String) session.getAttribute("country");
				String contactNumber = (String) session
						.getAttribute("contactNumber");
			%>
			<tr>
				<td>Name :</td>
				<%
					if (userName == null) {
				%>
				<td><input type="text" name="name" value=""
					onchange="return checkNull()"> <%
 	} else {
 %>
				<td><input type="text" name="name" value=<%=userName%>
					onchange="return checkNull()"> <%
 	}
 %> <span id="n"> </span></td>
			</tr>
			<tr>
				<td>Email address :</td>
				<%
					if (email == null) {
				%>
				<td><input type="text" name="email" value=""
					onchange="return checkNull()"> <%
 	} else {
 %>
				<td><input type="text" name="email" value=<%=email%>
					onchange="return checkNull()"> <%
 	}
 %> <span id="e"></span></td>
			</tr>
			<tr>
				<td>Flat No:</td>
				<%
					if (flatNo == null) {
				%>
				<td><input type="text" name="flatno" value=""
					onchange="return checkNull()"> <%
 	} else {
 %>
				<td><input type="text" name="flatno" value=<%=flatNo%>
					onchange="return checkNull()"> <%
 	}
 %> <span id="f"></span></td>
			</tr>
			<tr>
				<td>Apartment Name:</td>
				<%
					if (apartmentName == null) {
				%>
				<td><input type="text" name="apartmentname" value=""
					onchange="return checkNull()"> <%
 	} else {
 %>
				<td><input type="text" name="apartmentname"
					value=<%=apartmentName%> onchange="return checkNull()"> <%
 	}
 %> <span id="an"></span></td>
			</tr>
			<tr>
				<td>Street Name:</td>
				<%
					if (streetName == null) {
				%>
				<td><input type="text" name="streetname" value=""
					onchange="return checkNull()"> <%
 	} else {
 %>
				<td><input type="text" name="streetname" value=<%=streetName%>
					onchange="return checkNull()"> <%
 	}
 %> <span id="s"></span></td>
			</tr>
			<tr>
				<td>City:</td>
				<%
					if (city == null) {
				%>
				<td><input type="text" name="city" value=""
					onchange="return checkNull()"> <%
 	} else {
 %>
				<td><input type="text" name="city" value=<%=city%>
					onchange="return checkNull()"> <%
 	}
 %> <span id="c"></span></td>
			</tr>
			<tr>
				<td>State :</td>
				<%
					if (state == null) {
				%>
				<td><input type="text" name="state" value=""
					onchange="return checkNull()"> <%
 	} else {
 %>
				<td><input type="text" name="state" value=<%=state%>
					onchange="return checkNull()"> <%
 	}
 %> <span id="st"></span></td>
			</tr>
			<tr>
				<td>ZIP :</td>
				<%
					if (zip == null) {
				%>
				<td><input type="text" name="zip" value=""
					onchange="return checkNull()"> <%
 	} else {
 %>
				<td><input type="text" name="zip" value=<%=zip%>
					onchange="return checkNull()"> <%
 	}
 %> <span id="z"></span></td>
			</tr>
			<tr>
				<td>Country :</td>
				<%
					if (country == null) {
				%>
				<td><input type="text" name="country" value=""
					onchange="return checkNull()"> <%
 	} else {
 %>
				<td><input type="text" name="country" value=<%=country%>
					onchange="return checkNull()"> <%
 	}
 %> <span id="cy"></span></td>
			</tr>
			<tr>
				<td>Contact Number :</td>
				<%
					if (contactNumber == null) {
				%>
				<td><input type="text" name="contactNumber" value=""
					onchange="return checkNull()"> <%
 	} else {
 %>
				<td><input type="text" name="contactNumber"
					value=<%=contactNumber%> onchange="return checkNull()"> <%
 	}
 %> <span id="cn"></span></td>
				<br>
			</tr>
			<tr>
				<td><input type="button" value="<<Back" name="back"
					onclick="location.href='OrderSubtotal.jsp';"></td>
				<td><input type="submit" name="Proceed" value="Proceed >>"></td>

			</tr>
		</table>
	</form>
</body>
</html>