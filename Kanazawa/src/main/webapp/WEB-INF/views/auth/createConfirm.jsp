<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>TODO </title>
<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
    <div id ="error">
        <form:errors path="loinId" />
        <form:errors path="pass" />
    </div>
    <div id="create">
        <ul>
            <form:form modelAttribute="authForm" action="auth/create">
                <li><spring:message code="web.label.auth.loginId"/>:<c:out value="${loginId}" /></li>
                <li><spring:message code="web.label.auth.pass"/>:<c:out value="${pass}" /></li>
            </form:form>
        </ul>
        <input type="submit" name="<spring:message code="web.label.common.redo"/>" value="Back" />
        <input type="submit" name="<spring:message code="web.label.common.create"/>" value="Create" />
    </div>
</body>
</html>