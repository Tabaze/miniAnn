<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Ajouter Departement</title>
<%@include file="CSS/head.jsp"%>
</head>
<body>
	<%@include file="CSS/menu.jsp"%>
	<div class="container">
		<header>Ajouter un Departement</header>

		<form action="add-departement" method="post">
			<div class="form first">
				<div class="details personal">
					<span class="title">Information Departement</span>

					<div class="fields">
						<div class="input-fields">
							<label>NOM DEPARTEMENT</label> <input type="text" name="nomD"
								placeholder="Entrer Nom de Departement" required>
						</div>
					</div>
				</div>
				<button class="nextBtn">
					<span class="btnText">Ajouter </span> <i class="uil uil-navigator"></i>
				</button>
			</div>
		</form>
	</div>
	<%@include file="CSS/footer.jsp"%>
</body>
</html>