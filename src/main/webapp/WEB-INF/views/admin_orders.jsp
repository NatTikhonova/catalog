<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container py-3" id="custom-cards">
    <h2 class="pb-2 border-bottom">Заказы</h2>
    <div class="row g-0 mb-3">
        <div class="col-md-1">
            <p class="card-text">ID</p>
        </div>
        <div class="col-md-2">
            <p class="card-text">ФИО</p>
        </div>
        <div class="col-md-2">
            <p class="card-text">Email</p>
        </div>
        <div class="col-md-2">
            <p class="card-text">Телефон</p>
        </div>
        <div class="col-md-2">
            <p class="card-text">Дата создания</p>
        </div>
        <div class="col-md-1">
            <p class="card-text">Общая стоимость</p>
        </div>
        <div class="col-md-1">
            <p class="card-text">Статус</p>
        </div>
        <div class="col-md-1">
            <p class="card-text">Действия</p>
        </div>
    </div>
    <c:forEach var="order" items="${ordersListJsp}">
        <div class="row g-0 mb-3">
            <div class="col-md-1">
                <p class="card-text">№ ${order.orderId}</p>
            </div>
            <div class="col-md-2">
                <p class="card-text">${order.user.firstName} ${order.user.lastName}</p>
            </div>
            <div class="col-md-2">
                <p class="card-text">${order.user.email}</p>
            </div>
            <div class="col-md-2">
                <p class="card-text">${order.user.phone}</p>
            </div>
            <div class="col-md-2">
                <p class="card-text">${order.dateСreation}</p>
            </div>
            <div class="col-md-1">
                <p class="card-text">${order.price} руб.</p>
            </div>
            <div class="col-md-1">
                <p class="card-text">${order.status}</p>
            </div>
            <div class="col-md-1">
                <a href="#">Подробнее</a>
            </div>
        </div>
    </c:forEach>
</div>
