package net.mini_annuaire.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mini_annuaire.mvc.doa.EtudiantDao;
import net.mini_annuaire.mvc.model.DBConnec;

/**
 * Servlet implementation class EtudiantServlet
 */
@WebServlet("/etudiant-serv")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EtudiantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choix = request.getParameter("choix");
		if (choix.equals("chercher")) {
			String nom = request.getParameter("nom");
			try {
				EtudiantDao et = new EtudiantDao(DBConnec.getConnection());
				request.setAttribute("table", et.getEtu(nom));
				request.getRequestDispatcher("/RechercheEtudiant.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			long cne = Long.valueOf(request.getParameter("cne"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			long fil = Long.parseLong(request.getParameter("fil"));
			long depa = Long.parseLong(request.getParameter("depa"));
			String tel = request.getParameter("tel");
			try {
				EtudiantDao et = new EtudiantDao(DBConnec.getConnection());
				et.addEtudiant(cne, nom, prenom, fil, depa, tel);
				request.setAttribute("ok", "done");
				request.getRequestDispatcher("/InsertEtudiant.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
