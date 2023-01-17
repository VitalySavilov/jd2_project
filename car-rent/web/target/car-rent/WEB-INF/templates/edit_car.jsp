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
                    <c:if test="${fn:length(car.imageIdList) > 0}">
                        <div class="carousel-item active">
                            <img src="image/${car.imageIdList[0]}" class="d-block w-100" alt="...">
                        </div>
                        <c:forEach begin="${fn:length(car.imageIdList) - (fn:length(car.imageIdList) - 1)}"
                                   end="${fn:length(car.imageIdList) - 1}" var="i">
                            <div class="carousel-item">
                                <img src="image/${car.imageIdList[i]}" class="d-block w-100" alt="...">
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
                    <th scope="row">Status</th>
                    <td>${car.status}</td>
                </tr>
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
        </div>
    </div>
</div>

<div class="container">
    <div class="col align-self-start">

        <form method="post" action="${url}" class="row g-3">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col"><h2>Edit car:</h2></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Select status</th>
                    <td>
                        <div class="col-md-8">
                            <label>
                                <select class="form-select" name="status" autocomplete="off">
                                    <option selected></option>
                                    <c:forEach items="${statusList}" var="status">
                                        <option value="${status}">${status}</option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Price</th>
                    <td>
                        <div class="col-md-4">
                            <input step="1" value="${car.price}" type="number" name="price" id="price" class="form-control">
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>

            <button type="submit" class="btn btn-secondary">Apply</button>

        </form>
    </div>
</div>

<jsp:include page="_footer.jsp"/>


