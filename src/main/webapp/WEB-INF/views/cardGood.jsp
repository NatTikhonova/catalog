<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="good" scope="request" type="com.example.demo.models.Good"/>

<div class="container py-5">
    <h2 class="card-title">${good.name}</h2>
    <p class="card-text">${good.brandGoods} - ${good.typeProduct} - ${good.gender}</p>
    <div class="row row-cols-1 row-cols-sm-1 row-cols-md-2 row-cols-lg-2 align-items-stretch g-4 py-0">
        <div class="col-lg-4">
            <img src="resources/img/goods/${good.goodImg}" class="card-img-top" alt="${good.name}">
        </div>
        <div class="col-lg-8">
            <div class="card-body">
                <p>Объём: ${good.volume} мл<br>ID: ${good.goodId}</p>
                <p class="card-text">${good.info}</p>
                <h3 class="mb-lg-4">${good.price} руб.</h3>
                <button class="btn btn-outline-dark" onclick="addGoodToCart(${good.goodId},'addCart')">Купить</button>
            </div>
        </div>
    </div>
</div>

<script>
    function addGoodToCart(id, actionCart) {
        $.ajax({
            type: "POST",
            url: "cart",
            data: {goodId: id, actionCart: actionCart},
            success: function (answer) {
                alert(answer);
            }
        })
    }
</script>