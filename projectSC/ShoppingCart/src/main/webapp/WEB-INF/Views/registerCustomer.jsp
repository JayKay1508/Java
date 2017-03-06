<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-wrapper">
<div class="container">

<c:url var="url" value="/registerCustomer"></c:url>

<form action="">

<div class="form-group">
<label for="firstname">FIRST NAME</label>
<input name="firstname"></input>
</div>

<div class="form-group">
<label for="lastname">LAST NAME</label>
<input name="lastname"></input>
</div>
<div class="form-group">
<label for="email">EMAIL</label>
<input name="email"></input>
</div>
<div class="form-group">
<label for="phonenumber">PHONE NUMBER</label>
<input name="phonenumber"></input>
</div>
<div class="form-group">
<label for="username">USERNAME</label>
<input name="username"></input>

</div>
<div class="form-group">
<label for="password">PASSWORD</label>
<input name="password" type="password"></input>
</div>
<div class="form-group">
<label for="apartmentNumber">APARTMENT NUMBER</label>
<input name="apartmentNumber"></input>
</div>
<div class="form-group">
<label for="streetName">STREET NAME</label>
<input name="streetName"></input>
</div>
<div class="form-group">
<label for="city">CITY</label>
<input name="city"></input>
</div>
<div class="form-group">
<label for="state">STATE</label>
<input name="state"></input>
</div>
<div class="form-group">
<label for="country">COUNTRY</label>
<input name="country"></input>
</div>
<div class="form-group">
<label for="zipcode">ZIPCODE</label>
<input name="zipcode"></input>
</div>


<input type="submit" value="register">

</form>

</div>

</div>
</body>
</html>