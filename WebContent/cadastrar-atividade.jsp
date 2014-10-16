<%@page import="dao.DAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.TipoAtividade"%>
<%@page import="dao.DAOTipoAtividade"%>
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
	<form action="CadastrarAtividade.do" method="post" name="atividade">
		
		<div><label for="tituloDaAtividade">T�tulo da Atividade</label><br>
		<input name="tituloDaAtividade" type="text" id="tituloDaAtividade" size="100" maxlength="250" />
		</div>
		<div>
		
			          	 <h2>Tipo de atividade</h2>
			          	 <c:forEach var="tipo" items="${requestScope.listaTipo }">
						<label>
							<input type="radio" name="Tipo de atividade" value="${tipo.nome }" id="Tipodeatividade_0" />
							${tipo.nome }
						</label>
						<br />
						</c:forEach>
			
		</div>
		<div>
			<h2>V�nculo da atividade</h2>
		 <c:forEach var="vinculo" items="${requestScope.vinculo }">
		<label>
		<input type="radio" name="vinculoDaAtividade" value="${vinculo.nome }" id="vinculoDaAtividade_0" />
		${vinculo.nome }</label>
		</br>
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
			<h2>�rea  tem�tica</h2>

		<c:forEach var="areaTematica" items="${requestScope.areaTematica }">
		<label>
		<input type="radio" name="�rea tem�tica" value="${areaTematica.area }" id="Aacutereatemaacutetica_0" />
		${areaTematica.area }</label>

		<br/>      
		</c:forEach>     
		</div>
		<div>
				<br/>
			<h2>Especifique  a linha de extens�o</h2>

			<label for="especifiqueALinhaDeExtens�o"></label>
				<select name="especifiqueALinhaDeExtens�o" id="especifiqueALinhaDeExtens�o">
				<option value="Assist�ncia jur�dica">Assist�ncia jur�dica</option>
				<option value="Aten��o a Grupos de Pessoas com Necessidades">Aten��o a Grupos de Pessoas com Necessidades</option>
				<option value="Especiais">Especiais</option>
				<option value="Aten��o Integral � Mulher">Aten��o Integral � Mulher</option>
				<option value="Aten��o Integral � Crian�a">Aten��o Integral � Crian�a</option>
				<option value="Aten��o Integral � Sa�de de Adultos">Aten��o Integral � Sa�de de Adultos</option>
				<option value="Aten��o Integral � Terceira Idade">Aten��o Integral � Terceira Idade</option>
				<option value="Aten��o Integral ao Adolescente e ao Jovem">Aten��o Integral ao Adolescente e ao Jovem</option>
				<option value="Capacita��o de Gestores de Politicas Publicas">Capacita��o de Gestores de Politicas Publicas</option>
				<option value="Comunica��o Escrita e Eletr�nica">Comunica��o Escrita e Eletr�nica</option>
				<option value="Coopera��o Interinstitucional">Coopera��o Interinstitucional</option>
				<option value="Cultura e Mem�ria Social">Cultura e Mem�ria Social</option>
				<option value="Desenvolvimento do Sistema de Sa�de">Desenvolvimento do Sistema de Sa�de</option>
				<option value="Desenvolvimento Rural">Desenvolvimento Rural</option>
				<option value="Desenvolvimento Urbano">Desenvolvimento Urbano</option>
				<option value="Direitos de Grupos Sociais">Direitos de Grupos Sociais</option>
				<option value="Direitos de Propriedade e Patentes">Direitos de Propriedade e Patentes</option>
				<option value="Educa��o � Dist�ncia">Educa��o � Dist�ncia</option>
				<option value="Educa��o Ambiental">Educa��o Ambiental</option>
				<option value="Educa��o Continuada">Educa��o Continuada</option>
				<option value="Educa��o de Jovens e Adultos">Educa��o de Jovens e Adultos</option>
				<option value="Educa��o Especial">Educa��o Especial</option>
				<option value="Educa��o Infantil">Educa��o Infantil</option>
				<option value="Educa��o Profissional">Educa��o Profissional</option>
				<option value="Empreendedorismo">Empreendedorismo</option>
				<option value="Ensino Fundamental">Ensino Fundamental</option>
				<option value="Ensino M�dio">Ensino M�dio</option>
				<option value="Esporte, Lazer e Sa�de">Esporte, Lazer e Sa�de</option>
				<option value="Gest�o de Recursos Naturais">Gest�o de Recursos Naturais</option>
				<option value="Hospitais e Clinicas Universit�rias">Hospitais e Clinicas Universit�rias</option>
				<option value="Incentivo � Leitura">Incentivo � Leitura</option>
				<option value="Inova��o Tecnol�gica">Inova��o Tecnol�gica</option>
				<option value="M�dia Comunit�ria">M�dia Comunit�ria</option>
				<option value="Novas Endemias e Epidemias">Novas Endemias e Epidemias</option>
				<option value="Organiza��es Populares">Organiza��es Populares</option>
				<option value="Polos Tecnol�gicos">Polos Tecnol�gicos</option>
				<option value="Produ��o Cultural e Art�stica na �rea de Artes Pl�sticas e Artes Gr�ficas;">Produ��o Cultural e Art�stica na �rea de Artes Pl�sticas e Artes Gr�ficas</option>
				<option value="Produ��o Cultural e Art�stica na �rea de M�sica e Dan�a">Produ��o Cultural e Art�stica na �rea de M�sica e Dan�a</option>
				<option value="Produ��o e Difus�o de Material Educativo">Produ��o e Difus�o de Material Educativo</option>
				<option value="Produ��o Teatral e Circense">Produ��o Teatral e Circense</option>
				<option value="Quest�o Agr�ria">Quest�o Agr�ria</option>
				<option value="Radio Universit�ria">Radio Universit�ria</option>
				<option value="Sa�de da Fam�lia">Sa�de da Fam�lia</option>
				<option value="Sa�de e Seguran�a no Trabalho">Sa�de e Seguran�a no Trabalho</option>
				<option value="Sistemas Integrados para Bacias Regionais">Sistemas Integrados para Bacias Regionais</option>
				<option value="Televis�o Universit�ria">Televis�o Universit�ria</option>
				<option value="Trabalho Infantil">Trabalho Infantil</option>
				<option value="Turismo">Turismo</option>
				<option value="Uso e Depend�ncia de Drogas">Uso e Depend�ncia de Drogas</option>
				</select>
			
		</div>
		
		<div>
			<h2>Data de in�cio</h2>

		<input name="dataInicio" type="text" />

		<h2>Data prevista para t�rmino</h2>

		<input name="dataTermino" type="text" />
		
		</div>
		
		<div>
				<h2>Local de realiza��o</h2>
		<select name="localDeLocalizacao" id="localDeLocalizacao">
		<option value="reitoria">Reitoria</option>
		<option value="joaoPessoa">Campus Jo�o Pessoa</option>
		<option value="cajazeira">Campus Cajazeira</option>
		<option value="campinaGrande">Campus Campina Grande</option>
		<option value="sousa">Campus Sousa</option>
		<option value="cabedelo">Campus Cabedelo</option>
		<option value="picui">Campus Picu�</option>
		<option value="princesaIsabel">Campus Princesa Isabel</option>
		<option value="patos">Campus Patos</option>
		<option value="monteiro">Campus Monteiro</option>
		<option value="centroDeReferenciaEmPescaENavega��oMar�tima">Centro de Refer�ncia em Pesca e Navega��o Mar�tima</option>
		<option value="nucleoAvancadoDeGuarabira ">N�cleo Avan�ado de Guarabira </option> 
		</select> 
		</div>
	<input type="submit" value="Salvar">
	</form>

</div>

</body>
</html>