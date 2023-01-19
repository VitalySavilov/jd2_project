<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>

<div class="container">

    <div>
        <h1>Payments</h1>
    </div>

    <form action="${url}">

        <jsp:include page="_pagination.jsp"/>

    </form>

    <table class="table">
        <tr>
            <th>Payment number</th>
            <th>Order number</th>
            <th>Car number</th>
            <th>User</th>
            <th>Date</th>
            <th>Sum</th>
            <th></th>
        </tr>
        <c:forEach items="${data.content}" var="payment">
            <tr>
                <td><c:out value="${payment.id}"/></td>
                <td><c:out value="${payment.appOrder.id}"/></td>
                <td><c:out value="${payment.appOrder.carNumber}"/></td>
                <td><c:out value="${payment.appOrder.firstname} ${payment.appOrder.lastname}"/></td>
                <td><c:out value="${payment.paymentDate}"/></td>
                <td><c:out value="${payment.appOrder.sum}"/></td>
                <td><a class="btn btn-light" href="${pageContext.request.contextPath}/payments/${payment.id}" role="button">Details</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="_footer.jsp"/>