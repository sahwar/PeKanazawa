<div class="page-header">
        <h1><spring:message code="web.label.function.auth.list"/></h1>
        <div class="row">
             <div class="col-md-6">
                <table class="table">
                    <thead>
                        <tr>
                            <th><spring:message code="web.label.auth.id"/></th>
                            <th><spring:message code="web.label.auth.loginId"/></th>
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach var="auth" items="${pages.pages.content}">
                            <tr>
                               <c:set var="authId" value="${auth.id}" />
                               <td><a href="detail/${authId}"><c:out value="${authId}" /></a>
                               <td><c:out value="${auth.loginId}" />
                           </tr>
                       </c:forEach>
                    </tbody>
                </table>
             </div>
        </div>
</div>
<!-- pagenation -->
<jsp:include page="../common/pagenation.jsp" />

<input class="btn btn-default" type="button" value="<spring:message code="web.label.create"/>" onclick="location.href='${pageContext.request.contextPath}/auth/create?form'">