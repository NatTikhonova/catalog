<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container py-3" id="custom-cards">
    <h2 class="pb-2 border-bottom">Личные данные</h2>
    <p class="card-text">${user.firstName} ${user.lastName}</p>
    <p class="card-text">Email: ${user.email}</p>
    <p class="card-text">Телефон: ${user.phone}</p>

    <h2 class="pb-2 border-bottom">Заказы</h2>
        <c:forEach var="order" items="${orderList}">
            <div class="row g-0 mb-3">
                <div class="col-md-3">
                    <p class="card-text">№ ${order.orderId}</p>
                </div>
                <div class="col-md-3 my-1">
                    <p class="card-text">${order.dateСreation}</p>
                </div>
                <div class="col-md-3 my-1">
                    <p class="card-text">${order.price} руб.</p>
                </div>
                <div class="col-md-3 my-1">
                    <p class="card-text">${order.status}</p>
                </div>
            </div>
        </c:forEach>
</div>