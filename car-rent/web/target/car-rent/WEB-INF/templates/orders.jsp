<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>

<div class="container">

    <div>
        <h1>Orders</h1>
    </div>

    <form action="${url}">

        <jsp:include page="_pagination.jsp"/>

<%--        <div class="col-md-4">--%>
<%--            <label for="inputMark" class="form-label">Mark</label>--%>
<%--            <input type="text" class="form-control" name="mark" value="${filter.mark}" id="inputMark">--%>
<%--        </div>--%>
<%--        <div class="col-md-4">--%>
<%--            <label for="inputType" class="form-label">Type</label>--%>
<%--            <input type="text" class="form-control" name="type" value="${filter.type}" id="inputType">--%>
<%--        </div>--%>

        <button type="submit" class="btn btn-light">filter</button>
    </form>

    <table class="table">
        <tr>
            <th>№</th>
            <th>Car</th>
            <th>User</th>
            <th>Status</th>
            <th>Date start</th>
            <th>Date end</th>
            <th>Sum</th>
            <th></th>
        </tr>
        <c:forEach items="${data.content}" var="order">
            <tr>
                <td><c:out value="${order.id}"/></td>
                <td><c:out value="${order.car.carMark} ${order.car.carModel} ${order.car.year}"/></td>
                <td><c:out value="${order.appUser.appUserInfo.firstname} ${order.appUser.appUserInfo.lastname}"/></td>
                <td><c:out value="${order.status}"/></td>
                <td><c:out value="${order.startDate}"/></td>
                <td><c:out value="${order.endDate}"/></td>
                <td><c:out value="${order.sum}"/></td>
                <td><a class="btn btn-light" href="${pageContext.request.contextPath}/order/${order.id}" role="button">Details</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="_footer.jsp"/>