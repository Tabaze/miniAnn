package net.mini_annuaire.mvc.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.mini_annuaire.mvc.model.*;

public class DepartementaDao {
	private Connection cn;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public DepartementaDao(Connection cn) {
		this.cn = cn;
	}

	public List<Departement> getAll() {
		List<Departement> etu = new ArrayList<Departement>();
		try {
			query = "select * from departement;";
			pst = this.cn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Departement er = new Departement();
				er.setNom_departement(rs.getString("nom_departement"));
				er.setNum_departement(rs.getLong("num_departement"));
				etu.add(er);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return etu;
	}

	public void addDep(String nom) {
		String query = "insert into departement(nom_departement) values(?);";
		try {
			pst = cn.prepareStatement(query);
			pst.setString(1, nom);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
