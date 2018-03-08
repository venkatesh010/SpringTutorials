<%--
  Created by IntelliJ IDEA.
  User: SEEDINFOTECH
  Date: 3/8/2018
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "s" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>accountDetails</title>
</head>
<body>
<h2>

    Details of accounts: </h2>

<table>

    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Balance</td>
    </tr>

    <tbody>
    <s:forEach items="${listOfAccounts}" var="temp">
        <tr>
            <td>${temp.id}</td>
            <td>${temp.name}</td>
            <td>${temp.balance}</td>
        </tr>
    </s:forEach>
    </tbody>
</table>


</body>
</html>
