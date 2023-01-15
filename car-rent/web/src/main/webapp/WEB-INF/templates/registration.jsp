<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="_header.jsp"/>

<form method="post" action="${pageContext.request.contextPath}/registration" class="row g-3">
    <%--    firstName--%>
    <div class="col-md-4">
        <label for="firstname" class="form-label">Firstname</label>
        <input type="text" name="firstname" class="form-control" id="firstname"
               aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter firstname</div>
    </div>
    <%--    lastName--%>
    <div class="col-md-4">
        <label for="lastname" class="form-label">Lastname</label>
        <input type="text" name="lastname" class="form-control" id="lastname"
               aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter lastName</div>
    </div>
    <%--    lastName--%>
    <div class="col-md-4">
        <label for="birthDate" class="form-label">Birth Date</label>
        <input type="date" name="birthDate" class="form-control" id="birthDate">
        <div id="nameHelp" class="form-text">Enter birthdate name</div>
    </div>
    <%--    email--%>
    <div class="col-md-4">
        <label for="email" class="form-label">email</label>
        <input type="text" name="email" class="form-control" id="email"
               aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter email</div>
    </div>
    <%--    telNumber--%>
    <div class="col-md-4">
        <label for="telNumber" class="form-label">telNumber</label>
        <input type="text" name="telNumber" class="form-control" id="telNumber"
               aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter telNumber</div>
    </div>
    <%--    username--%>
    <div class="col-md-4">
        <label for="username" class="form-label">username</label>
        <input type="text" name="username" class="form-control" id="username"
               aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter username</div>
    </div>
    <%--    password--%>
    <div class="col-md-4">
        <label for="password" class="form-label">password</label>
        <input type="text" name="password" class="form-control" id="password"
               aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter password</div>
    </div>
    <%--    card--%>
    <div class="col-md-4">
        <label for="card" class="form-label">payment card number</label>
        <input type="text" name="cardNumber" class="form-control" id="card"
               aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter payment card number</div>
    </div>

    <div class="col-12">
        <button class="btn btn-primary" type="submit">Submit form</button>
    </div>

</form>

<jsp:include page="_footer.jsp"/>


