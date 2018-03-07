<%--
  Created by IntelliJ IDEA.
  User: SEEDINFOTECH
  Date: 3/7/2018
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1>Welcome to views jsp</h1>
<h3>Message: <%=request.getAttribute("fmsg")%></h3>
<h3>Say: ${fmsg}</h3>
<h3>Cookie: ${testCookie}</h3>

<h2>Account Info</h2>
<h3>id: ${account.id}</h3>
<h3>name: ${account.name}</h3>
<h3>balance: ${account.balance}</h3>
</body>
</html>
