<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col align-self-start">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col"><h2>Payment:</h2></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Payment number</th>
                    <td>${payment.id}</td>
                </tr>
                <tr>
                    <th scope="row">Order number</th>
                    <td>${payment.appOrder.id}</td>
                </tr>
                <tr>
                    <th scope="row">Car number</th>
                    <td>${payment.appOrder.carNumber}</td>
                </tr>
                <tr>
                    <th scope="row">Firstname</th>
                    <td>${payment.appOrder.firstname}</td>
                </tr>
                <tr>
                    <th scope="row">Lastname</th>
                    <td>${payment.appOrder.lastname}</td>
                </tr>
                <tr>
                    <th scope="row">Date</th>
                    <td>${payment.paymentDate}</td>
                </tr>
                <tr>
                    <th scope="row">Sum</th>
                    <td>${payment.appOrder.sum}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col align-self-start">
            <form method="post" action="${pageContext.request.contextPath}/payments/${payment.id}/delete" class="row g-3">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"><h2>Edit payment:</h2></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">Delete payment</th>
                        <td>
                            <button type="submit" class="btn btn-secondary">Apply</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>

<jsp:include page="_footer.jsp"/>


