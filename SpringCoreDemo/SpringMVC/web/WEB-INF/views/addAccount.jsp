<%--
  Created by IntelliJ IDEA.
  User: SEEDINFOTECH
  Date: 3/7/2018
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>addAccount</title>
</head>
<body>

<h3>Crete New Account</h3>

<fieldset>
    <s:form method="post" action="save" modelAttribute="account">
        <p>Account Id</p>
        <div>
            <s:input path="id"></s:input>
        </div>

        <p>Name</p>
        <div>
            <s:input path="name"></s:input>
        </div>

        <p>Balance</p>
        <div>
            <s:input path="balance"></s:input>
        </div>

        <div>
            <s:button>save</s:button>
        </div>


    </s:form>

</fieldset>




</body>
</html>
