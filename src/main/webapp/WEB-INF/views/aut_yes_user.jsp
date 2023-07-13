<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href=${pageContext.request.contextPath}/user_account>
    <button type="button" class="btn btn-outline-light me-2">Здравствуйте, ${userFirstName}!</button></a>
<a href=${pageContext.request.contextPath}/authorization?action=del>
    <button type="button" class="btn btn-outline-light me-2">Выход</button>
</a>