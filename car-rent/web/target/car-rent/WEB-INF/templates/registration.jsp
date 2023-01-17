<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<div class="container">

    <form method="post" action="${url}" class="row g-3">

        <table class="table">
            <thead>
            <tr>
                <th scope="col"><h2>New user:</h2></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">Firstname</th>
                <td>
                    <div class="col-md-6">
                        <input type="text" name="firstname" placeholder="Enter firstname" class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <th scope="row">Lastname</th>
                <td>
                    <div class="col-md-6">
                        <input type="text" name="lastname" placeholder="Enter lastname" class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <th scope="row">Birthdate</th>
                <td>
                    <div class="col-md-6">
                        <input type="date" name="birthDate"  placeholder="Enter birthdate" class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <th scope="row">Email</th>
                <td>
                    <div class="col-md-6">
                        <input type="text" name="email" placeholder="Enter email" class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <th scope="row">Telephone</th>
                <td>
                    <div class="col-md-6">
                        <input type="text" name="telNumber" placeholder="Enter tel" class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <th scope="row">Username</th>
                <td>
                    <div class="col-md-6">
                        <input type="text" name="username" placeholder="Enter username" class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <th scope="row">Password</th>
                <td>
                    <div class="col-md-6">
                        <input type="text" name="password" placeholder="Enter password" class="form-control">
                    </div>
                </td>
            </tr>
            <tr>
                <th scope="row">Payment card</th>
                <td>
                    <div class="col-md-6">
                        <input type="text" name="cardNumber" placeholder="Enter card number" class="form-control">
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

        <button type="submit" class="btn btn-secondary">Register</button>

    </form>

</div>

<jsp:include page="_footer.jsp"/>


