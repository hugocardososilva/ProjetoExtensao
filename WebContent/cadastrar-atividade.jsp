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
		
		<div><label for="tituloDaAtividade">Título da Atividade</label><br>
		<input name="tituloDaAtividade" type="text" id="tituloDaAtividade" size="100" maxlength="250" />
		</div>
		<div>
			          	 <h2>Tipo de atividade</h2>
						<label>
							<input type="radio" name="Tipo de atividade" value="Programa de Extensão" id="Tipodeatividade_0" />
							Programa de Extensão
						</label>
			<br />
						<label>
							<input type="radio" name="Tipo de atividade" value="Projeto de Extensão" id="Tipodeatividade_1" />
							Projeto de Extensão
						</label>
			<br />
						<label>
							<input type="radio" name="Tipo de atividade" value="Curso de Extensão" id="Tipodeatividade_2" />
							Curso de Extensão
						</label><br />			
						<label>	<input type="radio" name="Tipo de atividade" value="Evento de Extensão" id="Tipodeatividade_3" />
							Evento de Extensão
						</label>			
						<label>	<br />	<input type="radio" name="Tipo de atividade" value="Prestação de Serviço" id="Tipodeatividade_4" />
						Prestação de Serviço</label>            
						<br/>
						<label>
						<input type="radio" name="Tipo de atividade" value="Empreendedorismo" id="Tipodeatividade_5" />
						Empreendedorismo</label>            
						<br/>
			
						<label>
						<input type="radio" name="Tipo de atividade" value="Visitas Técnicas" id="Tipodeatividade_6" />
						Visitas Técnicas</label>            
						<br/>
			
						<label>
						<input type="radio" name="Tipo de atividade" value="Acompanhamento de Egressos" id="Tipodeatividade_7" />
						Acompanhamento de Egressos</label>
		</div>
		<div>
			<h2>Vínculo da atividade</h2>

		<label>
		<input type="radio" name="vinculoDaAtividade" value="Nenhum" id="vinculoDaAtividade_0" />
		Nenhum</label>

		<label>
		<br />
		<input type="radio" name="vinculoDaAtividade" value="PROBEXT" id="vinculoDaAtividade_1" />
		PROBEXT</label>

		<label>
		<br />
		<input type="radio" name="vinculoDaAtividade" value="PED" id="vinculoDaAtividade_2" />
		PED</label>

		<label>
		<br />
		<input type="radio" name="vinculoDaAtividade" value="Inclusão Digital" id="vinculoDaAtividade_3" />
		Inclusão Digital</label>

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


		<label>
		<input type="radio" name="Área temática" value="Comunicação" id="Aacutereatemaacutetica_0" />
		Comunicação</label>

		<br/>           
		<label>
		<input type="radio" name="Área temática" value="Cultura" id="Aacutereatemaacutetica_1" />
		Cultura</label>
		<br/>

		<label>
		<input type="radio" name="Área temática" value="Direitos Humanos e Justiça" id="Aacutereatemaacutetica_2" />
		Direitos Humanos e Justiça</label>
		<br/>

		<label>
		<input type="radio" name="Área temática" value="Educação" id="Aacutereatemaacutetica_3" />
		Educação</label>
		<br/>            
		<label>
		<input type="radio" name="Área temática" value="Meio Ambiente" id="Aacutereatemaacutetica_4" />
		Meio Ambiente</label>
		<br/>

		<label>
		<input type="radio" name="Área temática" value="Saúde" id="Aacutereatemaacutetica_5" />
		Saúde</label>
		<br/>

		<label>
		<input type="radio" name="Área temática" value="Tecnologia e Produção" id="Aacutereatemaacutetica_6" />
		Tecnologia e Produção</label>
		<br/>
		<label>
		<input type="radio" name="Área temática" value="Trabalho" id="Aacutereatemaacutetica_7" />
		Trabalho</label>

		<br/>
		</div>
		<div>
				<br/>
			<h2>Especifique  a linha de extensão</h2>

			<label for="especifiqueALinhaDeExtensão"></label>
				<select name="especifiqueALinhaDeExtensão" id="especifiqueALinhaDeExtensão">
				<option value="Assistência jurídica">Assistência jurídica</option>
				<option value="Atenção a Grupos de Pessoas com Necessidades">Atenção a Grupos de Pessoas com Necessidades</option>
				<option value="Especiais">Especiais</option>
				<option value="Atenção Integral à Mulher">Atenção Integral à Mulher</option>
				<option value="Atenção Integral à Criança">Atenção Integral à Criança</option>
				<option value="Atenção Integral à Saúde de Adultos">Atenção Integral à Saúde de Adultos</option>
				<option value="Atenção Integral à Terceira Idade">Atenção Integral à Terceira Idade</option>
				<option value="Atenção Integral ao Adolescente e ao Jovem">Atenção Integral ao Adolescente e ao Jovem</option>
				<option value="Capacitação de Gestores de Politicas Publicas">Capacitação de Gestores de Politicas Publicas</option>
				<option value="Comunicação Escrita e Eletrônica">Comunicação Escrita e Eletrônica</option>
				<option value="Cooperação Interinstitucional">Cooperação Interinstitucional</option>
				<option value="Cultura e Memória Social">Cultura e Memória Social</option>
				<option value="Desenvolvimento do Sistema de Saúde">Desenvolvimento do Sistema de Saúde</option>
				<option value="Desenvolvimento Rural">Desenvolvimento Rural</option>
				<option value="Desenvolvimento Urbano">Desenvolvimento Urbano</option>
				<option value="Direitos de Grupos Sociais">Direitos de Grupos Sociais</option>
				<option value="Direitos de Propriedade e Patentes">Direitos de Propriedade e Patentes</option>
				<option value="Educação à Distância">Educação à Distância</option>
				<option value="Educação Ambiental">Educação Ambiental</option>
				<option value="Educação Continuada">Educação Continuada</option>
				<option value="Educação de Jovens e Adultos">Educação de Jovens e Adultos</option>
				<option value="Educação Especial">Educação Especial</option>
				<option value="Educação Infantil">Educação Infantil</option>
				<option value="Educação Profissional">Educação Profissional</option>
				<option value="Empreendedorismo">Empreendedorismo</option>
				<option value="Ensino Fundamental">Ensino Fundamental</option>
				<option value="Ensino Médio">Ensino Médio</option>
				<option value="Esporte, Lazer e Saúde">Esporte, Lazer e Saúde</option>
				<option value="Gestão de Recursos Naturais">Gestão de Recursos Naturais</option>
				<option value="Hospitais e Clinicas Universitárias">Hospitais e Clinicas Universitárias</option>
				<option value="Incentivo à Leitura">Incentivo à Leitura</option>
				<option value="Inovação Tecnológica">Inovação Tecnológica</option>
				<option value="Mídia Comunitária">Mídia Comunitária</option>
				<option value="Novas Endemias e Epidemias">Novas Endemias e Epidemias</option>
				<option value="Organizações Populares">Organizações Populares</option>
				<option value="Polos Tecnológicos">Polos Tecnológicos</option>
				<option value="Produção Cultural e Artística na Área de Artes Plásticas e Artes Gráficas;">Produção Cultural e Artística na Área de Artes Plásticas e Artes Gráficas</option>
				<option value="Produção Cultural e Artística na Área de Música e Dança">Produção Cultural e Artística na Área de Música e Dança</option>
				<option value="Produção e Difusão de Material Educativo">Produção e Difusão de Material Educativo</option>
				<option value="Produção Teatral e Circense">Produção Teatral e Circense</option>
				<option value="Questão Agrária">Questão Agrária</option>
				<option value="Radio Universitária">Radio Universitária</option>
				<option value="Saúde da Família">Saúde da Família</option>
				<option value="Saúde e Segurança no Trabalho">Saúde e Segurança no Trabalho</option>
				<option value="Sistemas Integrados para Bacias Regionais">Sistemas Integrados para Bacias Regionais</option>
				<option value="Televisão Universitária">Televisão Universitária</option>
				<option value="Trabalho Infantil">Trabalho Infantil</option>
				<option value="Turismo">Turismo</option>
				<option value="Uso e Dependência de Drogas">Uso e Dependência de Drogas</option>
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
		<option value="reitoria">Reitoria</option>
		<option value="joaoPessoa">Campus João Pessoa</option>
		<option value="cajazeira">Campus Cajazeira</option>
		<option value="campinaGrande">Campus Campina Grande</option>
		<option value="sousa">Campus Sousa</option>
		<option value="cabedelo">Campus Cabedelo</option>
		<option value="picui">Campus Picuí</option>
		<option value="princesaIsabel">Campus Princesa Isabel</option>
		<option value="patos">Campus Patos</option>
		<option value="monteiro">Campus Monteiro</option>
		<option value="centroDeReferenciaEmPescaENavegaçãoMarítima">Centro de Referência em Pesca e Navegação Marítima</option>
		<option value="nucleoAvancadoDeGuarabira ">Núcleo Avançado de Guarabira </option> 
		</select> 
		</div>
	<input type="submit" value="Salvar">
	</form>

</div>

</body>
</html>