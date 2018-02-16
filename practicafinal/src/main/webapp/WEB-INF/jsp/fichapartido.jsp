<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ficha del Partidoe</title>
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

<body
	style="background: url(https://images.alphacoders.com/510/510026.jpg) no-repeat center; background-size: cover; background-position-y: 0px">
	<jsp:include page="cabecera.jsp"></jsp:include>
	<h1 class="text-center mt-5">Ficha del Partido</h1>

	<div class="d-flex justify-content-center">
		<div class="card" style="width: 25rem; height: 15rem">

			<div class="d-flex align-items-center flex-wrap align-self-center">
				<h4 class="card-title mr-3">Jornada: ${partido.jornada}</h4>
				<h4 class="card-title ml-3">Partido: ${partido.id}</h4>
			</div>


			<div class="container">
				<div class="row">
					<div
						class=" col-4 d-flex align-items-start flex-column justify-content-center">
						<p class="align-self-center ">${partido.local.nombre}</p>
					</div>

					<div class="col-4 d-flex justify-content-center p-2">
						<p class="display-4">${partido.golesLocal}</p>
						<p class="display-4">-</p>
						<p class="display-4">${partido.golesVisitante}</p>
					</div>

					<div class="col-4 d-flex align-items-end p-2">
						<p class="align-self-center">${partido.visitante.nombre}</p>
					</div>
				</div>
			</div>
					<div class="d-flex justify-content-center">
				<form class="container-fluid text-center"
					action="./../partidos/${partido.id}">

					<button class="btn btn-danger " type="submit"
						<c:if test="${partido.estado eq 'CERRADO'}">${disabled="disabled"}</c:if>>
						${partido.estado}</button>

				</form>
			</div>

		</div>
	</div>


	<div class="col container mt-5 d-flex justify-content-center">
		<table class="table-secondary table-striped table-sm rounded">
			<tr>
				<th>Minuto</th>
				<th>Lace</th>
				<th>Equipo</th>
				<th>Comentario</th>
			</tr>
			<c:forEach var="lance" items="${lances}">
				<tr>
					<td>${lance.minuto}'</td>
					<td>${lance.tipos}</td>
					<td>${lance.equipo.nombre}</td>
					<td>${lance.comentario}</td>
				</tr>
			</c:forEach>
			
			<tr>
			
				<c:if test="${partido.estado eq 'ABIERTO'}">

					<form action="./../guardarlance" method="POST" id="submitlance">
						<td><input type="number" name="minuto" min="1" max="95" /></td>
						<td><select class="form-control" name="tipolance">
								<c:forEach var="tipoLance" items="${tiposLance}">
									<option value="${tipoLance}">${tipoLance}</option>
								</c:forEach>
						</select></td>
						<td><select name="equipo" class="form-control">
								<option value="${partido.local.id}">${partido.local.nombre}</option>
								<option value="${partido.visitante.id}">${partido.visitante.nombre}</option>
						</select></td>
						<td><textarea class="form-control" name="comentario" rows="3"></textarea></td>
						<input type="hidden" name="partido" value="${partido.id}" />
						
						<!--  <input type="submit" class="btn btn-success "
									value="Guardar Lance" />-->
					</form>
				</c:if>
			</tr>
		
		</table>
	</div>
	<c:if test="${partido.estado eq 'ABIERTO'}">
	<div class="container d-flex justify-content-center my-5">
		<input type="submit" form="submitlance" value="Guardar Lance" class="btn btn-warning text-dark">
	</div>
	</c:if>
</body>
</html>