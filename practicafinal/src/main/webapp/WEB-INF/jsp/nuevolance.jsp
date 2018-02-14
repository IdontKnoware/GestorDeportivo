<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>añade lance</title>
		<link rel="stylesheet" type="text/css" href="formato.css">
	</head>
	
	<body>
		<jsp:include page="cabecera.jsp"></jsp:include>
		<h1>AÑADIR NUEVO LANCE AL PARTIDO</h1>
		<table>
			<tr>
				<th>MINUTO</th>
				<th>LANCE</th>
				<th>EQUIPO</th>
				<th>COMENTARIO</th>
			</tr>
			<c:forEach var="lance" items="${nuevolance}">
				<tr>
					<td>${lance.getMinuto()}</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach> 
		</table>
		<form>
			<!-- Seleccionar el partido y el minuto -->
			Elige el partido:
			<select>
			<c:forEach var="partido" items="${nuevolance}">
				<option value="${partido.getId()}">${partido.getLocal().getNombre()} - ${partido.getVisitante().getNombre()}</option>
			</c:forEach>
			</select>
			
			Introduce el minuto:
			<input id="number" type="number">
			
			<!-- Seleccionar el tipo de lance -->
			<select>
				<option value="">AGRESIÓN</option>
				<option value="">CÓRNER</option>
				<option value="">FALTA</option>
				<option value="">GOL</option>
				<option value="">INCIDENCIA</option>
				<option value="">JUGADA</option>
				<option value="">LESIÓN</option>
				<option value="">OCASIÓN</option>
				<option value="">PENALTY</option>
				<option value="">TARJETA AMARILLA</option>
				<option value="">TARJETA ROJA</option>
			</select>
			
			<input type="submit" value="Enviar">
			<input type="reset" value="reset">
		</form>
	</body>

</html>