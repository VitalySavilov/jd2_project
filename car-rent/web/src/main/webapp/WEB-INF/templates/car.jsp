<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row justify-content-center">
        <h1>${car.carMark} ${car.carModel} ${car.year}</h1>
    </div>

    <div class="row">
        <div class="col align-self-start">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <c:if test="${fn:length(imageIdList) > 0}">
                        <div class="carousel-item active">
                            <img src="car/image/${imageIdList[0]}" class="d-block w-100" alt="...">
                        </div>
                        <c:forEach begin="${fn:length(imageIdList) - (fn:length(imageIdList) - 1)}"
                                   end="${fn:length(imageIdList) - 1}" var="i">
                            <div class="carousel-item">
                                <img src="car/image/${imageIdList[i]}" class="d-block w-100" alt="...">
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Prev</span>
                </button>
            </div>
        </div>
        <div class="col align-self-center">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Description:</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Type</th>
                    <td>${car.type}</td>
                </tr>
                <tr>
                    <th scope="row">Color</th>
                    <td>${car.color}</td>
                </tr>
                <tr>
                    <th scope="row">Power</th>
                    <td>${car.power}</td>
                </tr>
                <tr>
                    <th scope="row">Fuel</th>
                    <td>${car.fuelType}</td>
                </tr>
                <tr>
                    <th scope="row">Consumption</th>
                    <td>${car.fuelConsumption}</td>
                </tr>
                <tr>
                    <th scope="row">Price</th>
                    <td>${car.price}</td>
                </tr>
                </tbody>
            </table>

            <security:authorize access="isAuthenticated()">

                <form action="${pageContext.request.contextPath}/orders/order?carId=${car.id}" method="post">

<%--                    <div class="col-md-4">--%>
<%--                        <label for="inputMark" class="form-label">Days</label>--%>
<%--                        <input type="number" class="form-control" name="days" value="1" id="inputMark">--%>
<%--                    </div>--%>

<%--                    <div class="col-md-4">--%>
<%--                        <button type="submit" class="btn btn-light">Checkout</button>--%>
<%--                    </div>--%>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Days:</th>
                            <th scope="col">Order a car:</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">
                                <div class="col-md-4">
                                    <input type="number" class="form-control" name="days" value="1">
                                </div>
                            </th>
                            <td>
                                <div class="col-md-4">
                                    <button type="submit" class="btn btn-secondary">Checkout</button>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>

            </security:authorize>

        </div>
    </div>
</div>

<jsp:include page="_footer.jsp"/>


