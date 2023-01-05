<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style></style>
    <title>AutoCatalog</title>
</head>
<body>
<div class="container">
    <h2>WELCOME to AutoCatalog</h2></br>

    <form action="/" method="post">
        Login: <input name="login" value="" /><br>
        Password: <input name="password" value="" /><br>
        <input type="submit" value="Authorization" />
    </form><br>

    <form action="/Catalog" method="post">
        <input type="submit" value="Auto Catalog" />
    </form><br>

</div>
</body>
</html>