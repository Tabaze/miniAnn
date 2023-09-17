<%@page import="net.mini_annuaire.mvc.model.*"%>
<%@page import="net.mini_annuaire.mvc.doa.*"%>
<%@page import="net.mini_annuaire.mvc.controller.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
FilliereDoa fd = new FilliereDoa(DBConnec.getConnection());
List<Filliere> fil = fd.getAll();
DepartementaDao dd = new DepartementaDao(DBConnec.getConnection());
List<Departement> dep = dd.getAll();
%>
<!DOCTYPE html>
<html>
<head>
<title>Ajouter Etudiant</title>
<%@include file="CSS/head.jsp"%>
</head>
<body>
	<%@include file="CSS/menu.jsp"%>
	<div class="container">
		<header>Ajouter un Etudiant</header>

		<form action="etudiant-serv" method="post">
		<input type="hidden" value="insert" name="choix">
			<div class="form first">
				<div class="details personal">
					<span class="title">Information Personnelle</span>

					<div class="fields">
						<div class="input-field">
							<label>CNE</label> <input name="cne" type="number"
								placeholder="Entrer votre CNE" required>
						</div>

						<div class="input-field">
							<label>NOM</label> <input name="nom" type="text"
								placeholder="Entrer votre nom" required>
						</div>

						<div class="input-field">
							<label>PRENOM</label> <input name="prenom" type="text"
								placeholder="Enter votre prenom" required>
						</div>

						<div class="input-field">
							<label>FILLIERE</label> <select name="fil" required>
								<option disabled selected>Selectionner filliere</option>
								<%
								for (Filliere f : fil) {
								%>
								<option value="<%=f.getNum_filliere()%>"><%=f.getNom_filliere()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div class="input-field">
							<label>DEPARTEMENT</label> <select name="depa" required>
								<option disabled selected>Selectionner Departement</option>
								<%
								for (Departement d : dep) {
								%>
								<option value="<%=d.getNum_departement()%>"><%=d.getNom_departement()%></option>
								<%
								}
								%>
							</select>
						</div>

						<div class="input-field">
							<label>TELEPHONE</label> <input name="tel" type="tel"
								placeholder="Entrer votre telephone" required>
						</div>
					</div>
				</div>
				<button class="nextBtn" type="submit">
					<span class="btnText">Ajouter </span> <i class="uil uil-navigator"></i>
				</button>
			</div>
		</form>
	</div>
	<%@include file="CSS/footer.jsp"%>
</body>
</html>