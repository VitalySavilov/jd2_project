<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col align-self-start">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col"><h2>Order:</h2></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Order number</th>
                    <td>${order.id}</td>
                </tr>
                <tr>
                    <th scope="row">Status</th>
                    <td>${order.status}</td>
                </tr>
                <tr>
                    <th scope="row">User</th>
                    <td>${order.appUser.username}</td>
                </tr>
                <tr>
                    <th scope="row">Firstname</th>
                    <td>${order.appUser.appUserInfo.firstname}</td>
                </tr>
                <tr>
                    <th scope="row">Lastname</th>
                    <td>${order.appUser.appUserInfo.lastname}</td>
                </tr>
                <tr>
                    <th scope="row">Car mark</th>
                    <td>${order.car.carMark}</td>
                </tr>
                <tr>
                    <th scope="row">Car model</th>
                    <td>${order.car.carModel}</td>
                </tr>
                <tr>
                    <th scope="row">Date start</th>
                    <td>${order.startDate}</td>
                </tr>
                <tr>
                    <th scope="row">Date end</th>
                    <td>${order.endDate}</td>
                </tr>
                <tr>
                    <th scope="row">Sum</th>
                    <td>${order.sum}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col align-self-start">

            <form method="post" action="${pageContext.request.contextPath}/orders/order/${order.id}/update" class="row g-3">

                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"><h2>Edit order:</h2></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">Select order status</th>
                        <td>
                            <div class="col-md-8">
                                <select id="inputStatus" class="form-select" name="orderStatus" autocomplete="off">
                                    <option value="" selected></option>
                                    <c:forEach items="${statusList}" var="status">
                                        <option value="${status}">${status}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <button type="submit" class="btn btn-secondary">Apply</button>

            </form>
        </div>
    </div>
</div>


<jsp:include page="_footer.jsp"/>


