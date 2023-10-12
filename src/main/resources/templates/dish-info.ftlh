<!DOCTYPE html>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<h1>Restaurant</h1><hr>
<form action="/" method="пуе">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Назад">
</form>
<h4>Подробная информация о блюде</h4>
<#if images??>
    <#list images as image>
        <img src="/images/${image.id}" height="60px"><br><br>
    </#list>
</#if>
${dish.title}<br>
${dish.description}<br>
${dish.price} руб.<br>
</body>
</html>