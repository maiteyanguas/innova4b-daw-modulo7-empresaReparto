<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="navigation">
	<ul>
	<c:forEach items="${menu}" var="opcion">
		<li><a href="${opcion.value}">${opcion.key}</a></li>	
	</c:forEach>			
	</ul>
</div>