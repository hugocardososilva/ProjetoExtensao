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
</head>
<body>
<div>
	<form action="Atividades.do?ref=novo" method="post" name="atividade">
		
		<div><label for="tituloDaAtividade">Título da Atividade</label><br>
		<input name="tituloDaAtividade" type="text" id="tituloDaAtividade" size="100" maxlength="250" />
		</div>
		<div>
		
			          	 <h2>Tipo de atividade</h2>
			          	 <c:forEach var="tipo" items="${requestScope.listaTipo }">
						<label>
							<input type="radio" name="Tipo de atividade" value="${tipo.id }" id="Tipodeatividade_0" />
							${tipo.nome }
						</label>
						<br />
						</c:forEach>
			
		</div>
		<div>
			<h2>Vínculo da atividade</h2>
		 <c:forEach var="vinculo" items="${requestScope.vinculo }">
		<label>
		<input type="radio" name="vinculoDaAtividade" value="${vinculo.id }" id="vinculoDaAtividade_0" />
		${vinculo.nome }</label>
		
		</c:forEach>
		<label>
		<br />
		
		<input type="radio" name="vinculoDaAtividade" value="Outros" id="vinculoDaAtividade_4" />
		Outros</label>
		<label for="outroVinculoDeAtividade"></label>
		<input name="outroVinculoDeAtividade" type="text" id="outroVinculoDeAtividade" size="50" maxlength="100" />
			
		</div>
		<div>
			 <h2>Fonte  dos recursos</h2>
		<input name="fonteDeRecursos" type="text" size="50" maxlength="100" />
		<h2>Valor </h2>
		<label for="valor"></label>
		<input type="text" name="valor" id="valor" />

		<h2>Objetivo</h2>

		<label for="objetivo"></label>
		<textarea name="objetivo" cols="50" rows="4" id="objetivo"></textarea>
			
		</div>
		<div>
		<label> 
			<input type="radio" name="especificarAtividade" value="novo" id="especificarAtividade_0" />
		Atividade Nova</label>

		<label>
		<br />
		<input type="radio" name="especificarAtividade" value="antiga" id="especificarAtividade_1" />
		Atividade realizada anteriormente no Ano: </label>
		<label for="atividadeAntiga"></label>
		<input name="atividadeAntiga" type="text" id="atividadeAntiga" size="4" maxlength="4" />
		</div>
		<div>
			<h2>Área  temática</h2>

		<c:forEach var="areaTematica" items="${requestScope.areaTematica }">
			<label>
				<input type="radio" name="areaTematica" value="${areaTematica.id }" id="Aacutereatemaacutetica_0" />
					${areaTematica.area} ${areaTematica.descricao }</label>

				<br/>      
		</c:forEach>     
		</div>
		<div>
				<br/>
			<h2>Especifique  a linha de extensão</h2>

			<label for="especifiqueALinhaDeExtensão"></label>
				
				<select name="especifiqueALinhaDeExtensão" id="especifiqueALinhaDeExtensão">
				
				<c:forEach var="linhaExtensao" items="${requestScope.linhaExtensao }" >
					<option value="${linhaExtensao.id }">${linhaExtensao.denominacao }</option>
				</c:forEach>
				
				
				</select>
			
		</div>
		
		<div>
			<h2>Data de início</h2>
			

		<input name="dataInicio" type="text" />

		<h2>Data prevista para término</h2>

		<input name="dataTermino" type="text" />
		
		</div>
		
		<div>
				<h2>Local de realização</h2>
		<select name="localDeLocalizacao" id="localDeLocalizacao">
		
		<c:forEach var="localRealizacao" items="${requestScope.localRealizacao }">
			<option value="${localRealizacao.id}">${localRealizacao.codigo } - ${localRealizacao.local }</option>
		</c:forEach>
		</select> 
		</div>
	<input type="submit" value="Salvar">
	</form>

</div>

</body>
</html>