<!DOCTYPE html>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<h1>Restaurant</h1><hr>
<#if user.isAdmin()>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти">
    </form>
    <#else>
        <form action="/login" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Редактировать">
        </form>
</#if>

<#list segments as segment>
    <div>
        <div style="display: flex; align-items: center; gap: 10px">
            <h3>${segment.title}</h3>

            <#if user.isAdmin()>
            <form action="/admin/segment/delete/${segment.id}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" value="Удалить сегмент">
            </form>
            </#if>
        </div>


        <#list segment.dishes as dish>
            <img src="/images/${dish.previewImageId}" height="120px" alt="Фотокарточка">
            <div style="display: flex; align-items: center; gap: 10px">
                <p><b>${dish.title}</b> ${dish.price} руб. | <a href="/dish/${dish.id}">Подробнее...</a>
                <#if user.isAdmin()>
                <form action="/admin/dish/delete/${dish.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Удалить блюдо">
                </form>
                </#if>
                </p>
            </div>
        </#list>
        <#if user.isAdmin()>
        <form action="/admin/dish/create/${segment.id}" method="get">
            <input type="submit" value="Добавить блюдо">
        </form>
        </#if>
        <hr>
    </div>
</#list>
<#if user.isAdmin()>
<form action="/admin/segment/create" method="post">
    <input type="text" name="title">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить сегмент">
</form>
</#if>
</body>
</html>