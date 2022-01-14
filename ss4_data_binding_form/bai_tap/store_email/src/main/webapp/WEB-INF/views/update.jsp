<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 1/13/2022
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update_Email</title>
</head>
<body>

<h2>Settings</h2>

<h3 style="color: blue">${msgUpdate}</h3>

<form:form method="post" action="/update" modelAttribute="email">
    <fieldset>
        <legend style="font-weight: bold">Email</legend>

        <table>
            <tr>
                <td><form:label path="languages">Languages: </form:label></td>
                <td>
                    <form:select path="languages" multiple="false">
                        <form:option value="NONE">Choose a language</form:option>
                        <form:options items="${languageList}"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td><form:label path="pageSize">Page Size: </form:label></td>
                <td>
                    Show
                    <form:select path="pageSize" multiple="false">
                        <form:option value="-1">Choose size of page</form:option>
                        <form:options items="${sizes}"/>
                    </form:select>
                    emails per page
                </td>
            </tr>

            <tr>
                <td><form:label path="spamFilter">Spams Filter: </form:label></td>
                <td>
                    <form:checkbox path="spamFilter" value="true"/> Enable spams filter
                </td>
            </tr>

            <tr>
                <td><form:label path="signature">Signature: </form:label></td>
                <td>
                    <form:textarea path="signature" cols="25" rows="5"/>
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Update" style="background-color: cornflowerblue" name="confirm">
                    <input type="submit" value="Cancel" name="confirm">
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>

</body>
</html>
