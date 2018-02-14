<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
	<head>
		<meta charset=UTF-8>
		<title>Insert title here</title>
	</head>
	<body>
		<h1>ABRIR / CERRAR PARTIDOS</h1>
		
		<form>
			<table>
				<tr>
					<th>ID</th>
					<th>Jornada</th>
					<th>L</th>
					<th>V</th>
					<th>ESTADO</th>
					<th>ABRIR/CERRAR</th>
					<th>VER</th>
				</tr>
				
				<c:forEach var="partido" items="${partidos}">
					<tr>
						<td>${partido.getId()}</td>
						<td>${partido.getJornada()}</td>
						<td>${partido.getLocal().nombre}</td>
						<td>${partido.getVisitante().nombre}</td>
						<td>${partido.getEstado()}</td>
						<td>
							<a href="./finalizar/${partido.getId()}">change</a>
						</td>
						<td><a href="./detalle/?id=${partido.getId()}">Ver</a></td>
					</tr>
				</c:forEach>
				
			</table>
		</form>
	</body>
</html>