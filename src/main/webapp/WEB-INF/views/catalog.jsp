<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container py-3" id="custom-cards">
    <h2 class="pb-2 border-bottom">Продукция</h2>
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-2 row-cols-lg-4 align-items-stretch g-4 py-5">
        <c:forEach var="item" items="${goodsListJsp}">
            <div class="col">
                <div class="card border-0" style="width: 18rem;">
                    <img src="resources/img/goods/${item.goodImg}" class="card-img-top" alt="${item.name}">
                    <div class="card-body">
                        <h3>${item.price} руб</h3>
                        <p>Объём: ${item.volume} мл<br>ID: ${item.goodId}</p>
                        <a href="<c:url value="/cardGood?id=${item.goodId}"/>" class="text-dark card-link"><h5
                                class="card-title">${item.name}</h5></a>
                        <p class="card-text">${item.brandGoods} - ${item.typeProduct} - ${item.gender}</p>
                        <button class="btn btn-outline-dark" onclick="addGoodToCart(${item.goodId},'addCart')">Купить
                        </button>
                    </div>
                </div>
            </div>
        </c:forEach>
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
