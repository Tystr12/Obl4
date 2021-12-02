<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
    href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
    <h2>Deltagerliste</h2>
    <table class="pure-table">
    <tr>
            <th>Kjønn</th>
            <th align="left">Navn</th>
            <th align="left">Mobil</th>
            </tr>
            <c:forEach items="${personer}" var="p">
            <c:if test="${innlogget.mobil  == p.mobil}">
                <tr bgcolor="#aaffaa">
            </c:if>
            <c:if test="${innlogget.mobil  != p.mobil}">
                <tr>
           </c:if>
            <c:if test="${p.kjonn == 'M'}">
                <td>&#9794;</td>
            </c:if>
            <c:if test="${p.kjonn == 'K'}">
                <td>&#9792;</td>
            </c:if>
            <td><c:out value="${p.fornavn}"/><c:out value=" ${p.etternavn}"/></td>
            <td><c:out value="${p.mobil}"/></td>
           </tr>
            </c:forEach>
            
    </table>
    <p>
        <a href="Messaging">Message Board</a>
    </p>
    <p>
        <a href="loggut">Ferdig</a>
    </p>
</body>
</html>