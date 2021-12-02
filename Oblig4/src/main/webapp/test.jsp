<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test feed</title>


</head>
<body>

 <c:forEach items="${personer}" var="p">
        <p><c:out value="${p.fornavn}"/>
            <c:out value="${p.etternavn}"/>
            <c:out value="${p.kjonn}"/>
            <c:out value="${p.mobil}"/></p>
 </c:forEach>

</body>
</html>