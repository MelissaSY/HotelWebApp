<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title lang="en">Log In</title>
  <title lang="ru">Вход</title>
</head>
<body>
<h3 lang="en">Log In</h3>
<h3 lang="ru">Вход</h3>

<select onchange="changeLanguage()" id="language_switch">
  <option value="en">English</option>
  <option value="ru" selected>Русский</option>
</select>

<form action="Controller" method="post">
  <input type="hidden" name="COMMAND" value="LOG_IN"/>
    <span lang="en" style="display: none">Email:</span>
    <span lang="ru">Эл.почта:</span>
  <input type="text" name="RegUserLogin"/>
  <br><br>
  <span lang="en">Password:</span>
  <span lang="ru">Пароль:</span>
  <input type="password" name="RegPassword"/>
  <button type="submit" value="Sign up">
    <span lang="en">Register</span>
    <span lang="ru">Регистрация</span>
  </button>
</form>
<a href="index.jsp" lang="en">Register</a>
<a href="index.jsp" lang="ru">Регистрация</a>
</body>
<script src="LanguageSwitch.js"></script>
</html>