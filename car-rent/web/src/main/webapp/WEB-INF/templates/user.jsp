<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col align-self-start">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col"><h2>User:</h2></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">User id</th>
                    <td>${user.id}</td>
                </tr>
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
                    <th scope="row">Roles</th>
                    <td>
                        <c:forEach items="${user.roles}" var="role">
                            <c:out value="${role.name} "/>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Payment Cards</th>
                    <td>
                        <c:forEach items="${paymentCards}" var="paymentCard">
                            <c:out value="${paymentCard.cardNumber} "/>
                        </c:forEach>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col align-self-start">
            <form method="post" action="${pageContext.request.contextPath}/users/${user.id}/update" class="row g-3">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"><h2>Edit user:</h2></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">Add role</th>
                        <td>
                            <div class="col-md-6">
                                <select id="addRole" class="form-select" name="addRole" autocomplete="off">
                                    <option selected></option>
                                    <c:forEach items="${roles}" var="role">
                                        <option value="${role.name}">${role.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Delete role</th>
                        <td>
                            <div class="col-md-6">
                                <select id="deleteRole" class="form-select" name="delRole" autocomplete="off">
                                    <option selected></option>
                                    <c:forEach items="${user.roles}" var="role">
                                        <option value="${role.name}">${role.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <button type="submit" class="btn btn-secondary">Apply</button>
            </form>
            <div class="row">
                <form method="post" action="${pageContext.request.contextPath}/users/${user.id}/delete" class="row g-3">
                    <button type="submit" class="btn btn-secondary">Delete user</button>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="_footer.jsp"/>


