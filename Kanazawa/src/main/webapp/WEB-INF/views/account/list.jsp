<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>All Accounts</title>
</head>
<body>
    <div id="list">
	    <c:forEach var="account" items="${accountList}">
	        <ul>
                <li><spring:message code="web.label.account.id"/><c:out value="${account.id}" />
                <li><spring:message code="web.label.account.name"/><c:out value="${account.name}" />
	        </ul>
	    </c:forEach>
    </div>
</body>
</html>