<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<style type="text/css">
	div.login {
		margin: 200px auto;
		width:400px; 
		padding:20px;
		background: #F6F0E0;
		border-radius:10px;
		line-height: 10px; 
	}
	div.login h1{
		background: #BFBD93;
		line-height: 40px;
		font-size: 1.5em;
		text-align: center;
	}
	div.login p{
		margin: 20px 0px;		
	}
	div.login input{
		width: 400px;		
	}
	div.login p.submit{
		text-align: right;
	}
	div.login input[type="submit"]{
		width: 100px;		
	}
	.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Login</title>


</head>
<body>
${error}

	<div class="login">
		<h1>Login</h1>
		
		<form:form modelAttribute="usuario" method="POST" action="/empresaReparto/login/add">
		<form:errors path="*" cssClass="errorblock" element="div" />
			<p>
				<form:label path="usuario"/>
				<form:input path="usuario" />
				<form:errors path="usuario" cssClass="error" />
			</p>
			<p>
				<form:label path="password"/>
				<form:input path="password"/>
				<form:errors path="password" cssClass="error" />
			</p>
			<p class="submit">	
				<input type="submit" value="Entrar"/>
			</p>
		</form:form>
	</div>
</body>
</html>