<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>añade lance</title>
</head>
	
<body>
		<jsp:include page="cabecera.jsp"></jsp:include>
		<h2>FICHA DEL PARTIDO</h2>
		
		<h4>Jornada: ${partido.jornada}</h4>
		<h4>ID Partido: ${partido.id}</h4>
		
	<table>
		<tr>
			<td>Local: ${partido.local.nombre}</td>
			<td>Goles: ${partido.golesLocal}</td>
		</tr>
		<tr>
			<td>Visitante: ${partido.visitante.nombre}</td>
			<td>Goles: ${partido.golesVisitante}</td>
		</tr>	
	</table>
	<p>Estado: ${partido.estado}</p><button value="cerrar">CERRAR</button>
		
	<h4>LANCES</h4>
	<table>
		<tr>
			<th>MINUTO</th>
			<th>LANCE</th>
			<th>EQUIPO</th>
			<th>COMENTARIO</th>
		</tr>
		<c:forEach var="lance" items="${lances}">
			<tr>
				<td>${lance.minuto}</td>
				<td>${lance.tipos}</td>
				<td>${lance.equipo.nombre}</td>
				<td>${lance.comentario}</td>
			</tr>
		</c:forEach>
	</table>
		
	<form action="./../guardarlance" method="POST">
		<input type="number" name="minuto"/>
		
		<select name="tipolance">
			<c:forEach var="tipoLance" items="${tiposLance}">
				<option value="${tipoLance}">${tipoLance}</option>
			</c:forEach>
		</select>
		
		<select name="equipo">
			<option value="${partido.local.id}">${partido.local.nombre}</option>
			<option value="${partido.visitante.id}">${partido.visitante.nombre}</option>
		</select>
		
		<input type="text" name="comentario">
		
		<input type="hidden" name="partido" value="${partido.id}" />
		<input type="submit" value="AÑADIR" />
	</form>
	
</body>
</html>