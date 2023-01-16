<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>

<div class="container">

    <div>
        <h1>Payments</h1>
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
            <th>Payment number</th>
            <th>Order number</th>
            <th>Car</th>
            <th>User</th>
            <th>Date</th>
            <th>Sum</th>
            <th></th>
        </tr>
        <c:forEach items="${data.content}" var="payment">
            <tr>
                <td><c:out value="${payment.id}"/></td>
                <td><c:out value="${payment.appOrder.id}"/></td>
                <td><c:out value="${payment.appOrder.car.carMark} ${payment.appOrder.car.carModel} ${payment.appOrder.car.year}"/></td>
                <td><c:out value="${payment.appOrder.appUser.appUserInfo.firstname} ${payment.appOrder.appUser.appUserInfo.lastname}"/></td>
                <td><c:out value="${payment.paymentDate}"/></td>
                <td><c:out value="${payment.appOrder.sum}"/></td>
                <td><a class="btn btn-light" href="${pageContext.request.contextPath}/payment/${payment.id}" role="button">Details</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="_footer.jsp"/>