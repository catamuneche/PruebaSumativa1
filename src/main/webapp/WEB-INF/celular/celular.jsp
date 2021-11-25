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
    <title>Celular</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
 
<body>
<h1>Agregar Celular</h1>
	<div class="container">
	    <form:form method="post" action="/celular/crear" modelAttribute="celular">
			<form:label path="numero" class="col-sm-2 col-form-label">Numero:</form:label>
			<form:input type="text" path="numero" class="form-control"/>
			<br>
			<form:select path="usuario">
				<c:forEach items="${listaUsuarios}" var="usuario" >
					<form:option value="${usuario.getId()}">
						${usuario.getNombre()} ${usuario.getApellido()}
			     	</form:option>
				</c:forEach>
			</form:select>
			<br>
			<input type="submit" value="Submit">

		</form:form>
    </div>
	</div>
</body>
</html>