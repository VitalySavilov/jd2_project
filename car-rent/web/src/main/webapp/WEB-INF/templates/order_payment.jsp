<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="col align-self-center">
        <h1>Your order is accepted!</h1>
    </div>

    <div class="row">
        <div class="col align-self-start">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Order information:</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Order number</th>
                    <td>${userOrder.id}</td>
                </tr>
                <tr>
                    <th scope="row">Car</th>
                    <td>${userOrder.car.carMark} ${userOrder.car.carModel} ${userOrder.car.year}</td>
                </tr>
                <tr>
                    <th scope="row">Color</th>
                    <td>${userOrder.car.color}</td>
                </tr>
                <tr>
                    <th scope="row">Type</th>
                    <td>${userOrder.car.type}</td>
                </tr>
                <tr>
                    <th scope="row">startDate</th>
                    <td>${userOrder.startDate}</td>
                </tr>
                <tr>
                    <th scope="row">endDate</th>
                    <td>${userOrder.endDate}</td>
                </tr>
                <tr>
                    <th scope="row">Sum</th>
                    <td>${userOrder.sum}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col align-self-center">
            <form action="${pageContext.request.contextPath}/order/${userOrder.id}/payment" method="post">

                <div class="col-md-4">
                    <label for="inputCars" class="form-label">Payment card</label>
                    <select id="inputCars" class="form-select" name="card">
                        <c:forEach items="${userCards}" var="card">
                            <option value="${card.cardNumber}">${card.cardNumber}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-light">Pay online</button>
            </form>
        </div>
    </div>
</div>


<jsp:include page="_footer.jsp"/>


