<%@ taglib prefix="Mensage" uri="projeto.tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir beneficiário</title>
</head>
<body>
	<div class="container">
<c:import url="../scripts.jsp"/>
<c:import url="../header.jsp"/>
<c:import url="../menu.jsp"/>

	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>
	


<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Novo Beneficiario</h4>
 			</div>
		 <div class="panel-body">
<form role="form" action="Beneficiarios.do?ref=salvar&id=${requestScope.id }" method="post">
		
		<div class="form-group">
		
		<input type="hidden" name="especificacao" value="${requestScope.especificacao }">
		
		<label for="nome">Nome <br />
		</label>
			<input class="form-control" name="nome" type="text" id="nome" size="50" maxlength="100" />
		</div>
		
		

</div>
		 <button type="submit" class="btn btn-info">Salvar</button>

</form>
</div>
</div>
</div>
</body>
</html>