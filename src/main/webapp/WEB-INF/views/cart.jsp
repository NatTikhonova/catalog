<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container py-3" id="custom-cards">
    <h2 class="pb-2 border-bottom">Корзина</h2>
    <c:forEach var="cart" items="${cartListJsp}">
        <div class="row g-0 mb-3">
            <div class="col-md-1">
                <img src="resources/img/goods/${cart.good.goodImg}" class="rounded-start" height="60px" width="auto"
                     alt="${cart.good.name}">
            </div>
            <div class="col-md-8">
                <a href="<c:url value="/cardGood?id=${cart.good.goodId}"/>"><h5 class="card-title my-3">
                    ID ${cart.good.goodId}. ${cart.good.name}</h5></a>
            </div>
            <div class="col-md-1 my-1">
                <p class="card-text">${cart.good.price} руб.</p>
            </div>
            <div class="col-md-1 my-1">
                <p class="card-text">${cart.count} шт.</p>
            </div>
            <div class="col-md-1 my-1">
                <button class="btn btn-outline-dark" onclick="deleteCart(${cart.cartId})">Удалить</button>
            </div>
        </div>
    </c:forEach>
    <h2 class="pb-2 border-bottom">Итоговая сумма: ${totalCartValue} руб.</h2>
    <button class="btn btn-outline-dark" onclick="newOrder()">Оформить заказ</button>
</div>

<script>
    function deleteCart(cartId) {
        $.ajax({
            type: "POST",
            url: "cart",
            data: {id: cartId, actionCart: "deleteCart"},
            success: function (answer) {
                alert(answer);
            }
        })
    }
    function newOrder() {
        $.ajax({
            type: "POST",
            url: "cart",
            data: {actionCart: "newOrder", orderDelivery: $('#orderDelivery').text()},
            success: function (answer) {
                alert(answer);
            }
        })
    }
</script>