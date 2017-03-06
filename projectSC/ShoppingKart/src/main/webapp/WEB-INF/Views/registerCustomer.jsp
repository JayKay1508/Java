<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-wrapper">
<div class="container">
<form action="newUsers" class="form-horizontal"  method="post"   name="form" name="register" >

<div class="form-group">
<label for="firstname">FIRST NAME</label>
<input name="firstname" id="firstname" type="text">
</div>

<div class="form-group">
<label for="lastname">LAST NAME</label>
<input name="lastname" id="lastname" type="text">
</div>
<div class="form-group">
<label for="email">EMAIL</label>
<input name="email" id="email" type="email">
</div>
<div class="form-group">
<label for="phonenumber">PHONE NUMBER</label>
<input name="phonenumber" id="phonenumber" type="text">
</div>

<input type="submit" value="register">

</form>

</div>

</div>
</body>
</html>
