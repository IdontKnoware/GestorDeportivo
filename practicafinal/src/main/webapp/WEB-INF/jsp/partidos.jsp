<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
	<head>
		<meta charset=UTF-8>
		<title>Lista de Partidos</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width" />
		<link rel="stylesheet" type="text/css"
			href="/webjars/bootstrap/css/bootstrap.min.css" />
		<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
		<script type="text/javascript"
			src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet"
			href="/webjars/font-awesome/css/font-awesome.min.css"></link>
		
	</head>
	<body style="background: url(https://images.alphacoders.com/510/510026.jpg) 
						 	 no-repeat
							 center; 
				 background-size: cover;
				 background-position-y: 0px">
			 
		<jsp:include page="cabecera.jsp"></jsp:include>
		
		<h1 class="text-center my-4">Lista de Partidos</h1>
		<div class=" mt-5 container bg-light card p-0 border-secondary rounded">
		<form class="p-0 m-0 rounded">
			<table class="table table-striped table-sm rounded mb-1">
			<thead class="thead-dark rounded">
				<tr>
					<th >#</th>
					<th>Jornada</th>
					<th>Local</th>
					<th>Visitante</th>
					<th>Estado</th>
					<th>Ficha</th>
				</tr>
			</thead>
				
				<c:forEach var="partido" items="${partidos}">
					<tr>
						<td>${partido.id}</td>
						<td>${partido.jornada}</td>
						<td>${partido.local.nombre}</td>
						<td>${partido.visitante.nombre}</td>
						<td>${partido.estado}</td>
						
						<td><a href="./fichapartido/${partido.id}">Ver</a></td>
					</tr>
				</c:forEach>
				
			</table>
		</form>
		</div>
	</body>
</html>