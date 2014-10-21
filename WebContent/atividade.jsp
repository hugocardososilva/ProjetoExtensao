<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="Mensage" uri="projeto.tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atividade</title>
</head>
<body>
<div class="container">
<c:import url="scripts.jsp"/>
<c:import url="header.jsp"/>
<c:import url="menu.jsp"/>

	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>
	<div class="panel panel-default">
  			<div class="panel-heading">
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
			<td>${requestScope.atividade.vinculo }</td>
		</tr>
		<tr>
			<th>Fonte de Recursos</th>
			<td>${requestScope.atividade.fonteDeRecurso }</td>
		</tr>
		<tr>
			<th>Valor</th>
			<td>${requestScope.atividade.valor }</td>
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
			<td>${requestScope.atividade.dataInicio }</td>
		</tr>
		<tr>
			<th>Data prevista para o término</th>
			<td>${requestScope.atividade.dataTermino }</td>
		</tr>
		<tr>
			<th>Local de Realização</th>
			<td>${requestScope.atividade.local.local }</td>		
		</tr>
		
		</table> 
		</div>
		</div>
		<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Coordenador</h4>
 			</div>
		 <div class="panel-body">
			
		<c:choose>
			<c:when test="${requestScope.atividade.coordenador == null }">
				<p><a href="inserir-coordenador.jsp?ref=atividade&especificacao=coordenador&id=${requestScope.atividade.id }"><button style="clear:both;float:right" type="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"> </span>Adicionar Coordenador</button></a></p>
						<p>Nenhum coordenador adicionado</p>
					
							
						
			</c:when>
				<c:otherwise>
				
					
					
				<table class="table table-bordered table-hover ">
				<tr>
							<th class="tdnome">Nome</th>
							<td>${requestScope.atividade.coordenador.nome }</td>
							
				</tr>
				<tr>
							<th>Tipo</th>
							<td>${requestScope.atividade.coordenador.tipo }</td>
				</tr>
				<tr>
							<th>Setor</th>
							<td>${requestScope.atividade.coordenador.setor }</td>
				</tr>
				<tr>
							<th>Email</th>
							<td>${requestScope.atividade.coordenador.email }</td>
				</tr>
				<tr>
							<th>Telefone primário</th>
							<td>${requestScope.atividade.coordenador.telPrimario }</td>
				</tr>
					<tr>
							<th>Telefone auxiliar</th>
							<td>${requestScope.atividade.coordenador.telAuxiliar }</td>
				</tr>
					<tr>
						<th>Voluntário ?</th>
						<td>${requestScope.atividade.coordenador.voluntario }</td>
					</tr>
				<tr>
				<th>Opçoes</th>
				<td>
					<a href="Coordenador.do?ref=editar">
						<button class="btn btn-warning" type="button">Editar</button>
					</a>
					<a href="Coordenador.do?ref=remover">
						<button class="btn btn-danger" type="button">Editar</button>
					</a>
				</td>
				
				</tr>
				</table>
				</c:otherwise>
		</c:choose>	
		</div>
		</div>
		
		
			<div class="panel panel-default">
  			<div class="panel-heading">
  				<h4>Docentes</h4>
  			</div>
		<div class="panel-body">
		<a href="inserir-equipe-tematica.jsp?especificacao=docente&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" type="button" class="btn btn-success right">Adicionar Docente</button></a>
		<c:choose>
			<c:when test="${requestScope.atividade.docentes.isEmpty() }">
				
				<p>Nenhum docente adicionado </p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="docente" items="${requestScope.atividade.docentes }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Nome</th>
				<td>${docente.nome }</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${docente.email }</td>
			</tr>
			<tr>
				<th>Voluntário ?</th>
				<td>${docente.voluntario }</td>
			</tr>
			<tr>
				<th>Opções</th>
				
				<td>
					<a href="Participantes.do?ref=editar&especificacao=docente&id=${requestScope.atividade.id }&idParticipante=${docente.id}">
						<button class="btn btn-warning" type="button">Editar</button>
					</a>
				<a href="Participantes.do?ref=remover&especificacao=docente&id=${requestScope.atividade.id }&idParticipante=${docente.id}">
					<button  class="btn btn-danger" type="button">Remover</button>
				</a>
				</td>
				
			</tr>
			</table>
			</c:forEach>
				
			
			
			
			
			</c:otherwise>
			
		</c:choose>
		
			</div>
			</div>
			<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Técnicos Administrativos</h4>
 			</div>
		 <div class="panel-body">
				
			<p><a href="inserir-equipe-tematica.jsp?especificacao=tecnico&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar Técnico</button></a></p>
		<c:choose>
			<c:when test="${requestScope.atividade.tecnicos.isEmpty() }">
				
				<p>Nenhum técnico administrativo adicionado</p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="tecnico" items="${requestScope.atividade.tecnicos }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Nome</th>
				<td>${tecnico.nome }</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${tecnico.email }</td>
			</tr>
			<tr>
				<th>Voluntario?</th>
				<td>${tecnico.voluntario }</td>
			</tr>
			<tr>
				<th>Opções</th>
				<td>
					<a href="Participantes.do?ref=editar&especificacao=tecnico&id=${requestScope.atividade.id }&idParticipante=${tecnico.id}">
					<button class="btn btn-warning" type="button">Editar</button>
					</a>
					<a href="Participantes.do?ref=remover&especificacao=tecnico&id=${requestScope.atividade.id }&idParticipante=${tecnico.id}">
						<button class="btn btn-danger" type="button">Remover</button>
					</a>
				</td>
			</tr>
			</table>
			</c:forEach>
				
			</c:otherwise>
			
		</c:choose>
		</div>
		</div>
		<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Bolsistas</h4>
 			</div>
		 <div class="panel-body">
				
			<p><a href="inserir-equipe-tematica.jsp?especificacao=bolsista&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar Bolsista</button></a></p>
		<c:choose>
			<c:when test="${requestScope.atividade.bolsistas.isEmpty() }">
				
				<p>Nenhum bolsista adicionado</p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="bolsista" items="${requestScope.atividade.bolsistas }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Nome</th>
				<td>${bolsista.nome }</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${bolsista.email }</td>
			</tr>
			<tr>
				<th>Voluntario?</th>
				<td>${bolsista.voluntario }</td>
			</tr>
			<tr>
				<th>Opções</th>
				<td>
					<a href="Participantes.do?ref=editar&especificacao=bolsista&id=${requestScope.atividade.id }&idParticipante=${tecnico.id}">
						<button class="btn btn-warning" type="button">Editar</button>
					</a>
					<a href="Participantes.do?ref=remover&especificacao=bolsista&id=${requestScope.atividade.id }&idParticipante=${tecnico.id}">
						<button class="btn btn-danger" type="button">Remover</button>
					</a>
				</td>
			</tr>
			</table>
			
			</c:forEach>
				
			
			
			
			
			</c:otherwise>
			
		</c:choose>
		</div>
		</div>
			<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Externos</h4>
 			</div>
		 <div class="panel-body">
					
				<p><a href="inserir-equipe-tematica.jsp?especificacao=externo&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar Externo</button></a></p>
			
		<c:choose>
			<c:when test="${requestScope.atividade.externos.isEmpty() }">
					
				<p>Nenhum externo adicionado</p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="externo" items="${requestScope.atividade.externos }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Nome</th>
				<td>${externo.nome }</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${externo.email }</td>
			</tr>
			<tr>
				<th>Voluntario?</th>
				<td>${externo.voluntario }</td>
			</tr>
			<tr>
				<th>Opções</th>
				<td>
					<a href="Participantes.do?ref=editar&especificacao=externo&id=${requestScope.atividade.id }&idParticipante=${externo.id}">
						<button class="btn btn-warning" type="button">Editar</button>
					</a>
				<a href="Participantes.do?ref=remover&especificacao=externo&id=${requestScope.atividade.id }&idParticipante=${externo.id}">
					<button class="btn btn-danger" type="button">Remover</button>
				</a></td>
			</tr>
			</table>
			</c:forEach>
				
			
			
			
			
			</c:otherwise>
			
		</c:choose>
			
			</div>
			</div>
			<p><a href="GerarRegistro.do?id=${requestScope.atividade.id }"><button class="btn btn-info" type="button">Gerar Registro e imprimir</button></a></p>
			
			
			
			
			
			
			
		</div>
		</div>
		
</body>
</html>