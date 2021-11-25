<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
 
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
 
<body>
<h1>Usuarios</h1>

	<div class="container-">
		 <form:form method="post" action="/usuario/login" modelAttribute="usuario">
			<form:label path="nombre">Nombre: </form:label>
			<form:input type="text" path="nombre"/> 
			<br><br>
			<form:label path="apellido">Apellido: </form:label>
			<form:input type="text" path="apellido"/> 
			<br><br>
			
			<input style="background-color: orange; color:white" type="button" value="Limpiar">
			<input style="background-color: green; color:white" type="submit" value="enviar">
			
		</form:form>
		
	    <br>
	    <hr>    
	    <table class="table">
			<thead >
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>CRUD</th>
				</tr>
			</thead>
			<c:forEach items="${listaUsuarios}" var="lista">
				<tr>
					<td>${lista.getNombre()}</td>
					<td>${lista.getApellido()}</td>
					<td>
						<form action="/usuario/eliminar" method="POST">
							<input type="Hidden" name="id" value="${lista.getId()}">
							<input type="submit" value="Eliminar">
						</form>
						<form action="/usuario/editar" method="POST">
							<input type="Hidden" name="id" value="${lista.getId()}">
							<input type="submit" value="Editar">
						</form>
						
					</td>
				</tr>
			</c:forEach>
		</table>   
	</div>
</body>
</html>