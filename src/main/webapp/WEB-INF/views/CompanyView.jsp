<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Assuming itemList is a List<MyItem> in your model -->
<c:forEach items="${data}" var="data">
    <!-- Access properties of the item using ${item.propertyName} -->
    <p>${data}</p> 
   
</c:forEach>
<h4><a href=companysessionview> Click here to get data into session page </a></h4>
</body>
</html>