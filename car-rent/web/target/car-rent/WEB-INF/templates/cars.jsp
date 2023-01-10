<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>

<h1>Cars</h1>

<jsp:include page="_pagination.jsp"/>

<%--<nav aria-label="Page navigation example">--%>
<%--    <ul class="pagination">--%>
<%--        &lt;%&ndash;previous&ndash;%&gt;--%>
<%--        <li class="page-item">--%>
<%--            <a class="page-link"--%>
<%--               href="${url}?page=${cars.metadata.page > 0 ? cars.metadata.page - 1 : 0}&size=${cars.metadata.size}">--%>
<%--                &laquo;--%>
<%--            </a>--%>
<%--        </li>--%>
<%--        &lt;%&ndash; left pages &ndash;%&gt;--%>
<%--        <c:choose>--%>
<%--            <c:when test="${cars.metadata.page < 3}">--%>
<%--                <c:if test="${cars.metadata.page > 0}">--%>
<%--                    <c:forEach begin="0" end="${cars.metadata.page - 1}" var="p">--%>
<%--                        <li class="page-item"><a class="page-link"--%>
<%--                                                 href="${url}?page=${p}&size=${cars.metadata.size}">${p + 1}</a></li>--%>
<%--                    </c:forEach>--%>
<%--                </c:if>--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                <c:forEach begin="0" end="0" var="p">--%>
<%--                    <li class="page-item"><a class="page-link"--%>
<%--                                             href="${url}?page=${p}&size=${cars.metadata.size}">${p + 1}</a></li>--%>
<%--                </c:forEach>--%>
<%--                <li class="page-item disabled"><a class="page-link" href="#" aria-disabled="true">...</a></li>--%>
<%--                <c:forEach begin="${cars.metadata.page - 1}" end="${cars.metadata.page - 1}" var="p">--%>
<%--                    <li class="page-item"><a class="page-link"--%>
<%--                                             href="${url}?page=${p}&size=${cars.metadata.size}">${p + 1}</a></li>--%>
<%--                </c:forEach>--%>
<%--            </c:otherwise>--%>
<%--        </c:choose>--%>
<%--        &lt;%&ndash; current page &ndash;%&gt;--%>
<%--        <li class="page-item active" aria-current="page">--%>
<%--            <a class="page-link"--%>
<%--               href="${url}?page=${cars.metadata.page}&size=${cars.metadata.size}">--%>
<%--                ${cars.metadata.page + 1}--%>
<%--            </a>--%>
<%--        </li>--%>
<%--        &lt;%&ndash; right pages &ndash;%&gt;--%>
<%--        <c:choose>--%>
<%--            <c:when test="${cars.metadata.page + 2 >= cars.metadata.totalPages}">--%>
<%--                <c:forEach begin="${cars.metadata.page + 2}" end="${cars.metadata.totalPages}" var="p">--%>
<%--                    <li class="page-item"><a class="page-link"--%>
<%--                                             href="${url}?page=${p - 1}&size=${cars.metadata.size}">${p}</a></li>--%>
<%--                </c:forEach>--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                <c:forEach begin="${cars.metadata.page + 1}" end="${cars.metadata.page + 1}" var="p">--%>
<%--                    <li class="page-item"><a class="page-link"--%>
<%--                                             href="${url}?page=${p}&size=${cars.metadata.size}">${p + 1}</a></li>--%>
<%--                </c:forEach>--%>
<%--                <li class="page-item disabled"><a class="page-link" href="#" aria-disabled="true">...</a></li>--%>
<%--                <c:forEach begin="${cars.metadata.totalPages}" end="${cars.metadata.totalPages}" var="p">--%>
<%--                    <li class="page-item"><a class="page-link"--%>
<%--                                             href="${url}?page=${p - 1}&size=${cars.metadata.size}">${p}</a></li>--%>
<%--                </c:forEach>--%>
<%--            </c:otherwise>--%>
<%--        </c:choose>--%>
<%--        &lt;%&ndash;next&ndash;%&gt;--%>
<%--        <li class="page-item">--%>
<%--            <a class="page-link"--%>
<%--               href="${url}?page=${cars.metadata.page + 1 < cars.metadata.totalPages - 1 ? cars.metadata.page + 1 : cars.metadata.totalPages}&size=${cars.metadata.size}">--%>
<%--                &raquo;--%>
<%--            </a>--%>
<%--        </li>--%>
<%--        &lt;%&ndash;page size&ndash;%&gt;--%>
<%--        <li class="page-item">--%>
<%--            <div class="dropdown">--%>
<%--                <a class="btn btn-link" href="#" role="button" id="dropdownMenuLink"--%>
<%--                   data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                    Size: ${cars.metadata.size}--%>
<%--                </a>--%>
<%--                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">--%>
<%--                    <li><a class="dropdown-item" href="${url}?page=0&size=5">5</a></li>--%>
<%--                    <li><a class="dropdown-item" href="${url}?page=0&size=10">10</a></li>--%>
<%--                    <li><a class="dropdown-item" href="${url}?page=0&size=15">15</a></li>--%>
<%--                    <li><a class="dropdown-item" href="${url}?page=0&size=20">20</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</nav>--%>

<table style="width:100%" class="table">
    <tr>
        <th>Model</th>
        <th>Year</th>
        <th>Type</th>
        <th>Color</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${data.content}" var="car">
        <tr>
            <td><c:out value="${car.carMark} ${car.carModel}"/></td>
            <td><c:out value="${car.year}"/></td>
            <td><c:out value="${car.type}"/></td>
            <td><c:out value="${car.color}"/></td>
            <td><c:out value="${car.price}"/></td>
            <td><a class="btn btn-light" href="#" role="button">Details</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>



