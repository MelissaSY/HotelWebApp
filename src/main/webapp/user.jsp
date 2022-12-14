<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title lang="en">User Page</title>
    <title lang="ru">Страница пользователя</title>
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
            <form method="post">
                <input type="hidden" name="roomId" value="${room.getId()}">
                <button type="submit" lang="en" disabled>Can't be reserved</button>
                <button type="submit" lang="ru" disabled>Номер занят</button>
            </form>
        </c:when>
        <c:otherwise>
            <form method="post" action="Controller">
                <input name="COMMAND" value="RESERVE"/>
                <input type="hidden" name="roomId" value="${room.getId()}">
                <button type="submit" lang="en">Reserve</button>
                <button type="submit" lang="ru">Забронировать</button>
            </form>
        </c:otherwise>
    </c:choose>
</c:forEach>
<h3 lang="en">Ordered rooms</h3>
<h3 lang="ru">Забронированные номера</h3>
<c:set var="orders" value="${sessionScope.orders}"/>
<c:forEach var="order" items="${orders}">
    <div>
        <c:out value="Order id - ${order.getOrderId()}"/>
        <c:out value="User id - ${order.getUserId()}"/>
        <c:out value="Room id - ${order.getRoomId()}"/>
        <form action="Controller" method="post">
            <input type="hidden" name="COMMAND" value="DELETE_BOOKING"/>
            <input type="hidden" name="orderId" value="${order.getId()}"/>
            <input type="hidden" name="roomId" value="${order.getRoomId()}"/>
            <button type="submit" lang="en">Delete reservation</button>
            <button type="submit" lang="ru">Отказаться от брони</button>
        </form>
    </div>
</c:forEach>
<form action="Controller" method="post">
    <input type="hidden" name="COMMAND" value="LOG_OUT">
    <button type="submit" lang="en">Log out</button>
    <button type="submit" lang="ru">Выход</button>
</form>
<script src="LanguageSwitch.js"></script>
</body>
</html>