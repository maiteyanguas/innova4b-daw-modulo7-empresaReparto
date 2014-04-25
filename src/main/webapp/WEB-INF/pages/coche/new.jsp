<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="nuevo.coche" text="Nuevo coche"/></title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="content">
			<p><spring:message code="nuevo.coche" text="Nuevo coche"/></p>
			
			<form:form method="post" modelAttribute="coche" action="/empresaReparto/coche/add">
			<table>
				<tr>
					<td><form:label path="empresa"><spring:message code="coche.empresa" text="Empresa"/>:</form:label></td>
					<td>
					<select name="idEmpresa">
						<c:forEach items="${empresas}" var="empresa">
							
								<option value="${empresa.id}">${empresa.nombre}"</option>
										
						</c:forEach>
					</select>
										
						<form:input path="empresa"></form:input>
						<form:errors path="empresa" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="kilometros"><spring:message code="coche.kms" text="Kilometros"/>:</form:label></td>
					<td><form:input path="kilometros"></form:input>
						<form:errors path="kilometros" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="combustible"><spring:message code="coche.combustible" text="Combustible"/>:</form:label></td>
					<td>
					<select name="tipoCombustible">
					  <option value="gasolina"><spring:message code="combustible.gasolina" text="Gasolina"/></option>
					  <option value="Diesel"><spring:message code="combustible.diesel" text="Diesel"/></option>
					</select> 
					</td>
				</tr>
				<tr>
					<td><form:label path="marca"><spring:message code="coche.marca" text="Marca"/>:</form:label></td>
					<td><form:input path="marca"></form:input>
						<form:errors path="marca" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="modelo"><spring:message code="coche.modelo" text="Modelo"/>:</form:label></td>
					<td><form:input path="modelo"></form:input>
						<form:errors path="modelo" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="matricula"><spring:message code="coche.matricula" text="Matricula"/>:</form:label></td>
					<td><form:input path="matricula"></form:input>
						<form:errors path="matricula" cssClass="error"/>
					</td>
				</tr>
			</table>
			<p>
				<spring:message code="guardar" text="Guardar" var="guardar"/>
				<input type="submit" value="${guardar}"/>
				<a class="button" href="/empresaReparto/coche/listAll"><spring:message code="volver" text="Volver"/></a>	
			</p>
			</form:form>
		</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>