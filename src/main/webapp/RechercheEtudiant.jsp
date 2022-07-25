<%@page import="net.mini_annuaire.mvc.model.DBConnec"%>
<%@page import="net.mini_annuaire.mvc.doa.EtudiantDao"%>
<%@page import="net.mini_annuaire.mvc.model.Etudiant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
List<Etudiant> etudiant = (List<Etudiant>) request.getAttribute("table");
%>
<!DOCTYPE html>
<html>
<head>
<title>Rechercher Etudiant</title>
<%@include file="CSS/head.jsp"%>
</head>
<body>
	<%@include file="CSS/menu.jsp"%>
	<div class="content">
		<div class="wrapper">
			<div class="containers">
				<div class="search_wrap search_wrap">
					<div class="search_box">
						<form action="etudiant-serv" method="post">
							<input type="hidden" value="chercher" name="choix"> <input
								type="text" class="input" name="nom" id="chercher"
								placeholder="search...">
							<button class="btns btn_common" type="submit" id="search">
								<i class="fas fa-search"></i>
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="table">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>CNE</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Telephone</th>
				</tr>
			</thead>
			<%
			for (Etudiant e : etudiant) {
			%>
			<tr>
				<th><%=e.getCne()%></th>
				<th><%=e.getNom()%></th>
				<th><%=e.getPrenom()%></th>
				<th><%=e.getTelephone()%></th>
			</tr>
			<%
			}
			%>
			<tbody>
			</tbody>
		</table>
	</div>
	</div>
	<%@include file="CSS/footer.jsp"%>
</body>
</html>