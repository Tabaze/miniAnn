package net.mini_annuaire.mvc.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.mini_annuaire.mvc.model.Filliere;

public class FilliereDoa {

	private Connection cn;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public FilliereDoa(Connection cn) {
		this.cn = cn;
	}

	public List<Filliere> getAll() {
		List<Filliere> etu = new ArrayList<Filliere>();
		try {
			query = "select * from filliere;";
			pst = this.cn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Filliere er = new Filliere();
				er.setNum_filliere(rs.getLong("num_filliere"));
				er.setNom_filliere(rs.getString("nom_filliere"));
				etu.add(er);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return etu;
	}
	public void addFil(String nom) {
		String query = "insert into filliere(nom_filliere) values(?);";
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
