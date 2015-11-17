<%@ page session="false"%>
<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
	<head>
	        <meta charset="utf-8">
	        <title><spring:message code="web.label.title" /></title>
	        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />" type="text/css" media="screen" />
	</head>
	<body>
		    <div class="inputAreaErro">
		        <c:out value="${error}" />
		    </div>
	        <div class="container" style="padding:20px 0">
	                <form:form modelAttribute="authForm" action="${pageContext.request.contextPath}/login/login" class="form-horizontal" style="margin-bottom:15px">
	                        <div class="form-group">
	                                <label class="col-sm-2 control-label" for="email"><spring:message code="web.label.auth.login.loginId" /></label>
	                                <div class="col-sm-4">
	                                        <form:input path="loginId" class="form-control"/>
	                                </div>
	                        </div>
	                        <div class="form-group">
	                                <label class="col-sm-2 control-label" for="password"><spring:message code="web.label.auth.login.pass" /></label>
	                                <div class="col-sm-4">
	                                        <form:input path="pass" type="password"  class="form-control" />
	                                </div>
	                        </div>
	                        <div class="form-group">
	                                <div class="col-sm-offset-2 col-sm-4">
		                                <input type="submit" value="<spring:message code="web.label.login" />" class="btn btn-primary">
	                                </div>
	                        </div>
	                </form:form>
	        </div>
	</body>
</html>