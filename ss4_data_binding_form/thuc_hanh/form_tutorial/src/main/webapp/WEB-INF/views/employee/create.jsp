<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 1/13/2022
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>

    <h3>Welcome, Enter The Employee Details</h3>

    <form:form method="post" action="/employee/addEmployee" modelAttribute="employee">
        <table>

            <tr>
                <td>
                    <form:label path="id">Employee ID:</form:label>
                </td>
                <td>
                    <form:input path="id"></form:input>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="name">Employee Name:</form:label>
                </td>
                <td>
                    <form:input path="name"></form:input>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="contactNumber">Contact Number:</form:label>
                </td>
                <td>
                    <form:input path="contactNumber"></form:input>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="submit">
                </td>
            </tr>

        </table>
    </form:form>


</body>
</html>
