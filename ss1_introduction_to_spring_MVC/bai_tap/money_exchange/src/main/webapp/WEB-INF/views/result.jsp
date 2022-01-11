<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 1/11/2022
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<html>
<head>
    <title>Input Form</title>
</head>
<body>

    <form method="post" action="/exchange">
        <div class="mb-3">
            <label for="USD" class="form-label">USD: </label>
            <input type="text" class="form-control" id="USD" name="USD" value="${USD}">
        </div>

        <div class="mb-3">
            <label for="ratio" class="form-label">Ratio: </label>
            <input type="text" class="form-control" id="ratio" name="ratio" value="${ratio}">
        </div>

        <div class="mb-3">
            <label for="disabledInput" class="form-label">VND: </label>
            <input class="form-control" id="disabledInput" type="text" value="${VND}" disabled>
        </div>

        <button type="submit" class="btn btn-primary">Exchange</button>
    </form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
