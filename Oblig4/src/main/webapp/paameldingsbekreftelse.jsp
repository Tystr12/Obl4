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
<title>P�meldingsbekreftelse</title>
</head>
<body>
    <h2>P�meldingsbekreftelse</h2>
    <p>P�meldingen er mottatt for</p>
        <p><c:out value="${deltager.fornavn}"/></p>
        <p><c:out value="${deltager.etternavn}"/></p>
        <p><c:out value="${deltager.mobil}"/></p>
        <p><c:out value="${deltager.kjonn}"/></p>
    <a href="/Oblig4/deltagerliste">G� til deltagerlisten</a>
</body>
</html>