<!DOCTYPE html>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<h1>Restaurant</h1><hr>

<form action="/admin/dish/create" method="post" enctype="multipart/form-data">
    Название <input type="text" name="title"><br><br>
    Описание <input type="text" name="description"><br><br>
    Цена <input type="number" name="price"><br><br>
    Первая фотография <input type="file" name="file1"><br><br>
    Вторая фотография <input type="file" name="file2"><br><br>
    Третья фотография <input type="file" name="file3"><br><br>
    <input type="hidden" name="segmentId" value="${segmentId}">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить">
</form>

</body>
</html>