<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/login.css">
<title><spring:message code="identificacion" text="Identificación"/></title>
</head>

<body>
	<c:if test="${error!=null}">
		<div class="errorblock">${error}</div>
	</c:if>

	<div class="login">
		<h1><spring:message code="identificacion" text="Identificación"/></h1>
		<form:form modelAttribute="usuario" method="POST" action="/empresaReparto/login/add">
			<p>
				<spring:message code="usuario" text="Usuario" var="usuario"/>
				<form:input placeholder="${usuario}" path="usuario" />
				<form:errors path="usuario" cssClass="error" />
			</p>
			<p>
				<spring:message code="password" text="Contraseña" var="password"/>
				<form:password placeholder="${password}" path="password" />
				<form:errors path="password" cssClass="error" />
			</p>
			<p class="submit">
				<spring:message code="entrar" text="Entrar" var="entrar"/>
				<input type="submit" value="${entrar}" />
			</p>
		</form:form>
	</div>
</body>
</html>