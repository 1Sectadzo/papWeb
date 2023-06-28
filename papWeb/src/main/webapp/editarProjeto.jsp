<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PAP</title>
<link rel="stylesheet" href="Bootstrap/bootstrap.css">
<link rel="stylesheet" href="css/css.css">
</head>
<body>
<h1 class="text-center">Projeto para Administrar Projetos - PAP</h1>

<div class="container">
  <div class="row">
    <div class="col">
    
    </div>
    <div class="col-6 ">
    <a href="/papWeb/listFuncs"><button type="button" class="btn btn btn-outline-secondary py-3 ">Funcionarios</button></a>
    <a href="novoFuncionario.jsp"><button type="button" class="btn btn btn-outline-secondary py-3 ">Adcionar Funcionario</button></a>
    <a href="/papWeb/listProjs"><button type="button" class="btn btn btn-outline-secondary py-3 ">Projetos</button></a>
    <a href="novoProjeto.jsp"><button type="button" class="btn btn btn-outline-secondary py-3 ">Criar Projeto</button></a>
    </div>
    <div class="col">
    
    </div>
  </div>
</div>
<img src ="imgs/logo1.png" class="center">
<div class="container">
  <div class="row">
    <div class="col">
    </div>
    <div class="col-9">
    	<form name="frmFuncionario" action="updateProj">
    	<table class="table">
		<thead class="thead-dark">
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nome</th>
			<th scope="col">Descrição</th>
			<th scope="col">Opções</th>
		</tr>
		</thead>
		<tbody>
       		
       		<td><input type="text" name="id"
       		value="<% out.println(request.getAttribute("id")); %>" size="2.5" readonly></td>
       		<td><input type="text" name="nome" size="10" value="<% out.println(request.getAttribute("nome")); %>" required></td>
       		<td><input type="text" name="descricao" value="<% out.println(request.getAttribute("descricao")); %>" required></td>
       		<td><input class="btn btn-primary" type="submit" style="margin: auto;" value="Salvar"></td>
       		</tbody>
       		</table>
    	</form>
    </div>
    <div class="col">
    </div>
  </div>
</div>
<script src="js/validadores.js"></script>
</body>
</html>

