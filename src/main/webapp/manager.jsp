<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title lang="en">Manager Page</title>
    <title lang="ru">Страница менеджера</title>
</head>
<body>
<select id="language_switch" onchange="languageSwitch()">
    <option value="en">English</option>
    <option value="ru" selected>Русский</option>
</select>
<h3 lang="en">Rooms</h3>
<h3 lang="ru">Номера</h3>
<c:forEach var="room" items="${sessionScope.rooms}">
    <c:out value="${room.getId()}"/>
    <c:out value="${room.getNumber()}"/>
    <c:choose>
        <c:when test="${room.isReserved()}">
            <form method="post" action="Controller">
                <input name="COMMAND" value="DELETE_BOOKING"/>
                <input type="hidden" name="roomId" value="${room.getId()}"/>
                <button type="submit" lang="en">Unreserve</button>
                <button type="submit" lang="ru">Освободить</button>
            </form>
        </c:when>
        <c:otherwise>
            <form method="post" action="Controller">
                <input name="COMMAND" value="RESERVE"/>
                <input type="hidden" name="roomId" value="${room.getId()}"/>
                <button type="submit" lang="en">Reserve</button>
                <button type="submit" lang="ru">Забронировать</button>
            </form>
        </c:otherwise>
    </c:choose>
</c:forEach>
<h3 lang="en">Add new room</h3>
<h3 lang="ru">Добавить номер</h3>
<form action="Controller" method="post">
    <input name="COMMAND" value="ADD_ROOM">
    <span lang="en">Room number:</span>
    <span lang="ru">Номер:</span>
    <input type="number" name="roomNumber">
    <span lang="en">Price:</span>
    <span lang="ru">Цена:</span>
    <input type="number" name="price">
    <button type="submit" lang="en">Add new room</button>
    <button type="submit" lang="ru">Добавить номер</button>
</form>
<form action="Controller" method="post">
    <input type="hidden" name="COMMAND" value="LOG_OUT">
    <button type="submit" lang="en">Log out</button>
    <button type="submit" lang="ru">Выход</button>
</form>

<script src="LanguageSwitch.js"></script>
</body>
</html>