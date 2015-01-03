<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
 <%@ taglib prefix="Mensage" uri="projeto.tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<title>Adicionar Usuário</title>
<script>
function validaSenha (input){ 
	if (input.value != document.getElementById('senha').value) {
    input.setCustomValidity('Repita a senha corretamente');
  } else {
    input.setCustomValidity('');
  }
} 
</script>
</head>
<body>
<div class="container">
<Sessao:TagSessaoUser/>
<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>	
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Nova Usuário</h4>
 			</div>
		 <div class="panel-body">
<form role="form" action="UserController.do?ref=novo" method="post">
		
		<div class="form-group">
		
		
		<label for="nome">Nome<br />
		</label>
			<input value="${requestScope.nome }" class="form-control" name="nome" required="required" type="text"   />
		
		<label for="login">Login <br />
		</label>
			<input class="form-control" name="login" value="${requestScope.login }" required="required" type="text"  />
		<label for="email">Email <br />
		</label>
		
			<input class="form-control" value="${requestScope.email }" name="email" required="required" type="text" />
		<label for="senha">Senha <br />
		</label>
		
			<input class="form-control" name="senha"   id="senha" required="required" type="password" />
		
	
		<label for="senha2">Repetir Senha <br />
		</label>
		
			<input class="form-control" name="senha2" required="required" type="password" oninput="validaSenha(this)" />
		
		<label for="tel">Telefone <br />
		</label>
			<input class="form-control" value="${requestScope.tel }" name="tel" required="required" type="tel"  />
		</div>
		
		
		
		

	


		 <button type="submit" class="btn btn-info">Salvar</button>
		 </form>
</div>
</div>
</div>
	


</body>
</html>