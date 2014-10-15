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
			<td>Vínculo</td>
			<td>${requestScope.atividade.vinculo }</td>
		</tr>
		<tr>
			<td>Tipo da Atividade</td>
			<td>${requestScope.atividade.tipoAtividade }</td>
		</tr>
		<tr>
			<td>Linha de Extensão</td>
			<td>${requestScope.atividade.linhaDeExtensao }</td>
		</tr>
		<tr>
			<td>Local de Realização</td>
			<td>${requestScope.atividade.local }</td>		
		</tr>
		<tr>
			<td>Objetivo</td>
			<td>${requestScope.atividade.objetivo }</td>
		</tr>
		<tr>
			<td>Valor</td>
			<td>${requestScope.atividade.valor }</td>
		</tr>
		<c:choose>
			<c:when test="${requestScope.atividade.coordenador == null }">
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
		<c:choose>
			<c:when test="${requestScope.atividade.docentes == null }">
				
				<tr><td>Nenhum docente adicionado</td></tr>
				
				
				
			</c:when>
			<c:otherwise>
			<tr><td>teste</td>	</tr>
			</c:otherwise>
		</c:choose>
		<tr><td><a href="inserir-equipe-tematica.jsp?id=${requestScope.atividade.id }">Adicionar Equipe Temática</a><tr><td>
			
			
			
			
			
			
			
			</table>
		</div>
</body>
</html>