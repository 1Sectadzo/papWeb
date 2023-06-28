<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "model.ProjetoFuncionarios" %>
    <%@ page import = "java.util.ArrayList" %>
    <% ArrayList<ProjetoFuncionarios> lista =(ArrayList<ProjetoFuncionarios>) request.getAttribute("projFuncs");%>
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
	<table class="table">
		<thead class="thead-dark">
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nome</th>
			<th scope="col">Funcao</th>
			<th scope="col">Opções</th>
			<th scope="col">      </th>
		</tr>
		</thead>
		<tbody>
                    <% for(int i=0; i<lista.size(); i++){ %>
                        <tr>
                            <td scope="row"><%= lista.get(i).getIdFuncionario() %></td>
                            <td><%= lista.get(i).getNome() %></td> 
                            <td><%= lista.get(i).getFuncao() %></td>
                            <td><a href="/papWeb/selectProjFunc?idProj=<%= lista.get(i).getIdProjeto() %>&idFunc=<%= lista.get(i).getIdFuncionario() %>"><button type="button" class="btn btn-outline-warning btn-sm"">Editar</button></a></td>
                            <td><a href="javascript:confirmarr(<%= lista.get(i).getIdProjeto() %>,<%= lista.get(i).getIdFuncionario() %>)"><button type="button" class="btn btn-outline-danger btn-sm" >Remover</button></a></td>               
                        </tr>
                    <% } %>
                </tbody>
	</table>
    </div>
    <div class="col">
    
    </div>
  </div>
</div>
<script type="text/javascript" src="js/confirmacao2.js"></script>
</body>
</html>