<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header class="p-3 bg-mydark text-white">
  <div class="container">
    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
      <a href="${pageContext.request.contextPath}/catalog" class="d-flex align-items-center me-2 mb-lg-0 text-white text-decoration-none">
        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
             class="bi bi-bootstrap-reboot" viewBox="0 0 16 16">
          <path d="M1.161 8a6.84 6.84 0 1 0 6.842-6.84.58.58 0 1 1 0-1.16 8 8 0 1 1-6.556 3.412l-.663-.577a.58.58 0 0 1 .227-.997l2.52-.69a.58.58 0 0 1 .728.633l-.332 2.592a.58.58 0 0 1-.956.364l-.643-.56A6.812 6.812 0 0 0 1.16 8z"></path>
          <path d="M6.641 11.671V8.843h1.57l1.498 2.828h1.314L9.377 8.665c.897-.3 1.427-1.106 1.427-2.1 0-1.37-.943-2.246-2.456-2.246H5.5v7.352h1.141zm0-3.75V5.277h1.57c.881 0 1.416.499 1.416 1.32 0 .84-.504 1.324-1.386 1.324h-1.6z"></path>
        </svg>
      </a>

      <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
        <li><a href="#" class="nav-link px-2 text-white">О нас</a></li>
        <li><a href="#" class="nav-link px-2 text-white">Обучение</a></li>
        <li><a href="#" class="nav-link px-2 text-white">Запись</a></li>
        <li><a href="${pageContext.request.contextPath}/catalog" class="nav-link px-2 text-warning">Продукция</a></li>
      </ul>

      <div class="text-end">
        <jsp:include page="${authorization}"></jsp:include>
        <button type="button" class="btn btn-outline-warning" onclick="document.location='/cart'">Корзина [<span>${countCart}</span>]</button>
      </div>
    </div>
  </div>
</header>