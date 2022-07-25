package net.mini_annuaire.mvc.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.mini_annuaire.mvc.model.Etudiant;

public class EtudiantDao {
	private Connection cn;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public EtudiantDao(Connection cn) {
		this.cn = cn;
	}

	public void getEtu() {
		try {
			query = "select * from etudiant;";
			pst = this.cn.prepareStatement(query);
			rs = pst.executeQuery();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public List<Etudiant> getEtu(String nom) {
		ArrayList<Etudiant> etdiants = new ArrayList();
		try {
			query = "select * from etudiant where nom like '%" + nom + "%' or prenom like'%" + nom + "%';";
			pst = this.cn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Etudiant e = new Etudiant();
				e.setCne(rs.getLong("CNE"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setTelephone(rs.getString("telephone"));
				etdiants.add(e);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return etdiants;
	}

	public void addEtudiant(long cne, String nom, String prenom, long fil, long depa, String tel) {
		String query = "insert into etudiant(CNE,nom,prenom,num_filliere,num_departement,telephone) values(?,?,?,?,?,?);";

		try {
			pst = cn.prepareStatement(query);
			pst.setLong(1, cne);
			pst.setString(2, nom);
			pst.setString(3, prenom);
			pst.setLong(4, fil);
			pst.setLong(5, depa);
			pst.setString(6, tel);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
