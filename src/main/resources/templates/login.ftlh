<!DOCTYPE html>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<form action="/login" method="post">
    name :<label><input type="text" name="username"></label><br><br>
    password: <label><input type="password" name="password"></label><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход">
</form>

</body>
</html>