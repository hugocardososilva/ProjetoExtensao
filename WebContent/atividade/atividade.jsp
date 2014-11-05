<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="Mensage" uri="projeto.tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atividade</title>
</head>
<body>
<div class="container">
<c:import url="../scripts.jsp"/>
<c:import url="../header.jsp"/>
<c:import url="../menu.jsp"/>

	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>
	<div class="panel panel-default">
  			<div class="panel-heading">
  			<p><a href="Atividades.do?ref=editar&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-warning" type="button">Editar</button></a></p>
  					<h4>Atividade</h4>
  					
 			</div>
		 <div class="panel-body">
		<table class="table table-bordered table-hover">
		
		<tr>
			<th class="tdnome">ID</th>
			<td>${requestScope.atividade.id }</td>
		</tr>
		<tr>
			<th>Titulo</th>
			<td>${requestScope.atividade.titulo }</td>
		</tr>
		<tr>
			<th>Tipo da Atividade</th>
			<td>${requestScope.atividade.tipoAtividade.nome }</td>
		</tr>
		<tr>
			<th>Vínculo</th>
			<td>${requestScope.atividade.vinculo.nome }</td>
		</tr>
		<tr>
			<th>Fonte de Recursos</th>
			<td>${requestScope.atividade.fonteDeRecurso }</td>
		</tr>
		<tr>
			<th>Valor</th>
			<td><fmt:formatNumber type="currency" currencySymbol="R$" currencyCode="BRL" value="${requestScope.atividade.valor }"/></td>
		</tr>
		<tr>
			<th>Objetivo</th>
			<td>${requestScope.atividade.objetivo }</td>
		</tr>
		<tr>
			<th>Área Temática</th>
			<td>${requestScope.atividade.areaTematica.descricao }</td>
		</tr>
		<tr>
			<th>Linha de Extensão</th>
			<td>${requestScope.atividade.linhaDeExtensao.denominacao }</td>
		</tr>
		<tr>
			<th>Data de Inicio</th>
			<td><fmt:formatDate value="${requestScope.atividade.dataInicio }" type="both"   
pattern="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<th>Data prevista para o término</th>
			<td><fmt:formatDate value="${requestScope.atividade.dataTermino }" type="both"   
pattern="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<th>Local de Realização</th>
			<td>${requestScope.atividade.local.local }</td>		
		</tr>
		<tr>
			<th>Atividade Antiga?</th>
			<c:choose>
			<c:when test="${requestScope.atividade.atividadeAntiga == null}">
			
			<td>Não</td>
			</c:when>	
			<c:otherwise>
			<td>Sim. Ano: ${requestScope.atividade.atividadeAntiga.ano }</td>
			</c:otherwise>
			</c:choose>
			
		</tr>
		<tr>
			<th>Beneficiários Diretos</th>
			<td>${requestScope.atividade.beneficiariosDiretos }</td>		
		</tr>
		<tr>
			<th>Beneficiários Indiretos</th>
			<td>${requestScope.atividade.beneficiariosIndiretos }</td>		
		</tr>
		
		</table> 
		</div>
		</div>
		<c:import url="../painel/painel-coordenador.jsp"/>
		<c:import url="../painel/painel-docente.jsp"/>
		<c:import url="../painel/painel-bolsista.jsp"/>
		<c:import url="../painel/painel-externo.jsp"/>
		<c:import url="../painel/painel-atividade-vinculada.jsp"/>
		
		
			

		
			<p><a href="GerarRegistro.do?id=${requestScope.atividade.id }"><button class="btn btn-info" type="button">Gerar Registro e imprimir</button></a></p>
		</div>
		
			
			
			
			
			
			
			
			
		
			
		
</body>
</html>