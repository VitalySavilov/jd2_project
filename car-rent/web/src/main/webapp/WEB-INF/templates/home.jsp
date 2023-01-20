<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_header.jsp"/>

<div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col"><h2>Statistics:</h2></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">Number of cars:</th>
                <td><c:out value="${carCount}"/></td>
            </tr>
            <tr>
                <th scope="row">Number of users:</th>
                <td><c:out value="${userCount}"/></td>
            </tr>
            <tr>
                <th scope="row">Number of orders:</th>
                <td><c:out value="${orderCount}"/></td>
            </tr>
            <tr>
                <th scope="row">Number of payments:</th>
                <td><c:out value="${paymentCount}"/></td>
            </tr>
            </tbody>
        </table>
</div>

<jsp:include page="_footer.jsp"/>