<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="navigation">
	<ul>
	<c:forEach items="${menu}" var="opcion">
		<li><a href="${opcion.value}"><spring:message code="${opcion.key}" text="${opcion.key}"/></a></li>	
	</c:forEach>			
	</ul>
</div>