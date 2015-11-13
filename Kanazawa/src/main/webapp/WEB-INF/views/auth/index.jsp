<form:form modelAttribute="authForm" action="login">
	<div class="inputAreaErro">
		<c:out value="${error}" />
	</div>
	<div class="inputArea">
		<ul>
			<li><spring:message code="web.label.auth.login.loginId" />：
			<form:input path="loginId" /></li>
			<li><spring:message code="web.label.auth.login.pass" />:
			<form:input path="pass" /></li>
		</ul>
		<input type="submit" />
	</div>
</form:form>
