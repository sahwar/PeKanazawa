<div class="row">
     <div class="col-sm-push-2 col-sm-10"><h1><spring:message code="web.label.common.confirm"/></h1></div>
</div>
<form:form modelAttribute="authForm" action="update" class="form-horizontal">
    <div class="form-group">
         <input type="hidden" name="id" value="<c:out value='${auth.id}'/>" />
        <label class="col-sm-2 control-label"><spring:message code="web.label.auth.login.loginId"/></label>
        <div class="col-sm-10">
            <p class="form-control-static"><c:out value="${auth.loginId}" /></p>
            <input type="hidden" name="loginId" value="<c:out value='${auth.loginId}'/>" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label"><spring:message code="web.label.auth.login.pass"/></label>
        <div class="col-sm-10">
            <p class="form-control-static"><c:out value="${auth.pass}" /></p>
            <input type="hidden" name="pass" value="<c:out value='${auth.pass}'/>" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default" name="update" value="Update"><spring:message code="web.label.common.update" /></button>
            <p class="help-block">...</p>
        </div>
    </div>
</form:form>