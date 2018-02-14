<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<title>añade lance</title>
	</head>
	
	<body>
		<h1>AÑADIR NUEVO LANCE AL PARTIDO</h1>
		<form>
			<!-- Seleccionar el partido y el minuto -->
			Elige el partido:
			<c:forEach var="partido" items="${partidos}">
				<input type="radio" name="id" value="partido.getID()">
				<p>${partido.idEquipoLocal} "-" ${partido.idEquipoVisitante}</p>
			</c:forEach>
			
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