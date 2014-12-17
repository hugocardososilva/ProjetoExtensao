<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
		
<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Novo Coordenador</h4>
 			</div>
		 <div class="panel-body">	
<form action="Coordenadores.do?ref=novo&id=${requestScope.id }" method="post">

		
		
		<input type="hidden" name="tipo" value="${requestScope.especificacao }">
		<label for="nomeCoordenador">Nome Completo<br />
		</label>
		<input name="nomeCoordenador" required="required" class="form-control" type="text" id="nomeCoordenador" size="50" maxlength="100" />

		<div class="radio">
				<label>
					
				<input type="radio" checked="checked" name="especificacaoCoordenador" value="Docente" id="especificacaoCoordenador_0" />
				Docente</label>
				<label>
				<input type="radio" name="especificacaoCoordenador" value="Técnico Administrativo" id="especificacaoCoordenador_1" />
				Técnico Administrativo</label>
				
		</div>
		
		


			<label for="emailCoordenador">Email<br />
			</label>
			<input class="form-control" required="required" name="emailCoordenador" type="email" id="emailCoordenador" size="50" maxlength="100" />

		
		Voluntario
		
		<div class="radio">
		<label>
		<input type="radio" checked="checked"  name="voluntario" value="sim" id="Voluntario_0" />
		Sim</label>
		<label>
		<input type="radio" name="voluntario" value="nao" id="Voluntario_1" />
		Não</label>
</div>

		
		<label  for="setorDeTrabalho">Setor de trabalho<br />
		</label>
		<input class="form-control" required="required" name="setorDeTrabalho" type="text" id="setorDeTrabalho" value="" size="50" maxlength="50" />
		</p>
		<p>


		<label for="phonePrimario">Fone principal<br />
		</label>
		<input  class="form-control" pattern="[0-9]+$" name="phonePrimario" type="text" id="phonePrimario" size="50" maxlength="10" />

		<label for="phonePrimario"><br />
		Fone secundário<br />
		</label>
		<input class="form-control" pattern="[0-9]+$" name="phonePrimario2" type="text" id="phonePrimario" size="50" maxlength="10" />

		<button type="submit" class="btn btn-info">Salvar</button> 




</form>
</div>
</div>

