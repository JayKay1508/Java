 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
 <div class="container">
<%@ include file="/WEB-INF/Views/header.jsp" %>
 <center><h1>Thank You!!! Your purchase is being dispatched</h1>
   <div class="item">
   <img src="<c:url value="resources/image/freight.jpg"/>" height=400px width=600px/></div>
    </div>
    </center>
</body>
</html>