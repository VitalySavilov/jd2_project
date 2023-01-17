<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="_header.jsp"/>

<div class="container">

    <div>
        <h1>Cars</h1>
    </div>

    <form action="${url}">

        <jsp:include page="_pagination.jsp"/>

        <div class="col-md-4">
            <label for="inputMark" class="form-label">Mark</label>
            <input type="text" class="form-control" name="mark" value="${filter.mark}" id="inputMark">
        </div>
        <div class="col-md-4">
            <label for="inputType" class="form-label">Type</label>
            <input type="text" class="form-control" name="type" value="${filter.type}" id="inputType">
        </div>

        <button type="submit" class="btn btn-light">filter</button>
    </form>

    <table class="table">
        <tr>
            <security:authorize access="hasRole('ADMIN')">
                <th>Reg Number</th>
            </security:authorize>
            <th>Model</th>
            <security:authorize access="hasRole('ADMIN')">
                <th>Status</th>
            </security:authorize>
            <th>Year</th>
            <th>Type</th>
            <th>Color</th>
            <th>Price</th>
            <th></th>
        </tr>
        <c:forEach items="${data.content}" var="car">
            <tr>
                <security:authorize access="hasRole('ADMIN')">
                    <td><c:out value="${car.regNumber}"/></td>
                </security:authorize>
                <td><c:out value="${car.carMark} ${car.carModel}"/></td>
                <security:authorize access="hasRole('ADMIN')">
                    <td><c:out value="${car.status}"/></td>
                </security:authorize>
                <td><c:out value="${car.year}"/></td>
                <td><c:out value="${car.type}"/></td>
                <td><c:out value="${car.color}"/></td>
                <td><c:out value="${car.price}"/></td>
                <security:authorize access="!isAuthenticated() or !hasRole('ADMIN')">
                    <td>
                        <a class="btn btn-light" href="${pageContext.request.contextPath}/cars/${car.id}" role="button">Details</a>
                    </td>
                </security:authorize>
                <security:authorize access="hasRole('ADMIN')">
                    <td>
                        <a class="btn btn-light" href="${pageContext.request.contextPath}/cars/car/${car.id}" role="button">Details</a>
                    </td>
                </security:authorize>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="_footer.jsp"/>



