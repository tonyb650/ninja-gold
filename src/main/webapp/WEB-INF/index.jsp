<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold!</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-4">
		<div class="row">
			<div class="col">
				<h5>Your Gold: <span class="border"><c:out value="${ gold }"/></span></h5>
			</div>
		</div>
		<div class="row">
			<div class="col text-center border m-3">
				<p>Farm</p>
				<p>(earns 10-20 gold)</p>
				<form action="/process" method="post">
					<input type="hidden" name="location" value="farm"/>
					<button class="btn m-1 btn-secondary"  type="submit">Find Gold</button>
				</form>
			</div>
			<div class="col text-center border m-3">
				<p>Cave</p>
				<p>(earns 5-10 gold)</p>
				<form action="/process" method="post">
					<input type="hidden" name="location" value="cave"/>
					<button class="btn m-1 btn-secondary"  type="submit">Find Gold</button>
				</form>
			</div>
			<div class="col text-center border m-3">
				<p>House</p>
				<p>(earns 2-5 gold)</p>
				<form action="/process" method="post">
					<input type="hidden" name="location" value="house"/>
					<button class="btn m-1 btn-secondary"  type="submit">Find Gold</button>
				</form>
			</div>
			<div class="col text-center border m-3">
				<p>Quest</p>
				<p>(earns/takes 0-50 gold)</p>
				<form action="/process" method="post">
					<input type="hidden" name="location" value="quest"/>
					<button class="btn m-1 btn-secondary" type="submit">Find Gold</button>
				</form>
			</div>
		</div>

		<div class="row">
		 	<div class="col text-center">
		 		<form action="reset" method="post">
					<button class="btn btn-primary" type="submit">Reset</button>
				</form>
			</div>
		</div>
		<div class="row">
			<h5>Activities</h5>
		</div>

	</div>

	<div class="container border overflow-auto" style="height: 200px;">
		<c:forEach var="item" items="${activity}">
		    <c:out value="${item}"/><br>
		</c:forEach>
	</div>

</body>
</html>