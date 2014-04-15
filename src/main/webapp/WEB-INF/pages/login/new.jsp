<%@ page contentType="text/html; charset=UTF-8" %>

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
</style>
<title>Login</title>


</head>
<body>
${error}
	<div class="login">
		<h1>Login</h1>
		<form method="POST" action="/empresaReparto/login/add">
			<p>
				<input type="text" placeholder="Usuario" name="usuario"/>
			</p>
			<p>
				<input type="password" placeholder="Password" name="password"/>
			</p>
			<p class="submit">	
				<input type="submit" value="Entrar"/>
			</p>
		</form>
	</div>
</body>
</html>