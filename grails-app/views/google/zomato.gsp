<%--
  Created by IntelliJ IDEA.
  User: asoni
  Date: 3-6-16
  Time: 01:10
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title></title>
</head>

<body>
<%
    for (int i = 0; i < resUrls.size(); i++) {
    String newLink = "Restaurant $i"
%>
    <g:link url="${resUrls.get(i)}">${newLink} </g:link></br>
<%
    }
%>
</body>
</html>