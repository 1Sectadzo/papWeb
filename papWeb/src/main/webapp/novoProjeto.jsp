<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<div class="container" >
  <div class="row">
    <div class="col">
    
    </div>
    <div class="col-6">
    	<form name="frmProjeto" action="insertProj">
		<fieldset>
		<legend>Inserir novo projeto</legend>
		<div class="mb-3">
		<label>Nome</label>
		<input class="form-control" type="text" name="nome" required>
		</div>
		<div class="mb-3">
		<label>Descrição</label>
		<input id="inputDesc" class="form-control" type="text" name="descricao" required>
		</div>
		<input class="btn btn-primary" type="submit" style="margin: auto;" value="Salvar">
		</fieldset>
	</form>
    </div>
    <div class="col">
    
    </div>
  </div>
</div>
<script src="js/validador1.js"></script>
</body>
</html>