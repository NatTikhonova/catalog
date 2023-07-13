<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container py-3" id="custom-cards">
    <h2 class="pb-2 border-bottom">Продукты</h2>
    <div class="row g-0 mb-3">
        <div class="col-md-1">
            <p class="card-text">Фото</p>
        </div>
        <div class="col-md-3">
            <p class="card-text">Название</p>
        </div>
        <div class="col-md-1">
            <p class="card-text">Объем</p>
        </div>
        <div class="col-md-1">
            <p class="card-text">Бренд</p>
        </div>
        <div class="col-md-2">
            <p class="card-text">Тип</p>
        </div>
        <div class="col-md-2">
            <p class="card-text">Для кого</p>
        </div>
        <div class="col-md-1">
            <p class="card-text">Стоимость</p>
        </div>
        <div class="col-md-1">
            <p class="card-text">Действия</p>
        </div>
    </div>
    <c:forEach var="good" items="${goodsListJsp}">
        <div class="row g-0 mb-3">
            <div class="col-md-1">
                <img src="resources/img/goods/${good.goodImg}" class="rounded-start" height="60px" width="auto"
                     alt="${good.name}">
            </div>
            <div class="col-md-3">
                <a href="#"><p class="card-text"> ID ${good.goodId}. ${good.name}</p></a>
            </div>
            <div class="col-md-1">
                <p class="card-text">${good.volume}</p>
            </div>
            <div class="col-md-1">
                <p class="card-text">${good.brandGoods}</p>
            </div>
            <div class="col-md-2">
                <p class="card-text">${good.typeProduct}</p>
            </div>
            <div class="col-md-2">
                <p class="card-text">${good.gender}</p>
            </div>
            <div class="col-md-1">
                <p class="card-text">${good.price} руб.</p>
            </div>
            <div class="col-md-1">
                <a href="#"><p class="card-text">Редактировать</p></a>
            </div>
        </div>
    </c:forEach>
</div>
