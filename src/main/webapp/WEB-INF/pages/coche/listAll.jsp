<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pages.css">
<title><spring:message code="lista.coches" text="Lista de coches"/></title>
	<script type="text/javascript">
		function mostrarOpciones(elemento) {
			if(elemento.value=="empresa") {
			    document.getElementById("idEmpresa").style.display = "inline";
			    document.getElementById("eleccionEmpresa").style.display = "inline";
				document.getElementById("matricula").style.display = "none";
			}else if (elemento.value=="matricula"){
				document.getElementById("idEmpresa").style.display = "none";
				document.getElementById("eleccionEmpresa").style.display = "none";	
				document.getElementById("matricula").style.display = "inline";
			} else {
				document.getElementById("idEmpresa").style.display = "none";
				document.getElementById("eleccionEmpresa").style.display = "none";			
				document.getElementById("matricula").style.display = "none";
			}
		}
	</script>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.jsp" />		
			<div id="content">
			<p><a class="link" href="/empresaReparto/coche/new"><spring:message code="nuevo.coche" text="Nuevo coche"/></a></p>
			<p>
				<form method="POST" action="/empresaReparto/coche/listByFilter" name="form">
					<table>
						<tr>
                			<td><spring:message code="filtro.filtrar" text="Filtrar por"/>:</td>
			            </tr>
			            <tr>
			                <td>
			                	<select id="eleccionCombo" name="eleccionCombo" onchange="mostrarOpciones(this)">
			                		<option value="verTodos"><spring:message code="filtro.verTodos" text="Ver Todos"/></option>
			                	    <option value="incidenciasPendientes"><spring:message code="filtro.incidencia" text="Incidencias Pendientes"/></option>
			                		<option value="empresa"><spring:message code="filtro.empresa" text="Empresa"/></option>
			                		<option value="matricula"><spring:message code="filtro.matricula" text="Matrícula"/></option>
			                	</select>

			                </td>
			                <td>
			                	<select id="idEmpresa" name="idEmpresa" style="display:none">
									<c:forEach items="${empresas}" var="emp">
											<option value="${emp.id}">${emp.nombre}</option>
									</c:forEach>
								</select>
								<select id="matricula" name="matricula" style="display:none">
									<c:forEach items="${listaMatriculasCoches}" var="coche">
											<option value="${coche.matricula}">${coche.matricula}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<span id="eleccionEmpresa" style="display:none">
									<input type="radio" id="eleccionEmpresa" name="eleccionEmpresa" value="todos" checked="checked"><spring:message code="filtro.todosLosCoches" text="Todos los Coches"/></br>								
									<input type="radio" id="eleccionEmpresa" name="eleccionEmpresa" value="conIncidencia"><spring:message code="filtro.incidencia" text="Incidencias Pendientes"/></br>
									<input type="radio" id="eleccionEmpresa" name="eleccionEmpresa" value="sinIncidencia"><spring:message code="filtro.sinIncidencia" text="Sin Incidencias"/>
								</span>
							</td>
			                <td>				
			                	<spring:message code="filtrar" text="Filtrar" var="filtrar"/>
								<input type="submit" value="${filtrar}"/>
							</td>
			            </tr>
       				</table>
   				 </form>
			</p>
			
			<c:if test="${error!=null}">
				<div class="errorblock">${error}</div>
			</c:if>
			<table>
				<tr>
					<th><spring:message code="coche.empresa" text="Empresa"/></th>
					<th><spring:message code="coche.matricula" text="Matrícula"/></th>
					<th><spring:message code="coche.marca" text="Marca"/></th>
					<th><spring:message code="coche.modelo" text="Modelo"/></th>
					<th><spring:message code="coche.incidencias" text="Incidencias Sin Resolver"/></th>
					<th/>
					<th/>
				</tr>
				<c:forEach items="${coches}" var="coche">
					<tr>
						<td>${coche.empresa.nombre}</td>
						<td>${coche.matricula}</td>
						<td>${coche.marca}</td>
						<td>${coche.modelo}</td>
						<c:choose>
							<c:when test="${coche.incidenciasPendientes==true}">
								<td align="center"><spring:message code="si" text="Sí"/></td>
							</c:when>
							<c:otherwise>
								<td align="center"><spring:message code="no" text="No"/></td>
							</c:otherwise>
						</c:choose>						
						<td><a href="/empresaReparto/incidencia/list/${coche.id}"><spring:message code="ver.incidencias" text="Ver incidencias" /></a></td>
					</tr>
				</c:forEach>
			</table>
			</div>
		<jsp:include page="../menu.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
