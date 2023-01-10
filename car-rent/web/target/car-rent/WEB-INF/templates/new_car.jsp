<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<form method="post" action="${pageContext.request.contextPath}/new-car" enctype="multipart/form-data" class="row g-3">
    <!-- Mark -->
    <div class="col-md-4">
        <label for="inputMark" class="form-label">Mark</label>
        <input class="form-control"
               list="Marks" id="inputMark"
               placeholder="Select option" name="carMark" autocomplete="off"
               onchange="self.location='${url}?actualMark='+this.value"
               value="${data.actualMark}">
        <datalist id="Marks">
            <c:forEach items="${data.marks}" var="mark">
            <option value="${mark}">
                </c:forEach>
        </datalist>
    </div>
    <!-- Model -->
    <div class="col-md-4">
        <label for="inputModel" class="form-label">Model</label>
        <input class="form-control"
               list="Models" id="inputModel"
               placeholder="Select option" name="carModel" autocomplete="off">
        <datalist id="Models">
            <c:forEach items="${data.models}" var="model">
            <option value="${model}">
                </c:forEach>
        </datalist>
    </div>
    <!-- Type -->
    <div class="col-md-4">
        <label for="inputType" class="form-label">Type</label>
        <input class="form-control"
               list="Types" id="inputType"
               placeholder="Select option" name="type" autocomplete="off">
        <datalist id="Types">
            <c:forEach items="${data.types}" var="type">
            <option value="${type}">
                </c:forEach>
        </datalist>
    </div>
    <!-- Color -->
    <div class="col-md-4">
        <label for="color" class="form-label">Color</label>
        <input type="text" name="color" class="form-control" id="color"
               aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter color</div>
    </div>
    <%--Power--%>
    <div class="col-md-4">
        <label for="Power" class="form-label">Power</label>
        <input step="1" value="120" type="number" name="power" id="Power" class="form-control">
    </div>
    <%--Year of manufacture--%>
    <div class="col-md-4">
        <label for="year" class="form-label">Year of manufacture</label>
        <input step="1" value="2020" type="number" name="year" class="form-control" id="year"
               aria-describedby="nameHelp">
    </div>
    <%--Fuel--%>
    <div class="col-md-4">
        <label for="inputFuel" class="form-label">Fuel</label>
        <select id="inputFuel" class="form-select" name="fuelType" autocomplete="off" value="">
            <c:forEach items="${data.fuelTypes}" var="fuel">
                <option value="${fuel}">${fuel}</option>
            </c:forEach>
        </select>
    </div>
    <%--Fuel consumption--%>
    <div class="col-md-4">
        <label class="form-label" for="fuel consumption">Fuel consumption</label>
        <input step="0.1" value="5.2" type="number" name="fuelConsumption" id="fuel consumption" class="form-control"/>
    </div>
    <%--Price--%>
    <div class="col-md-4">
        <label for="price" class="form-label">Price</label>
        <input step="0.1" value="25" type="number" name="price" id="price" class="form-control">
    </div>
    <!-- Images -->
    <div class="col-md-4">
        <label for="img" class="form-label">Car Images</label>
        <input type="file" name="files" class="form-control" id="img" multiple>
    </div>

    <button type="submit" class="btn btn-primary">Add car</button>
</form>

<jsp:include page="_footer.jsp"/>


