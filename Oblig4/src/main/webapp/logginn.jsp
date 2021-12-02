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
    
<link rel="stylesheet" href="styles.css">
<script src="script.js"></script>
<title>Logg inn</title>
</head>
<body>
    <h2>Logg inn</h2>
     <p class="feilmelding"><c:out value="${feilmelding}"></c:out></p>
    <p>
        <!--<font color="red">Ugyldig brukernavn og/eller passord</font>-->
    </p>
    <form action ="innlogging" method="post" class="pure-form pure-form-aligned">
        <fieldset>
            <div class="pure-control-group">
                <label for="mobil">Mobil:</label> <input type="text" name="mobil" />
            </div>
            <div class="pure-control-group">
                <label for="passord">Passord:</label> <input type="password"
                    name="passord" />
            </div>
            <div class="pure-controls">
                <button type="submit" class="pure-button pure-button-primary">Logg
                    inn</button>
            </div>
        </fieldset>
    </form>
    <p>Er ikke du registrert? <a href="/Oblig4/paamelding.jsp">Registrer deg her</a></p>

</body>
</html>