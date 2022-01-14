<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 1/12/2022
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>


    <form method="post" action="/calculate" class="mt-5 ms-5">

        <div class="mb-3">
            <h2>Calculator</h2>
        </div>

        <div class="mb-3">
            <label for="firstOperand" class="form-label fw-bold">First Operand: </label>
            <input type="text" class="form-control" id="firstOperand" name="firstOperand" value="${firstOperand}">
        </div>

        <div class="mb-3">
            <label for="secondOperand" class="form-label fw-bold">Second Operand: </label>
            <input type="text" class="form-control" id="secondOperand" name="secondOperand" value="${secondOperand}">
        </div>

        <div class="mb-3">
            <label for="disabledInput" class="form-label fw-bold">Answer: </label>
            <input class="form-control" id="disabledInput" type="text" value="${finalAnswer}" disabled>
        </div>

        <div class="mb-3">
<%--            <button type="submit" class="btn btn-secondary" value="Addition" name="Addition">Addition</button>--%>
<%--            <button type="submit" class="btn btn-secondary ms-4" value="Subtraction" name="Subtraction">Subtraction</button>--%>
<%--            <button type="submit" class="btn btn-secondary ms-4" value="Multiplication" name="Multiplication">Multiplication</button>--%>
<%--            <button type="submit" class="btn btn-secondary ms-4" value="Division" name="Division">Division</button>--%>
            <button type="submit" class="btn btn-secondary" value="Addition" name="calculate">Addition</button>
            <button type="submit" class="btn btn-secondary ms-4" value="Subtraction" name="calculate">Subtraction</button>
            <button type="submit" class="btn btn-secondary ms-4" value="Multiplication" name="calculate">Multiplication</button>
            <button type="submit" class="btn btn-secondary ms-4" value="Division" name="calculate">Division</button>
        </div>


    </form>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
