<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "model.Projetos" %>
    <%@ page import = "java.util.ArrayList" %>
    <% ArrayList<Projetos> lista =(ArrayList<Projetos>) request.getAttribute("projetos");%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Bootstrap/bootstrap.css">
<link rel="stylesheet" href="css/css.css">
<meta charset="UTF-8">
<title>PAP</title>
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
    	<form name="frmFuncionario" action="insertProjFunc">
    	<table class="table">
		<thead class="thead-dark">
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nome</th>
			<th scope="col">Função</th>
			<th scope="col">Projeto</th>
			<th scope="col">       </th>
		</tr>
		</thead>
		<tbody>     		
       		<td><input type="text" name="idFunc"
       		value="<% out.println(request.getAttribute("id")); %>" size="2.5" readonly></td>
       		<td><input type="text" name="nomeFunc" size="10"
       		value="<% out.println(request.getAttribute("nome")); %>" readonly></td>
       		<td><input type="text" name="funcao" required></td>
       		<td><select name="idProj" onchange="funcao1(event)" required>
       		<option disabled selected>Escolha um Projeto</option>
       			<% for(int i=0; i<lista.size(); i++){ %>
                        <option value="<%= lista.get(i).getId() %>"><%= lista.get(i).getId() %> | <%= lista.get(i).getNome() %></option>
                    <% } %>
       		</select></td>
       		<td><input class="btn btn-primary" type="submit" style="margin: auto;" value="Salvar"></td>
       		</tbody>
       		</table>
    	</form>
    </div>
    <div class="col">
    </div>
  </div>
</div>
<script type="text/javascript" src="js/funcao1.js"></script>
</body>
</html>