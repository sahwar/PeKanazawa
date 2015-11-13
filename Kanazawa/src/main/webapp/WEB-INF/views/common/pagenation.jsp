<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="firstUrl" value="/${pages.path}?page=1" />
<c:url var="lastUrl" value="/${pages.path}?page=${pages.pages.totalPages}" />
<c:url var="prevUrl" value="/${pages.path}?page=${pages.current - 1}" />
<c:url var="nextUrl" value="/${pages.path}?page=${pages.current + 1}" />

<div class="pagination">
    <ul>
<!--         
        <c:choose>
            <c:when test="${current == 1}">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
 -->
         <c:forEach var="i" begin="${pages.begin}" end="${pages.end}">
            <c:url var="pageUrl" value="/${pages.path}?page=${i}" />
            <c:choose>
                <c:when test="${i == pages.current}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
<!--         
        <c:choose>
            <c:when test="${current == pages.pages.totalPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
 -->
     </ul>
</div>