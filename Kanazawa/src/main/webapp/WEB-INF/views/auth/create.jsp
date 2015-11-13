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
                <li><spring:message code="web.label.auth.loginId"/>:<c:out value="${auth.loginId}" /></li>
                <li><spring:message code="web.label.auth.pass"/>:<c:out value="${auth.pass}" /></li>
                <form:hidden path="loginId" />
                <form:hidden path="pass" />
            </form:form>
        </ul>
        <input type="submit" name="confirm" value="Confirm" />
    </div>
</body>
</html>