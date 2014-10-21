<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navbar navbar-inverse">

 <div class="navbar-inner">


<ul class="nav">
<li><a href="index.jsp">Início</a></li>
<li><a href="admin/index.jsp">Administrador</a></li>
<li><a href="Contato.jsp">Cadastro</a></li>
<li><a href="condomino/index.jsp">Condômino</a></li>
<div id="login" style="float: right;">
<c:choose>
 <c:when test="${sessionScope.condomino== null }">
	<c:import url="Login.jsp" />
</c:when>
<c:otherwise>
<div id="welcome">Bem vindo, ${sessionScope.condomino.login }</div>
</c:otherwise>
 
 </c:choose>	
</div>

</ul>
</div>
</div>