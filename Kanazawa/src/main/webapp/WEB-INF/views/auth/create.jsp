<div class="row">
     <div class="col-sm-push-2 col-sm-10"><h1><spring:message code="web.label.common.create"/></h1></div>
</div>

<div class="row">
    <div class="col-xs-12">
        <form:form modelAttribute="authForm" action="create" class="form-horizontal cst-form-inputform">
            <!-- 
            <spring:hasBindErrors name="authForm">
                <div class="alert alert-danger">
                    <spring:bind path="authForm">
                      <c:forEach items="${errors.fieldErrors}" var="error">
                        <p><spring:message message="${error}" /></p>
                      </c:forEach>
                    </spring:bind>
                </div>
            </spring:hasBindErrors>
            -->
                            
            <label for="code" class="control-label col-sm-2"><spring:message code="web.label.auth.login.loginId"/></label>
            <div class="col-sm-10">
                <div class="row">
                    <div class="col-sm-2">
                        <input type="text" name="loginId" class="form-control input-sm" />
                        <p class="help-block"><font color="red"><form:errors path="loginId" /></font></p>
                    </div>
                </div>
            </div>
            <label for="code" class="control-label col-sm-2"><spring:message code="web.label.auth.login.pass"/></label>
            <div class="col-sm-10">
                <div class="row">
                    <div class="col-sm-2">
                        <input type="text" name="pass" class="form-control input-sm" />
                        <p class="help-block"><font color="red"><form:errors path="pass" /></font></p>
                    </div>
                </div>
            </div>
            <input type="submit" value="<spring:message code="web.label.common.confirm" />"  name="confirm" value="Confirm"  class="btn btn-primary">
        </form:form>
    </div>
</div>

