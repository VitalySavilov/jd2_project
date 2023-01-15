<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="col align-self-center">
        <h1>Оформление заказа</h1>
    </div>

    <div class="row">
        <div class="col align-self-start">
            <h1>${car.carMark} ${car.carModel} ${car.year}</h1>
        </div>
        <div class="col align-self-start">

            <form action="${url}" method="post">

                <div class="col-md-4">
                    <label for="inputMark" class="form-label">Days</label>
                    <input type="number" class="form-control" name="days" value="1" id="inputMark">
                </div>

                <button type="submit" class="btn btn-light">Checkout</button>
            </form>

        </div>
    </div>
</div>

<jsp:include page="_footer.jsp"/>


