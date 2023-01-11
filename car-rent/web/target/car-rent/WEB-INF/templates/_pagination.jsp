<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
    <div class="btn-group me-2" role="group" aria-label="First group">
        <%--previous--%>
        <button type="submit" name="page" value="${data.metadata.page > 0 ? data.metadata.page - 1 : 0}"
                class="btn btn-light">&laquo;
        </button>
    </div>
    <div class="btn-group me-2" role="group" aria-label="Second group">
        <%-- left pages --%>
        <c:choose>
            <c:when test="${data.metadata.page < 3}">
                <c:if test="${data.metadata.page > 0}">
                    <c:forEach begin="0" end="${data.metadata.page - 1}" var="p">
                        <button type="submit" name="page" value="${p}" class="btn btn-light">${p + 1}</button>
                    </c:forEach>
                </c:if>
            </c:when>
            <c:otherwise>
                <button type="submit" name="page" value="0" class="btn btn-light">1</button>
                <button type="button" aria-disabled="true" class="btn btn-light">...</button>
                <button type="submit" name="page" value="${data.metadata.page - 1}"
                        class="btn btn-light">${data.metadata.page}</button>
            </c:otherwise>
        </c:choose>
        <%-- current page --%>
        <button type="submit" name="page" value="${data.metadata.page}"
                class="btn btn-light active">${data.metadata.page + 1}</button>
        <%-- right pages --%>
        <c:choose>
            <c:when test="${data.metadata.page + 3 >= data.metadata.totalPages}">
                <c:forEach begin="${data.metadata.page + 2}" end="${data.metadata.totalPages}" var="p">
                    <button type="submit" name="page" value="${p - 1}" class="btn btn-light">${p}</button>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <button type="submit" name="page" value="${data.metadata.page + 1}"
                        class="btn btn-light">${data.metadata.page + 2}</button>
                <button type="button" aria-disabled="true" class="btn btn-light">...</button>
                <button type="submit" name="page" value="${data.metadata.totalPages - 1}"
                        class="btn btn-light">${data.metadata.totalPages}</button>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="btn-group me-2" role="group" aria-label="Third group">
        <%--next--%>
        <button type="submit" name="page"
                value="${data.metadata.page + 1 < data.metadata.totalPages ? data.metadata.page + 1 : data.metadata.totalPages - 1}"
                class="btn btn-light">&raquo;
        </button>
    </div>
        <%--size--%>
    <div class="input-group">
        <div class="input-group-text" id="btnGroupAddon2">Page size:</div>
        <select class="form-select" name="size" id="validationCustom04" onchange="this.form.submit()">
            <option value="${data.metadata.size}" selected>${data.metadata.size}</option>
            <option value="1">1</option>
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="20">20</option>
        </select>
    </div>
</div>
