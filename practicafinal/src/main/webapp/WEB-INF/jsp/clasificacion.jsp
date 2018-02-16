<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Clasificacion</title>
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
<body>
	<body
	style="background: url(https://images.alphacoders.com/510/510026.jpg) no-repeat center; background-size: cover; background-position-y: 0px">
	<jsp:include page="cabecera.jsp"></jsp:include>
	<h1 class="text-center mt-5">Clasificacion</h1>
	
<div class=" mt-5 container bg-light card p-0 border-secondary rounded">
		<form class="p-0 m-0 rounded">
			<table class="table table-striped table-sm rounded mb-1">
			<thead class="thead-dark rounded">
				<tr>
					<th >Equipo</th>
					<th>P. Ganados</th>
					<th>P. Empatados</th>
					<th>P. Perdidos</th>
					<th>Goles a Favor</th>
					<th>Goles en Contra</th>
					<th>Puntos</th>
				</tr>
			</thead>
			<c:forEach var="clasificado" items="${clasificacion}">
					<tr>
						<td>${clasificado.equipo.nombre}</td>
						<td>${clasificado.PGL + clasificado.PGV}</td>
						<td>${clasificado.PEL + clasificado.PEV}</td>
						<td>${clasificado.PPL + clasificado.PEV}</td>
						<td>${clasificado.GFL + clasificado.GFV}</td>
						<td>${clasificado.GCL + clasificado.GCV}</td>
						<td>${((clasificado.PGL * 3) + clasificado.PEL)+
								((clasificado.PGV * 3) + clasificado.PEV)}</td>
					</tr>
				</c:forEach>
		
</body>
</html>