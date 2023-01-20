<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">
    <form method="post" action="${url}" class="row g-3">
        <table class="table">
            <thead>
            <tr>
                <th scope="col"><h2>Login:</h2></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${param.error != null}">
                <tr>
                    <th scope="row"></th>
                    <td>
                        <div class="col-md-6" style="color: red">
                            Bad credentials
                        </div>
                    </td>
                </tr>
            </c:if>
            <tr>
                <th scope="row">Username</th>
                <td>
                    <div class="col-md-6">
                        <input type="text" name="username" autocomplete="off" placeholder="Enter username" class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <th scope="row">Password</th>
                <td>
                    <div class="col-md-6">
                        <input type="text" name="password" autocomplete="off" placeholder="Enter password" class="form-control">
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
            <button type="submit" class="btn btn-secondary">Login</button>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/users/user" role="button">Registration</a>
    </form>
</div>

<jsp:include page="_footer.jsp"/>


