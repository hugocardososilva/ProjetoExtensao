<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	<div class="alert alert-info" role="alert">${requestScope.mensagem }</div>
		<div>
		<table class="table table-bordered table-hover">
		
		<tr>
			<td class="tdnome">ID</td>
			<td>${requestScope.atividade.id }</td>
		</tr>
		<tr>
			<td>Titulo</td>
			<td>${requestScope.atividade.titulo }</td>
		</tr>
		<tr>
			<td>Tipo da Atividade</td>
			<td>${requestScope.atividade.tipoAtividade.nome }</td>
		</tr>
		<tr>
			<td>Vínculo</td>
			<td>${requestScope.atividade.vinculo }</td>
		</tr>
		<tr>
			<td>Fonte de Recursos</td>
			<td>${requestScope.atividade.fonteDeRecurso }</td>
		</tr>
		<tr>
			<td>Valor</td>
			<td>${requestScope.atividade.valor }</td>
		</tr>
		<tr>
			<td>Objetivo</td>
			<td>${requestScope.atividade.objetivo }</td>
		</tr>
		<tr>
			<td>Área Temática</td>
			<td>${requestScope.atividade.areaTematica.descricao }</td>
		</tr>
		<tr>
			<td>Linha de Extensão</td>
			<td>${requestScope.atividade.linhaDeExtensao.denominacao }</td>
		</tr>
		<tr>
			<td>Data de Inicio</td>
			<td>${requestScope.atividade.dataInicio }</td>
		</tr>
		<tr>
			<td>Data prevista para o término</td>
			<td>${requestScope.atividade.dataTermino }</td>
		</tr>
		<tr>
			<td>Local de Realização</td>
			<td>${requestScope.atividade.local.local }</td>		
		</tr>
		
		</table> 
		
		<h4>Coordenador</h4>
		
		<c:choose>
			<c:when test="${requestScope.atividade.coordenador == null }">
				
						<p>Nenhum coordenador adicionado</p>
					
							<p><a href="inserir-coordenador.jsp?ref=atividade&especificacao=coordenador&id=${requestScope.atividade.id }"><button type="button" class="btn btn-success">Adicionar Coordenador</button></a></p>
						
			</c:when>
				<c:otherwise>
				
					
					
				<table class="table table-bordered table-hover ">
				<tr>
							<td class="tdnome">Nome</td>
							<td>${requestScope.atividade.coordenador.nome }</td>
							
				</tr>
				<tr>
							<td>Tipo</td>
							<td>${requestScope.atividade.coordenador.tipo }</td>
				</tr>
				<tr>
							<td>Setor</td>
							<td>${requestScope.atividade.coordenador.setor }</td>
				</tr>
				<tr>
							<td>Email</td>
							<td>${requestScope.atividade.coordenador.email }</td>
				</tr>
				<tr>
							<td>Telefone primário</td>
							<td>${requestScope.atividade.coordenador.telPrimario }</td>
				</tr>
					<tr>
							<td>Telefone auxiliar</td>
							<td>${requestScope.atividade.coordenador.telAuxiliar }</td>
				</tr>
				<tr>
				<td><a href="Coordenador.do?ref=editar"><button class="btn btn-info" type="button">Editar</button></a></td>
				
				</tr>
				</table>
				</c:otherwise>
		</c:choose>	
		
		
				<h4>Docentes</h4>
		
		<c:choose>
			<c:when test="${requestScope.atividade.docentes.isEmpty() }">
				
				<p>Nenhum docente adicionado</p>
				<p><a href="inserir-equipe-tematica.jsp?especificacao=docente&id=${requestScope.atividade.id }"><button type="button" class="btn btn-success">Adicionar Docente</button></a></p>
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="docente" items="${requestScope.atividade.docentes }">
			<table class="table table-bordered table-hover ">
			<tr>
				<td class="tdnome">Nome</td>
				<td>${docente.nome }</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${docente.email }</td>
			</tr>
			<tr>
				<td>Voluntario?</td>
				<td>${docente.voluntario }</td>
			</tr>
			<tr>
				<td>Opções</td>
				<td><a href="Participantes.do?ref=editar&especificacao=docente&id=${requestScope.atividade.id }&idParticipante=${docente.id}">Editar</a></td>
				<td><a href="Participantes.do?ref=remover&especificacao=docente&id=${requestScope.atividade.id }&idParticipante=${docente.id}">Remover</a></td>
			</tr>
			</table>
			</c:forEach>
				<p><a href="inserir-equipe-tematica.jsp?especificacao=docente&id=${requestScope.atividade.id }"><button type="button" class="btn btn-success">Adicionar Docente</button></a><p>
			
			
			
			
			</c:otherwise>
			
		</c:choose>
		
		
				<h4>Técnicos Administrativos</h4>
			
		<c:choose>
			<c:when test="${requestScope.atividade.tecnicos.isEmpty() }">
				
				<p>Nenhum técnico administrativo adicionado</p>
				<p><a href="inserir-equipe-tematica.jsp?especificacao=tecnico&id=${requestScope.atividade.id }"><button class="btn btn-success" type="button">Adicionar Técnico</button></a></p>
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="tecnico" items="${requestScope.atividade.tecnicos }">
			<table class="table table-bordered table-hover ">
			<tr>
				<td class="tdnome">Nome</td>
				<td>${tecnico.nome }</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${tecnico.email }</td>
			</tr>
			<tr>
				<td>Voluntario?</td>
				<td>${tecnico.voluntario }</td>
			</tr>
			<tr>
				<td>Opções</td>
				<td><a href="Participantes.do?ref=editar&especificacao=tecnico&id=${requestScope.atividade.id }&idParticipante=${tecnico.id}">Editar</a></td>
				<td><a href="Participantes.do?ref=remover&especificacao=tecnico&id=${requestScope.atividade.id }&idParticipante=${tecnico.id}">Remover</a></td>
			</tr>
			</table>
			</c:forEach>
				<p><a href="inserir-equipe-tematica.jsp?especificacao=tecnico&id=${requestScope.atividade.id }"><button type="button" class="btn btn-success">Adicionar Técnico</button></a><p>
			
			
			
			
			</c:otherwise>
			
		</c:choose>
		
				<h4>Bolsistas</h4>
			
		<c:choose>
			<c:when test="${requestScope.atividade.bolsistas.isEmpty() }">
				
				<p>Nenhum bolsista adicionado</p>
				<p><a href="inserir-equipe-tematica.jsp?especificacao=bolsista&id=${requestScope.atividade.id }"><button class="btn btn-success" type="button">Adicionar Bolsista</button></a></p>
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="bolsista" items="${requestScope.atividade.bolsistas }">
			<table class="table table-bordered table-hover ">
			<tr>
				<td class="tdnome">Nome</td>
				<td>${bolsista.nome }</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${bolsista.email }</td>
			</tr>
			<tr>
				<td>Voluntario?</td>
				<td>${bolsista.voluntario }</td>
			</tr>
			<tr>
				<td>Opções</td>
				<td><a href="Participantes.do?ref=editar&especificacao=bolsista&id=${requestScope.atividade.id }&idParticipante=${tecnico.id}">Editar</a></td>
				<td><a href="Participantes.do?ref=remover&especificacao=bolsista&id=${requestScope.atividade.id }&idParticipante=${tecnico.id}">Remover</a></td>
			</tr>
			</table>
			
			</c:forEach>
				<p><a href="inserir-equipe-tematica.jsp?especificacao=bolsista&id=${requestScope.atividade.id }"><button type="button" class="btn btn-success">Adicionar Bolsista</button></a><p>
			
			
			
			
			</c:otherwise>
			
		</c:choose>
		
					
				<h4>Externos</h4>
			
		<c:choose>
			<c:when test="${requestScope.atividade.externos.isEmpty() }">
				
				<p>Nenhum externo adicionado</p>
				<p><a href="inserir-equipe-tematica.jsp?especificacao=externo&id=${requestScope.atividade.id }"><button class="btn btn-success" type="button">Adicionar Externo</button></a></p>
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="externo" items="${requestScope.atividade.externos }">
			<table class="table table-bordered table-hover ">
			<tr>
				<td class="tdnome">Nome</td>
				<td>${externo.nome }</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${externo.email }</td>
			</tr>
			<tr>
				<td>Voluntario?</td>
				<td>${externo.voluntario }</td>
			</tr>
			<tr>
				<td>Opções</td>
				<td><a href="Participantes.do?ref=editar&especificacao=externo&id=${requestScope.atividade.id }&idParticipante=${externo.id}">Editar</a>
				<a href="Participantes.do?ref=remover&especificacao=externo&id=${requestScope.atividade.id }&idParticipante=${externo.id}">Remover</a></td>
			</tr>
			</table>
			</c:forEach>
				<p><a href="inserir-equipe-tematica.jsp?especificacao=externo&id=${requestScope.atividade.id }"><button type="button" class="btn btn-success">Adicionar Externo</button></a><p>
			
			
			
			
			</c:otherwise>
			
		</c:choose>
			
			
			<p><a href="GerarRegistro.do?id=${requestScope.atividade.id }"><button class="btn btn-info" type="button">Gerar Registro e imprimir</button></a></p>
			
			
			
			
			
			
			
		</div>
		</div>
		
</body>
</html>