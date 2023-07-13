<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container py-3">
    <form id="sign-in" method="post" enctype="multipart/form-data" class="needs-validation" novalidate>
        <h2 class="pb-2 border-bottom">Вход</h2>
        <div class="row g-3 my-1">
            <div class="col">
                <label for="signInEmail" class="form-label">Адрес электронной почты</label>
                <input type="email" name="signInEmail" class="form-control" id="signInEmail"
                       aria-describedby="emailHelp"
                       placeholder="example@mail.ru"
                       required>
                <div class="invalid-feedback">
                    Не корректный e-mail
                </div>
            </div>
            <div class="col">
                <label for="signInPassword" class="form-label">Пароль</label>
                <input type="password" name="signInPassword" class="form-control"
                       id="signInPassword"
                       placeholder="******"
                       size="6"
                       required>
                <div class="invalid-feedback">
                    Пароль должен иметь не менее 6 символов и состоять из: 0-9, a-z, A-Z или !@#$%^&*
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary my-4">Отправить</button>
    </form>
    <form id="registration" method="post" enctype="multipart/form-data" novalidate>
        <h2 class="pb-2 border-bottom">Регистрация</h2>
        <div class="row g-3 my-1">
            <div class="col">
                <label for="regFirstName" class="form-label">Имя</label>
                <input type="text" class="form-control" name="regFirstName" id="regFirstName" required>
                <div class="invalid-feedback">
                    Введите Имя
                </div>
            </div>
            <div class="col">
                <label for="regLastName" class="form-label">Фамилия</label>
                <input type="text" class="form-control" name="regLastName" id="regLastName">
            </div>
        </div>
        <div class="row g-3 my-1">
            <div class="col">
                <label for="regEmail" class="form-label">Адрес электронной почты</label>
                <input type="email" class="form-control" name="regEmail" id="regEmail" aria-describedby="emailHelp"
                       placeholder="example@mail.ru" required>
                <div class="invalid-feedback">
                    Не корректный e-mail
                </div>
            </div>
            <div class="col">
                <label for="regPhone" class="form-label">Телефон</label>
                <input type="tel" class="form-control" name="regPhone" id="regPhone" placeholder="+79454443322" size="12">
                <div class="invalid-feedback">
                    Введите телефон в формате +79454443322 или оставьте поле пустым
                </div>
            </div>
            <div class="col">
                <label for="regPassword" class="form-label">Пароль</label>
                <input type="password" class="form-control" name="regPassword" id="regPassword" placeholder="******" required>
                <div class="invalid-feedback">
                    Пароль должен иметь не менее 6 символов и состоять из: 0-9, a-z, A-Z или !@#$%^&*
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary my-4">Отправить</button>
    </form>
</div>
<script>
    const regExpEmail = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/i;
    const regExpPassword = /^[\da-zA-Z!@#$%^&*]{6,}$/i;
    const regExpPhone = /^\+79\d{9}$/i;
    const regExpName = /^[a-zа-яA-ZА-Я]+$/i;

    function replaceClass(elem, oldClass, newClass) {
        if (elem.hasClass(oldClass)) {
            elem.removeClass(oldClass);
        }
        elem.addClass(newClass);
    }

    function isValid(regExp, elem, val) {
        if (regExp.test(val) && val != null) {
            replaceClass(elem, "is-invalid", "is-valid");
        } else {
            replaceClass(elem, "is-valid", "is-invalid");
        }
    }

    document.querySelector("#registration").onsubmit = function (e) {
        e.preventDefault();
        let regFirstName = $("#regFirstName");
        let regLastName = $("#regLastName");
        let regEmail = $("#regEmail");
        let regPhone = $("#regPhone");
        let regPassword = $("#regPassword");

        let firstName = regFirstName.val();
        let lastName = regLastName.val();
        let rEmail = regEmail.val();
        let phone = regPhone.val();
        let rPassword = regPassword.val();

        isValid(regExpName, regFirstName, firstName);
        isValid(regExpEmail, regEmail, rEmail);
        isValid(regExpPassword, regPassword, rPassword);

        if (lastName.length === 0 || regExpName.test(lastName)){
            replaceClass(regLastName, "is-invalid", "is-valid");
        } else if (lastName.length > 0 && !regExpName.test(lastName)){
            replaceClass(regLastName, "is-valid", "is-invalid");
        }

        if (phone.length === 0 || regExpPhone.test(phone)){
            replaceClass(regPhone, "is-invalid", "is-valid");
        } else if (phone.length > 0 && !regExpPhone.test(phone)){
            replaceClass(regPhone, "is-valid", "is-invalid");
        }

        let isFormCheck = regFirstName.hasClass("is-valid") &&
            regLastName.hasClass("is-valid") &&
            regEmail.hasClass("is-valid") &&
            regPhone.hasClass("is-valid") &&
            regPassword.hasClass("is-valid");

        if (isFormCheck){
            $.ajax({
                type: "POST",
                url: "registration",
                data: $("#registration").serialize(),
                success: function (answer) {
                    alert(answer);
                    if (answer === "Регистрация прошла успешно!"){
                        location.href = "/user_account";
                    }
                }
            })
        }
    }

    document.querySelector("#sign-in").onsubmit = function (e) {
        e.preventDefault();
        let signInEmail = $("#signInEmail");
        let signInPassword = $("#signInPassword");
        let email = signInEmail.val();
        let password = signInPassword.val();

        isValid(regExpEmail, signInEmail, email);
        isValid(regExpPassword, signInPassword, password);

        if (signInEmail.hasClass("is-valid") && signInPassword.hasClass("is-valid")) {
            $.ajax({
                type: "POST",
                url: "sign-in",
                data: $("#sign-in").serialize(),
                success: function (answer) {
                    alert(answer);
                    if (answer === "Авторизация прошла успешно!"){
                        location.href = "/user_account";
                    }
                }
            })
        }
    }
</script>