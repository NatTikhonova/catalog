<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container py-3" id="custom-cards">
    <h2 class="pb-2 border-bottom">Клиенты</h2>
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
            <p class="card-text">Дата регистрации</p>
        </div>
        <div class="col-md-1">
            <p class="card-text">Пароль</p>
        </div>
        <div class="col-md-1">
            <p class="card-text">Admin</p>
        </div>
        <div class="col-md-1">
            <p class="card-text">Действия</p>
        </div>
    </div>
    <c:forEach var="user" items="${usersListJsp}">
        <div class="row g-0 mb-3">
            <div class="col-md-1">
                <p class="card-text">№ ${user.userId}</p>
            </div>
            <div class="col-md-2">
                <p class="card-text">${user.firstName} ${user.lastName}</p>
            </div>
            <div class="col-md-2">
                <p class="card-text">${user.email}</p>
            </div>
            <div class="col-md-2">
                <p class="card-text">${user.phone}</p>
            </div>
            <div class="col-md-2">
                <p class="card-text">${user.registrationDate}</p>
            </div>
            <div class="col-md-1">
                <p class="card-text">${user.password}</p>
            </div>
            <div class="col-md-1">
                <p class="card-text">${user.isAdmin}</p>
            </div>
            <div class="col-md-1">
                <a href="#">Редактировать</a>
            </div>
        </div>
    </c:forEach>
</div>
