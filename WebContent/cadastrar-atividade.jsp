<%@page import="dao.DAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.TipoAtividade"%>
<%@page import="dao.DAOTipoAtividade"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nova Atividade</title>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<!-- <script src="bootstrap/js/bootstrap.min.js"></script> -->
</head>
<body>
	<div class="container">
<c:import url="scripts.jsp"/>
<c:import url="header.jsp"/>
<c:import url="menu.jsp"/>
	
	<div >

	<form role="form" action="Atividades.do?ref=novo" method="post" name="atividade">
		
		<div class="form-group">
			<label for="tituloDaAtividade">T�tulo da Atividade</label><br>
			<input name="tituloDaAtividade" class="form-control"type="text" id="tituloDaAtividade" size="100" maxlength="250" />
		</div>
		<div class="radio">
		
		
			          	 <h4>Tipo de atividade</h4>
			          	 <c:forEach var="tipo" items="${requestScope.listaTipo }">
						<label>
							<input type="radio" name="Tipo de atividade" value="${tipo.id }" id="Tipodeatividade_0" />
							${tipo.nome }
						</label>
						<br />
						</c:forEach>
			
		</div>
		
		<div class="radio">
			<h4>V�nculo da atividade</h4>
		 <c:forEach var="vinculo" items="${requestScope.vinculo }">
		<label>
		<input type="radio" name="vinculoDaAtividade" value="${vinculo.id }" id="vinculoDaAtividade_0" />
		${vinculo.nome }</label>
			<br />
		</c:forEach>
		
		
		
		
		
		</div>
		<div class="form-group">
			 <h4>Fonte  dos recursos</h4>
		<input class="form-control" name="fonteDeRecursos" type="text" size="50" maxlength="100" />
		<h4>Valor </h4>
		<label for="valor"></label>
		<input class="form-control" type="text" name="valor" id="valor" />
		</div>
		<div class="form-group">
		<h4>Objetivo</h4>

		<label for="objetivo"></label>
		<textarea class="form-control"  name="objetivo" cols="50" rows="4" id="objetivo"></textarea>
			
		</div>
		<div class="radio">
		<label> 
			<input type="radio" name="especificarAtividade" value="novo" id="especificarAtividade_0" />
		Atividade Nova</label>
<br />
		<label>
		
		
		<input type="radio" name="especificarAtividade" value="antiga" id="especificarAtividade_1" />
		Atividade realizada anteriormente no ano:</label>
		<label for="atividadeAntiga">
		
		<input class="form-control" name="atividadeAntiga" type="text" id="atividadeAntiga" size="4" maxlength="4" />
		</label>
		</div>
		<div class="radio">
			<h4>�rea  tem�tica</h4>

		<c:forEach var="areaTematica" items="${requestScope.areaTematica }">
			<label>
				<input type="radio" name="areaTematica" value="${areaTematica.id }" id="Aacutereatemaacutetica_0" />
					${areaTematica.area} ${areaTematica.descricao }</label>

				<br/>      
		</c:forEach>     
		</div>
		<div class="form-group">
				<br/>
			<h4>Especifique  a linha de extens�o</h4>

			<label for="especifiqueALinhaDeExtens�o"></label>
				
				<select class="form-control" name="especifiqueALinhaDeExtens�o" id="especifiqueALinhaDeExtens�o">
				
				<c:forEach var="linhaExtensao" items="${requestScope.linhaExtensao }" >
					<option value="${linhaExtensao.id }">${linhaExtensao.denominacao }</option>
				</c:forEach>
				
				
				</select>
			
		</div>
		
		<div class="form-group">
			<h4>Data de in�cio</h4>
			

		<input class="form-control" name="dataInicio" type="text" />

		<h4>Data prevista para t�rmino</h4>

		<input class="form-control" name="dataTermino" type="text" />
		
		</div>
		
		<div class="form-group">
				<h4>Local de realiza��o</h4>
		<select class="form-control" name="localDeLocalizacao" id="localDeLocalizacao">
		
		<c:forEach var="localRealizacao" items="${requestScope.localRealizacao }">
			<option value="${localRealizacao.id}">${localRealizacao.codigo } - ${localRealizacao.local }</option>
		</c:forEach>
		</select> 
		</div>
	 <button type="submit" class="btn btn-info">Salvar</button>
	</form>

</div>
</div>
</body>
</html>