<!DOCTYPE html>
<html>
<head>
<title>金沢Webログイン</title>
<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
</head>
<body>
    <form:form modelAttribute="authForm" action="login">
        <div id="inputAreaErro">
            <c:out value="${error}"/>
        </div>
        <div id="inputArea">
            <ul>
                <li><spring:message code="web.label.auto.login.loginId"/>：<form:input path="loginId" /></li>
                <li><spring:message code="web.label.auto.login.pass"/>:<form:input path="pass" /></li>
            </ul>
		    <input type="submit" />
        </div>
  </form:form>
</body>
</html>