<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nova Atividade</title>
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<!-- <script src="bootstrap/js/bootstrap.min.js"></script> -->
</head>
<body>
	<div class="container">
<c:import url="../scripts.jsp"/>
<c:import url="../header.jsp"/>
<c:import url="../menu.jsp"/>
	
	<div >

	<form role="form" action="../Atividades.do?ref=novo" method="post" name="atividade">
		
		<div class="form-group">
			<label for="tituloDaAtividade">Título da Atividade</label><br>
			<input name="tituloDaAtividade" required="required" class="form-control"type="text" id="tituloDaAtividade" size="100" maxlength="250" />
		</div>
		<div class="radio">
		
		
			          	 <h4>Tipo de atividade</h4>
			          	 <c:forEach var="tipo"  items="${requestScope.listaTipo }">
						<label>
							<input type="radio" required="required" name="Tipo de atividade" value="${tipo.id }" id="Tipodeatividade_0" />
							${tipo.nome }
						</label>
						<br />
						</c:forEach>
			
		</div>
		
		<div class="radio">
			<h4>Vínculo da atividade</h4>
		 <c:forEach var="vinculo" items="${requestScope.vinculo }">
		<label>
		<input type="radio"  required="required" name="vinculoDaAtividade" value="${vinculo.id }" id="vinculoDaAtividade_0" />
		${vinculo.nome }</label>
			<br />
		</c:forEach>
		
		
		
		
		
		</div>
		<div class="form-group">
			 <h4>Fonte  dos recursos</h4>
		<input class="form-control" name="fonteDeRecursos"  type="text" size="50" maxlength="100" />
		<h4>Valor </h4>
		<label for="valor"></label>
		<input class="form-control" type="text" required="required" name="valor" id="valor" />
		</div>
		<div class="form-group">
		<h4>Objetivo</h4>

		<label for="objetivo"></label>
		<textarea class="form-control"  required="required" name="objetivo" cols="50" rows="4" id="objetivo"></textarea>
			
		</div>
		<div class="radio">
		<label> 
			<input type="radio" name="especificarAtividade" checked="checked" value="novo" id="especificarAtividade_0" />
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
			<h4>Área  temática</h4>

		<c:forEach var="areaTematica" items="${requestScope.areaTematica }">
			<label>
				<input type="radio" required="required" name="areaTematica" value="${areaTematica.id }" id="Aacutereatemaacutetica_0" />
					${areaTematica.area} ${areaTematica.descricao }</label>

				<br/>      
		</c:forEach>     
		</div>
		<div class="form-group">
				<br/>
			<h4>Especifique  a linha de extensão</h4>

			<label for="especifiqueALinhaDeExtensão"></label>
				
				<select class="form-control" name="especifiqueALinhaDeExtensão" id="especifiqueALinhaDeExtensão">
				
				<c:forEach var="linhaExtensao" items="${requestScope.linhaExtensao }" >
					<option value="${linhaExtensao.id }">${linhaExtensao.denominacao }</option>
				</c:forEach>
				
				
				</select>
			
		</div>
		
		<div class="form-group">
			<h4>Data de início</h4>
			

		<input class="form-control" name="dataInicio" type="date" />

		<h4>Data prevista para término</h4>

		<input class="form-control" name="dataTermino" type="date" />
		
		</div>
		
		<div class="form-group">
				<h4>Local de realização</h4>
		<select class="form-control" name="localDeLocalizacao" id="localDeLocalizacao">
		
		<c:forEach var="localRealizacao" items="${requestScope.localRealizacao }">
			<option value="${localRealizacao.id}">${localRealizacao.codigo } - ${localRealizacao.local }</option>
		</c:forEach>
		</select> 
		</div>
		<div class="form-group">
		<h4>Beneficiários Diretos</h4>

		<label for="beneficiariosDiretos"></label>
		<textarea class="form-control"  required="required" name="beneficiariosDiretos" cols="50" rows="4" id="objetivo"></textarea>
			
		</div>
		<div class="form-group">
		<h4>Beneficiários Indiretos</h4>

		<label for="beneficiarioIndiretos"></label>
		<textarea class="form-control"  required="required" name="beneficiariosIndiretos" cols="50" rows="4" id="objetivo"></textarea>
			
		</div>
	 <button type="submit" class="btn btn-info">Salvar</button>
	</form>

</div>
</div>
</body>
</html>