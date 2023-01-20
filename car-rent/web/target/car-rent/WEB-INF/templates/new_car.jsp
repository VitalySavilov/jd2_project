<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">
        <form method="post" action="${pageContext.request.contextPath}/cars/car" enctype="multipart/form-data"
              class="row g-3">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col"><h2>New car:</h2></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Mark</th>
                    <td>
                        <div class="col-md-4">
                            <input class="form-control"
                                   list="Marks" id="inputMark"
                                   placeholder="Select mark" name="carMark" autocomplete="off"
                                   onchange="self.location='${url}?actualMark='+this.value"
                                   value="${actualMark}">
                            <datalist id="Marks">
                                <c:forEach items="${marks}" var="mark">
                                <option value="${mark}">
                                    </c:forEach>
                            </datalist>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Model</th>
                    <td>
                        <div class="col-md-4">
                            <input class="form-control"
                                   list="Models" id="inputModel"
                                   placeholder="Select model" name="carModel" autocomplete="off">
                            <datalist id="Models">
                                <c:forEach items="${models}" var="model">
                                <option value="${model}">
                                    </c:forEach>
                            </datalist>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Type</th>
                    <td>
                        <div class="col-md-4">
                            <input class="form-control"
                                   list="Types" id="inputType"
                                   placeholder="Select type" name="type" autocomplete="off">
                            <datalist id="Types">
                                <c:forEach items="${types}" var="type">
                                <option value="${type}">
                                    </c:forEach>
                            </datalist>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Color</th>
                    <td>
                        <div class="col-md-4">
                            <input type="text" name="color" placeholder="Enter color" class="form-control" id="color"
                                   aria-describedby="nameHelp">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Registration number</th>
                    <td>
                        <div class="col-md-4">
                            <input type="text" name="regNumber" placeholder="Enter reg number" class="form-control" id="regNum"
                                   aria-describedby="nameHelp">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Power</th>
                    <td>
                        <div class="col-md-4">
                            <input step="1" value="120" type="number" name="power" id="Power" class="form-control">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Year of manufacture</th>
                    <td>
                        <div class="col-md-4">
                            <input step="1" value="2020" type="number" name="year" class="form-control" id="year"
                                   aria-describedby="nameHelp">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Fuel</th>
                    <td>
                        <div class="col-md-4">
                            <select id="inputFuel" class="form-select" name="fuelType" autocomplete="off" value="">
                                <c:forEach items="${fuelTypes}" var="fuel">
                                    <option value="${fuel}">${fuel}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Fuel consumption</th>
                    <td>
                        <div class="col-md-4">
                            <input step="0.1" value="5.2" type="number" name="fuelConsumption" id="fuel consumption"
                                   class="form-control"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Price</th>
                    <td>
                        <div class="col-md-4">
                            <input step="0.1" value="25" type="number" name="price" id="price" class="form-control">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Car Images</th>
                    <td>
                        <div class="col-md-6">
                            <input type="file" name="files" class="form-control" id="img" multiple>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>

            <button type="submit" class="btn btn-secondary">Add car</button>

        </form>

</div>
<jsp:include page="_footer.jsp"/>


