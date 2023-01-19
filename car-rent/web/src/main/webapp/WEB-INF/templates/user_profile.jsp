<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">

    <div class="row">

        <form method="post" action="${pageContext.request.contextPath}/users/profile/update" class="row g-3">

            <div class="col align-self-start">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"><h2>Your profile:</h2></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">User</th>
                        <td>${user.username}</td>
                    </tr>
                    <tr>
                        <th scope="row">Firstname</th>
                        <td>
                            <div class="col-md-8">
                                <input type="text" name="firstname" value="${user.appUserInfo.firstname}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Lastname</th>
                        <td>
                            <div class="col-md-8">
                                <input type="text" name="lastname" value="${user.appUserInfo.lastname}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Birthdate</th>
                        <td>
                            <div class="col-md-8">
                                <input type="date" name="birthDate" value="${user.appUserInfo.birthDate}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Email</th>
                        <td>
                            <div class="col-md-8">
                                <input type="text" name="email" value="${user.appUserInfo.email}" class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Telephone</th>
                        <td>
                            <div class="col-md-8">
                                <input type="text" name="telNumber" value="${user.appUserInfo.telNumber}"
                                       class="form-control">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Payment cards</th>
                        <td>
                            <c:forEach items="${cards}" var="card">
                                <c:out value="${card.cardNumber} "/>
                            </c:forEach>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="col align-self-start">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"><h2>Payment cards:</h2></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">Delete card</th>
                        <td>
                            <div class="col-md-10">
                                <select class="form-select" name="delCardId" autocomplete="off">
                                    <option selected></option>
                                    <c:forEach items="${cards}" var="card">
                                        <option value="${card.id}">${card.cardNumber}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Add card</th>
                        <td>
                            <div class="col-md-10">
                                <input type="text" name="addCard" placeholder="Enter card number" class="form-control"
                                       aria-describedby="nameHelp" value="">
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <button type="submit" class="btn btn-secondary">Apply</button>

            </div>

        </form>

    </div>

</div>

<jsp:include page="_footer.jsp"/>


