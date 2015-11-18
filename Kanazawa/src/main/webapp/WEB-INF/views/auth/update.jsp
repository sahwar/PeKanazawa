<div class="row">
     <div class="col-sm-push-2 col-sm-10"><h1><spring:message code="web.label.common.update"/></h1></div>
</div>

<div class="row">
    <div class="col-xs-12">
        <form:form modelAttribute="authForm" action="${pageContext.request.contextPath}/auth/update?confirm" class="form-horizontal cst-form-inputform">
            <input type="hidden" name="id" value="<c:out value='${auth.id}'/>" />
            <spring:hasBindErrors name="authForm">
                <div class="alert alert-danger">
                    <spring:bind path="authForm">
                      <c:forEach items="${errors.fieldErrors}" var="error">
                        <p><spring:message message="${error}" /></p>
                      </c:forEach>
                    </spring:bind>
                </div>
            </spring:hasBindErrors>
                            
            <label for="code" class="control-label col-sm-2"><spring:message code="web.label.auth.login.loginId"/></label>
            <div class="col-sm-10">
                <div class="row">
                    <div class="col-sm-2">
                        <p class="form-control-static"><c:out value="${auth.loginId}" /></p>
                        <input type="hidden" name="loginId" value="<c:out value='${auth.loginId}'/>" />
                    </div>
                </div>
            </div>
            <label for="code" class="control-label col-sm-2"><spring:message code="web.label.auth.login.pass"/></label>
            <div class="col-sm-10">
                <div class="row">
                    <div class="col-sm-2">
                        <input type="text" name="pass" class="form-control input-sm" value="${auth.pass}" />
                    </div>
                </div>
            </div>
            <input type="submit" value="<spring:message code="web.label.common.update" />"   class="btn btn-primary">
        </form:form>
    </div>
</div>

