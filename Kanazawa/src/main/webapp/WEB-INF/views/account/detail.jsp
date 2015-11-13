<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>All Accounts</title>
</head>
<body>
    <h1>All Accounts</h1>
    <c:forEach var="account" items="${accounts}">
        <ul>
            <li>ID : <c:out value="${account.id}" /></li>
            <li>Name : <c:out value="${account.name}" /></li>
            <li>Ruby : <c:out value="${account.ruby}" /></li>
            <li>Mail : <c:out value="${account.mail}" /></li>
            <li>Sex : <c:out value="${account.sex}" /></li>
            <li>Age : <c:out value="${account.age}" /></li>
            <li>Prefecture : <c:out value="${account.prefecture}" /></li>
            <li>Phone : <c:out value="${account.phone}" /></li>
        </ul>
    </c:forEach>
</body>
</html>