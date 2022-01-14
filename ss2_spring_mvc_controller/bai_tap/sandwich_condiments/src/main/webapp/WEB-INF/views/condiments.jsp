<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 1/12/2022
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sandwich_Condiments</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

    <form method="post" action="/sandwich" class="mt-5 ms-5">

        <div class="mb-3">
            <h2>Sandwich Condiments</h2>
        </div>

        <div class="btn-group mb-3" role="group" aria-label="Basic checkbox toggle button group">
            <input type="checkbox" class="btn-check" id="lettuce" autocomplete="off" value="lettuce" name="condiments">
            <label class="btn btn-outline-secondary" for="lettuce">Lettuce</label>

            <input type="checkbox" class="btn-check" id="tomato" autocomplete="off" value="tomato" name="condiments">
            <label class="btn btn-outline-secondary" for="tomato">Tomato</label>

            <input type="checkbox" class="btn-check" id="mustard" autocomplete="off" value="mustard" name="condiments">
            <label class="btn btn-outline-secondary" for="mustard">Mustard</label>

            <input type="checkbox" class="btn-check" id="sprouts" autocomplete="off" value="sprouts" name="condiments">
            <label class="btn btn-outline-secondary" for="sprouts">Sprouts</label>
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-secondary">Save</button>
        </div>

    </form>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
