<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PARTIDOS DE LA JORNADA ${partido.jornada}</title>
	</head>
	<body>
		<h1 class="text-center">Clasificacion</h1>
		Selecciona la jornada: 
		<select>
			<c:forEach var="jornada" items="${partidos.jornada}">
				<option value="${jornada}"></option>
			</c:forEach>
		</select>
		
		<ul>
			<c:forEach var="partido" items="${partidos}">
				<li>
					${partido.idEquipoLocal.nombre} + ${partido.golesLocal} + "-" + 
					${partido.idEquipoVisitante.nombre} + ${partido.golesVisitante} + "-" +
					${partido.estado}
				</li>
			</c:forEach>
		</ul>
	</body>
</html>