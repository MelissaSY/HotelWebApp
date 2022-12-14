<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title lang="en">Register</title>
    <title lang="ru">Регистрация</title>
</head>
<body>
<h3 lang="en">Register</h3>
<h3 lang="ru">Регистрация</h3>

<select onchange="languageSwitch()" id="language_switch">
    <option value="en">English</option>
    <option value="ru" selected>Русский</option>
</select>

<form action="Controller" method="post">
    <input type="hidden" name="COMMAND" value="REGISTER"/>
        <span lang="en" style="display: none">Email:</span>
        <span lang="ru">Эл.почта:</span>
    <input type="text" name="RegUserLogin"/>
    <br><br>
        <span lang="en">Password:</span>
        <span lang="ru">Пароль:</span>
    <input type="password" name="RegPassword"/>
    <br><br>
        <span lang="en">Name:</span>
        <span lang="ru">Имя:</span>
    <input type="text" name="RegName"/>
    <br><br>
        <span lang="en">Surname:</span>
        <span lang="ru">Фамилия:</span>
    <input type="text" name="RegSurname"/>
    <br><br>
    <button type="submit" value="Sign up">
        <span lang="en">Register</span>
        <span lang="ru">Регистрация</span>
    </button>
</form>
<a href="login.jsp" lang="en">Log In</a>
<a href="login.jsp" lang="ru">Вход</a>
</body>
<script src="LanguageSwitch.js"></script>
</html>