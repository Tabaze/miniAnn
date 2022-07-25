<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Ajouter Filliere</title>
<%@include file="CSS/head.jsp"%>
</head>
<body>
	<%@include file="CSS/menu.jsp"%>
	<div class="container">
		<header>Ajouter un Filliere</header>

		<form action="add-filliere" method="post">
			<div class="form first">
				<div class="details personal">
					<span class="title">Information Filliere</span>

					<div class="fields">
						<div class="input-fields">
							<label>NOM FILLIERE</label> <input type="text" name="nomF"
								placeholder="Entrer Nom de Filliere" required>
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