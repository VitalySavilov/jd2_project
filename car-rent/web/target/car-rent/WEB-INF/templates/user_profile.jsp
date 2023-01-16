<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row">
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
                    <td>${user.appUserInfo.firstname}</td>
                </tr>
                <tr>
                    <th scope="row">Lastname</th>
                    <td>${user.appUserInfo.lastname}</td>
                </tr>
                <tr>
                    <th scope="row">Birthdate</th>
                    <td>${user.appUserInfo.birthDate}</td>
                </tr>
                <tr>
                    <th scope="row">Email</th>
                    <td>${user.appUserInfo.email}</td>
                </tr>
                <tr>
                    <th scope="row">Tel</th>
                    <td>${user.appUserInfo.telNumber}</td>
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

            <form method="post" action="${url}" class="row g-3">

                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"><h2>Edit profile:</h2></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">Delete card</th>
                        <td>
                            <div class="col-md-8">
                                <select id="addRole" class="form-select" name="delCard" autocomplete="off">
                                    <option selected></option>
                                    <c:forEach items="${cards}" var="card">
                                        <option value="${card.cardNumber}">${card.cardNumber}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Add card</th>
                        <td>
                            <div class="col-md-8">
                                <input type="text" name="addCard" placeholder="Enter card number" class="form-control"
                                       aria-describedby="nameHelp" value="">
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


