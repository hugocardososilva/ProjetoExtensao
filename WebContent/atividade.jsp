<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atividade</title>
</head>
<body>
	<p>${requestScope.mensagem }</p>
		<div>
		<table>
		
		<tr>
			<td>ID</td>
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
		
		
		<c:choose>
			<c:when test="${requestScope.atividade.coordenador == null }">
				<tr><td>Coordenador</td></tr>
						<tr>
					
							<td><a href="inserir-coordenador.jsp?ref=atividade&id=${requestScope.atividade.id }">Adicionar Coordenador</a></td>
						</tr>
			</c:when>
				<c:otherwise>
				
					<tr><td>Coordenador</td></tr>
					
				
				<tr>
							<td>Nome</td>
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
				<td><a href="Coordenador.do?ref=editar">Editar</a></td>
				
				</tr>
				
				</c:otherwise>
		</c:choose>	
		
		<tr>
				<td>Docentes</td>
		</tr>
		<c:choose>
			<c:when test="${requestScope.atividade.docentes.isEmpty() }">
				
				<tr><td>Nenhum docente adicionado</td></tr>
				<tr><td><a href="inserir-equipe-tematica.jsp?especificacao=docente&id=${requestScope.atividade.id }">Adicionar Docente</a></td></tr>
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="docente" items="${requestScope.atividade.docentes }">
			<tr>
				<td>Nome</td>
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
			
			</c:forEach>
				<tr><td><a href="inserir-equipe-tematica.jsp?especificacao=docente&id=${requestScope.atividade.id }">Adicionar Docente</a><tr><td>
			
			
			
			
			</c:otherwise>
			
		</c:choose>
		
		<tr>
				<td>Técnicos Administrativos</td>
			</tr>
		<c:choose>
			<c:when test="${requestScope.atividade.tecnicos.isEmpty() }">
				
				<tr><td>Nenhum técnico administrativo adicionado</td></tr>
				<tr><td><a href="inserir-equipe-tematica.jsp?especificacao=tecnico&id=${requestScope.atividade.id }">Adicionar Técnico</a></td></tr>
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="tecnico" items="${requestScope.atividade.tecnicos }">
			<tr>
				<td>Nome</td>
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
			
			</c:forEach>
				<tr><td><a href="inserir-equipe-tematica.jsp?especificacao=tecnico&id=${requestScope.atividade.id }">Adicionar Técnico</a><tr><td>
			
			
			
			
			</c:otherwise>
			
		</c:choose>
		
				<tr>
				<td>Bolsistas</td>
			</tr>
		<c:choose>
			<c:when test="${requestScope.atividade.bolsistas.isEmpty() }">
				
				<tr><td>Nenhum bolsista adicionado</td></tr>
				<tr><td><a href="inserir-equipe-tematica.jsp?especificacao=bolsista&id=${requestScope.atividade.id }">Adicionar Bolsista</a></td></tr>
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="bolsista" items="${requestScope.atividade.bolsistas }">
			<tr>
				<td>Nome</td>
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
			
			</c:forEach>
				<tr><td><a href="inserir-equipe-tematica.jsp?especificacao=bolsista&id=${requestScope.atividade.id }">Adicionar Bolsista</a><tr><td>
			
			
			
			
			</c:otherwise>
			
		</c:choose>
		
					<tr>
				<td>Externos</td>
			</tr>
		<c:choose>
			<c:when test="${requestScope.atividade.externos.isEmpty() }">
				
				<tr><td>Nenhum externo adicionado</td></tr>
				<tr><td><a href="inserir-equipe-tematica.jsp?especificacao=externo&id=${requestScope.atividade.id }">Adicionar Externo</a></td></tr>
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="externo" items="${requestScope.atividade.externos }">
			<tr>
				<td>Nome</td>
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
				<td><a href="Participantes.do?ref=editar&especificacao=externo&id=${requestScope.atividade.id }&idParticipante=${externo.id}">Editar</a></td>
				<td><a href="Participantes.do?ref=remover&especificacao=externo&id=${requestScope.atividade.id }&idParticipante=${externo.id}">Remover</a></td>
			</tr>
			
			</c:forEach>
				<tr><td><a href="inserir-equipe-tematica.jsp?especificacao=externo&id=${requestScope.atividade.id }">Adicionar Externo</a><tr><td>
			
			
			
			
			</c:otherwise>
			
		</c:choose>
			
			
			
			
			
			
			
			</table>
		</div>
</body>
</html>