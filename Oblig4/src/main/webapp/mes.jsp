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
<title>Messages</title>
</head>
<body>
    <h2>Messages</h2>
    <table class="pure-table">
    <tr>
            <th align="left">Author</th>
            <th align="left">Subject</th>
            <th align="left">Contents</th>
            <th align="left">Created on</th>
            </tr>
            <c:forEach items="${messages}" var="m">
            <c:if test="${innmobil  == m.message_author}">
                <tr bgcolor="#aaffaa">
            </c:if>
            <c:if test="${innmobil  != m.message_author}">
                <tr>
             </c:if>
            <td><c:out value="${m.message_author}"/></td>
            <td><c:out value=" ${m.message_subject}"/></td>
            <td><c:out value="${m.message_contents}"/></td>
            <td><c:out value="${m.created_on}"/></td>
           </tr>
            </c:forEach>
            
    </table> <br><br><br><br>
    
    <form action ="Messaging" method="post" class="pure-form pure-form-aligned">
        <fieldset>
            <div class="pure-control-group">
                <label for="mobil">Subject:</label> <input type="text" name="subject" />
            </div>
            <div class="pure-control-group">
                <label for="passord">Content:</label> <textarea rows="4" cols="50" 
                placeholder="Write your message here" name="contents"></textarea>
            </div>
            <div class="pure-controls">
                <button type="submit" class="pure-button pure-button-primary">Send
                    inn</button>
            </div>
        </fieldset>
    </form>
    
    <p>
        <a href="loggut">Ferdig</a>
    </p>
    <script src="messager.js"></script>
</body>
</html>