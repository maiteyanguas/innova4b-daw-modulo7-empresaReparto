<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="coche.devuelto" text="HAS DEVUELTO EL COCHE"/></title>
</head>
<body>
	<p><spring:message code="coche.devuelto" text="HAS DEVUELTO EL COCHE"/></p>
	<a href="/empresaReparto/coche/listDisponibles"><spring:message code="volver" text="Volver"/></a>
</body>
</html>