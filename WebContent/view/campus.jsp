<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="view/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen" />
<script type="text/javascript" src="view/js/jquery-3.1.1.js"></script>
<script src="view/bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Campus</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr class="filters">			
				<th><input type="text" class="form-control" disabled="disabled"/></th>
				<th><input type="text" class="form-control" disabled="disabled"/></th>
				<th><input type="text" class="form-control" disabled="disabled"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="campus" items="${listaCampus}" varStatus="id">

				<tr>
					<td>${campus.id}</td>
					<td>${campus.nome}</td>
					<td>${campus.estado}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>

</body>
</html>



