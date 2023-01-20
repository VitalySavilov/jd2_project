<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>

<div class="container">

    <div>
        <h1>Orders</h1>
    </div>

        <jsp:include page="_pagination.jsp"/>

    <table class="table">
        <tr>
            <th>№</th>
            <th>Car number</th>
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
                <td><c:out value="${order.carNumber}"/></td>
                <td><c:out value="${order.firstname} ${order.lastname}"/></td>
                <td><c:out value="${order.status}"/></td>
                <td><c:out value="${order.startDate}"/></td>
                <td><c:out value="${order.endDate}"/></td>
                <td><c:out value="${order.sum}"/></td>
                <td><a class="btn btn-light" href="${pageContext.request.contextPath}/orders/order/${order.id}" role="button">Details</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="_footer.jsp"/>