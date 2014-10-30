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
			<th>V�nculo</th>
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
			<th>�rea Tem�tica</th>
			<td>${requestScope.atividade.areaTematica.descricao }</td>
		</tr>
		<tr>
			<th>Linha de Extens�o</th>
			<td>${requestScope.atividade.linhaDeExtensao.denominacao }</td>
		</tr>
		<tr>
			<th>Data de Inicio</th>
			<td><fmt:formatDate value="${requestScope.atividade.dataInicio }" type="both"   
pattern="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<th>Data prevista para o t�rmino</th>
			<td><fmt:formatDate value="${requestScope.atividade.dataTermino }" type="both"   
pattern="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<th>Local de Realiza��o</th>
			<td>${requestScope.atividade.local.local }</td>		
		</tr>
		<tr>
			<th>Atividade Antiga?</th>
			<c:choose>
			<c:when test="${requestScope.atividade.atividadeAntiga == null}">
			
			<td>N�o</td>
			</c:when>	
			<c:otherwise>
			<td>Sim. Ano: ${requestScope.atividade.atividadeAntiga.ano }</td>
			</c:otherwise>
			</c:choose>
			
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
				<p><a href="Participantes.do?ref=novo&especificacao=coordenador&id=${requestScope.atividade.id }"><button style="clear:both;float:right" type="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"> </span>Adicionar Coordenador</button></a></p>
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
							<th>Telefone prim�rio</th>
							<td>${requestScope.atividade.coordenador.telPrimario }</td>
				</tr>
					<tr>
							<th>Telefone auxiliar</th>
							<td>${requestScope.atividade.coordenador.telAuxiliar }</td>
				</tr>
					<tr>
						<th>Volunt�rio ?</th>
						<td>${requestScope.atividade.coordenador.voluntario }</td>
					</tr>
				<tr>
				<th>Op�oes</th>
				<td>
					<a href="Coordenador.do?ref=editar">
						<button class="btn btn-warning" type="button">Editar</button>
					</a>
					<a href="Participantes.do?ref=remover&especificacao=coordenador&id=${requestScope.atividade.id }&idParticipante=${requestScope.atividade.coordenador.id}">
						<button class="btn btn-danger" type="button">Remover</button>
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
		<a href="Participantes.do?ref=novo&especificacao=docente&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" type="button" class="btn btn-success right">Adicionar Docente</button></a>
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
				<th>Volunt�rio ?</th>
				<td>${docente.voluntario }</td>
			</tr>
			<tr>
				<th>Op��es</th>
				
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
  					<h4>T�cnicos Administrativos</h4>
 			</div>
		 <div class="panel-body">
				
			<p><a href="Participantes.do?ref=novo&especificacao=tecnico&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar T�cnico</button></a></p>
		<c:choose>
			<c:when test="${requestScope.atividade.tecnicos.isEmpty() }">
				
				<p>Nenhum t�cnico administrativo adicionado</p>
				
				
				
				
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
				<th>Op��es</th>
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
				
			<p><a href="Participantes.do?ref=novo&especificacao=bolsista&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar Bolsista</button></a></p>
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
				<th>Op��es</th>
				<td>
					<a href="Participantes.do?ref=editar&especificacao=bolsista&id=${requestScope.atividade.id }&idParticipante=${bolsista.id}">
						<button class="btn btn-warning" type="button">Editar</button>
					</a>
					<a href="Participantes.do?ref=remover&especificacao=bolsista&id=${requestScope.atividade.id }&idParticipante=${bolsista.id}">
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
					
				<p><a href="Participantes.do?ref=novo&especificacao=externo&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar Externo</button></a></p>
			
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
				<th>Op��es</th>
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
			<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Benefici�rios</h4>
 			</div>
		 <div class="panel-body">
		 <div class="row">
		  <div class="col-md-6">
				<h4>Benefici�rios Diretos</h4>	
			<p><a href="Beneficiarios.do?ref=novo&especificacao=direto&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar</button></a></p>
		<c:choose>
			<c:when test="${requestScope.atividade.beneficiariosDiretos.isEmpty() }">
				
				<p>Nenhum benefici�rio adicionado</p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="direto" items="${requestScope.atividade.beneficiariosDiretos }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Nome</th>
				<td>${direto.nome }</td>
			</tr>
			
			<tr>
				<th>Op��es</th>
				<td>
					<a href="Beneficiarios.do?ref=editar&especificacao=direto&id=${requestScope.atividade.id }&idBeneficiario=${direto.id}">
					<button class="btn btn-warning" type="button">Editar</button>
					</a>
					<a href="Beneficiarios.do?ref=remover&especificacao=direto&id=${requestScope.atividade.id }&idBeneficiario=${direto.id}">
						<button class="btn btn-danger" type="button">Remover</button>
					</a>
				</td>
			</tr>
			</table>
			</c:forEach>
				
			</c:otherwise>
			
		</c:choose>
		</div>
		 <div class="col-md-6">
			
				<h4>Benefici�rios Indiretos</h4>	
			<p><a href="Beneficiarios.do?ref=novo&especificacao=indireto&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar</button></a></p>
		<c:choose>
			<c:when test="${requestScope.atividade.beneficiariosIndiretos.isEmpty() }">
				
				<p>Nenhum benefici�rio adicionado</p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="indireto" items="${requestScope.atividade.beneficiariosIndiretos }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Nome</th>
				<td>${indireto.nome }</td>
			</tr>
			
			<tr>
				<th>Op��es</th>
				<td>
					<a href="Beneficiarios.do?ref=editar&especificacao=indireto&id=${requestScope.atividade.id }&idBeneficiario=${indireto.id}">
					<button class="btn btn-warning" type="button">Editar</button>
					</a>
					<a href="Beneficiarios.do?ref=remover&especificacao=indireto&id=${requestScope.atividade.id }&idBeneficiario=${indireto.id}">
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
		</div>
		</div>
					<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Atividades Vinculadas</h4>
 			</div>
		 <div class="panel-body">
					
				<p><a href="VincularAtividades.do?ref=novo&id=${requestScope.atividade.id }">
					<button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar Atividade</button>
					</a></p>
		
		<c:choose>
			<c:when test="${requestScope.atividade.atividades.isEmpty() }">
					
				<p>Nenhum atividade adicionada</p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="atividade" items="${requestScope.atividade.atividades }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Titulo</th>
				<td>${atividade.titulo }</td>
			</tr>
			<tr>
				<th>Registro</th>
				<td>${atividade.registro }</td>
			</tr>
			<tr>
				<th>Op��es</th>
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
		
			
			
			
			
			
			
			
			
		
			
		
</body>
</html>