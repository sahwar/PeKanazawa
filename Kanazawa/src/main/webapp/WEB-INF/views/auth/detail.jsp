<div class="page-header">
  <h1><spring:message code="web.label.function.auth.detail"/></h1>
</div>
<div class="row">
  <div class="col-sm-4">
    <div class="panel panel-primary">
      <div class="panel-heading">
        <h3 class="panel-title"><spring:message code="web.label.auth.id"/>:<c:out value="${auth.id}" /></h3>
      </div>
      <div class="panel-body">
        <ul>
            <li><spring:message code="web.label.auth.id"/>:<c:out value="${auth.id}" /></li>
            <li><spring:message code="web.label.auth.loginId"/>:<c:out value="${auth.loginId}" /></li>
        </ul>
      </div>
    </div>
  </div>
</div>

<form:form modelAttribute="authForm" action="${pageContext.request.contextPath}/auth/create?form">
	<input type="submit" class="btn btn-lg btn-primary" value="<spring:message code="web.label.common.create"/>" />
</form:form>
<button type="button" class="btn btn-lg btn-primary"><spring:message code="web.label.common.update"/></button>
<button type="button" class="btn btn-lg btn-primary"><spring:message code="web.label.common.delete"/></button>