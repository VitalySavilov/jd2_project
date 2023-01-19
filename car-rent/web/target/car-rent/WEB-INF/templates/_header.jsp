<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Web shop demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/cars">Cars</a>
                </li>
                <security:authorize access="hasRole('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/users">Users</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/orders">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/payments">Payments</a>
                    </li>
                </security:authorize>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/users/user">Registration</a>
                </li>
                <li class="nav-item">
                    <security:authorize access="isAuthenticated()">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                    </security:authorize>
                    <security:authorize access="!isAuthenticated()">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                    </security:authorize>
                </li>
            </ul>
            <security:authorize access="isAuthenticated()">

                <a class="nav-link" href="${pageContext.request.contextPath}/users/profile"><security:authentication
                        property="name"/></a>

            </security:authorize>
        </div>
    </div>
</nav>


