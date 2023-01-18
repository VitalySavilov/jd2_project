<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="col align-self-center">
        <h1>Your payment is accepted!</h1>
    </div>

    <div class="row">
        <div class="col align-self-start">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Payment information:</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Payment number</th>
                    <td>${payment.id}</td>
                </tr>
                <tr>
                    <th scope="row">Payment date</th>
                    <td>${payment.paymentDate}</td>
                </tr>
                <tr>
                    <th scope="row">Order number</th>
                    <td>${payment.appOrder.id}</td>
                </tr>
                <tr>
                    <th scope="row">Car number</th>
                    <td>${payment.appOrder.car.regNumber}</td>
                </tr>
                <tr>
                    <th scope="row">Sum</th>
                    <td>${payment.appOrder.sum}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col align-self-center">

        </div>
    </div>
</div>


<jsp:include page="_footer.jsp"/>


