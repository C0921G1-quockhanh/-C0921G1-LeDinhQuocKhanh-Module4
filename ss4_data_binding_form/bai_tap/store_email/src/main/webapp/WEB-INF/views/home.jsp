<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 1/13/2022
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Setting_Home</title>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>

</head>
<body>

    <h2>Settings</h2>

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




<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>--%>

</body>
</html>
