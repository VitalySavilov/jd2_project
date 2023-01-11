<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>

<h1>Users</h1>

<form action="${url}">

    <jsp:include page="_pagination.jsp"/>

<%--    <div class="col-md-4">--%>
<%--        <label for="inputMark" class="form-label">Mark</label>--%>
<%--        <input type="text" class="form-control" name="mark" value="${filter.mark}" id="inputMark">--%>
<%--    </div>--%>
<%--    <div class="col-md-4">--%>
<%--        <label for="inputType" class="form-label">Type</label>--%>
<%--        <input type="text" class="form-control" name="type" value="${filter.type}" id="inputType">--%>
<%--    </div>--%>
<%--    <button type="submit" class="btn btn-light">filter</button>--%>
</form>

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





