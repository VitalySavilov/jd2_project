<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>

<h1>Users</h1>

<jsp:include page="_pagination.jsp"/>

<table style="width:100%" class="table">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>firstname</th>
        <th>lastname</th>
        <th>birthDate</th>
        <th>email</th>
        <th>telNumber</th>
        <th>roles</th>
    </tr>
    <c:forEach items="${data.content}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.username}"/></td>
            <td><c:out value="${user.appUserInfo.firstname}"/></td>
            <td><c:out value="${user.appUserInfo.lastname}"/></td>
            <td><c:out value="${user.appUserInfo.birthDate}"/></td>
            <td><c:out value="${user.appUserInfo.email}"/></td>
            <td><c:out value="${user.appUserInfo.telNumber}"/></td>
            <c:forEach items="${user.roles}" var="role">
                <td><c:out value="${role.name} "/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>





