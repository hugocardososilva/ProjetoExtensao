<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="Mensage" uri="projeto.tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
</head>
<body>
<div class="container">

<c:import url="scripts.jsp"/>
	<c:import url="header.jsp"/>
	<c:import url="menu.jsp"/>
	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>
	
	<h4>Para utilizar o sistema, por favor, efetue o login abaixo.</h4>
	<form role="form" action="UserController.do?ref=login" method="post" >
        <div class="form-group">
          <input type="text" name="login" class="form-control" placeholder="login">
        </div>
        <div class="form-group">
          <input type="password" name="senha" class="form-control" placeholder="senha">
        </div>
        <button type="submit" class="btn btn-default">Login</button>
      </form>
      </div>
     
</body>
</html>