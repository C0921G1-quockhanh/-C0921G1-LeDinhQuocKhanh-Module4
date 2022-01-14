<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 1/14/2022
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Medical_Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

    <form:form method="post" action="" modelAttribute="medicalDeclaration">

        <div class="mt-3 mx-3">
            <h4 class="text-center">MEDICAL DECLARATION</h4>
            <h5 class="text-center">This is an important document, your information will help health authorities contact when necessary to prevent infectious diseases</h5>
            <p class="text-center text-danger fw-bold">Warning: Declaring false information is a violation of Vietnamese law and can be criminally handled</p>
        </div>

        <div class="mt-3 mx-3">
            <label for="fullName" class="form-label fw-bold">FULL NAME: (UPPERCASE) </label>
            <input type="text" class="form-control" id="fullName" name="fullName">
        </div>

    </form:form>






    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
