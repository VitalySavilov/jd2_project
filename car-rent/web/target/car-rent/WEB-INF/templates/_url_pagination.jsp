<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <%--previous--%>
        <li class="page-item">
            <a class="page-link"
               href="${url}?page=${data.metadata.page > 0 ? data.metadata.page - 1 : 0}&size=${data.metadata.size}">
                &laquo;
            </a>
        </li>
        <%-- left pages --%>
        <c:choose>
            <c:when test="${data.metadata.page < 3}">
                <c:if test="${data.metadata.page > 0}">
                    <c:forEach begin="0" end="${data.metadata.page - 1}" var="p">
                        <li class="page-item"><a class="page-link"
                                                 href="${url}?page=${p}&size=${data.metadata.size}">${p + 1}</a></li>
                    </c:forEach>
                </c:if>
            </c:when>
            <c:otherwise>
                <c:forEach begin="0" end="0" var="p">
                    <li class="page-item"><a class="page-link"
                                             href="${url}?page=${p}&size=${data.metadata.size}">${p + 1}</a></li>
                </c:forEach>
                <li class="page-item disabled"><a class="page-link" href="#" aria-disabled="true">...</a></li>
                <c:forEach begin="${data.metadata.page - 1}" end="${data.metadata.page - 1}" var="p">
                    <li class="page-item"><a class="page-link"
                                             href="${url}?page=${p}&size=${data.metadata.size}">${p + 1}</a></li>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <%-- current page --%>
        <li class="page-item active" aria-current="page">
            <a class="page-link"
               href="${url}?page=${data.metadata.page}&size=${data.metadata.size}">
                ${data.metadata.page + 1}
            </a>
        </li>
        <%-- right pages --%>
        <c:choose>
            <c:when test="${data.metadata.page + 3 >= data.metadata.totalPages}">
                <c:forEach begin="${data.metadata.page + 2}" end="${data.metadata.totalPages}" var="p">
                    <li class="page-item"><a class="page-link"
                                             href="${url}?page=${p - 1}&size=${data.metadata.size}">${p}</a></li>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach begin="${data.metadata.page + 1}" end="${data.metadata.page + 1}" var="p">
                    <li class="page-item"><a class="page-link"
                                             href="${url}?page=${p}&size=${data.metadata.size}">${p + 1}</a></li>
                </c:forEach>
                <li class="page-item disabled"><a class="page-link" href="#" aria-disabled="true">...</a></li>
                <c:forEach begin="${data.metadata.totalPages}" end="${data.metadata.totalPages}" var="p">
                    <li class="page-item"><a class="page-link"
                                             href="${url}?page=${p - 1}&size=${data.metadata.size}">${p}</a></li>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <%--next--%>
        <li class="page-item">
            <a class="page-link"
               href="${url}?page=${data.metadata.page + 1 < data.metadata.totalPages ? data.metadata.page + 1 : data.metadata.totalPages - 1}&size=${data.metadata.size}">
                &raquo;
            </a>
        </li>
        <%--page size--%>
        <li class="page-item">
            <div class="dropdown">
                <a class="btn btn-link" href="#" role="button" id="dropdownMenuLink"
                   data-bs-toggle="dropdown" aria-expanded="false">
                    Size: ${data.metadata.size}
                </a>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <li><a class="dropdown-item" href="${url}?page=0&size=5">5</a></li>
                    <li><a class="dropdown-item" href="${url}?page=0&size=10">10</a></li>
                    <li><a class="dropdown-item" href="${url}?page=0&size=15">15</a></li>
                    <li><a class="dropdown-item" href="${url}?page=0&size=20">20</a></li>
                </ul>
            </div>
        </li>
    </ul>
</nav>
