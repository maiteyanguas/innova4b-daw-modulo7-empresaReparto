<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><spring:message code="coche.sinReserva" text="NO SE PUEDE DEVOLVER UN COCHE SIN RESERVA PREVIA"/>
	<a href="/empresaReparto/coche/listDisponibles"><spring:message code="volver" text="Volver"/></a>
</body>
</html>