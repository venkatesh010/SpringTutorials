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
    <!-- Name of modelAttribute is className in camelcase if it is not provided.-->
    <s:form method="post" action="save" modelAttribute="account">
        <p>Account Id</p>
        <div>
            <s:input path="id"></s:input>
            <s:errors path="id"></s:errors>
        </div>

        <p>Name</p>
        <div>
            <s:input path="name"></s:input>
            <s:errors path="name"></s:errors>
        </div>

        <p>Balance</p>
        <div>
            <s:input path="balance"></s:input>
            <s:errors path="balance"></s:errors>
        </div>

        <div>
            <s:button>save</s:button>
        </div>


    </s:form>

</fieldset>




</body>
</html>
