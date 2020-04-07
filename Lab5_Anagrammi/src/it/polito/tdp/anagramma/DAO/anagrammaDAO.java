package it.polito.tdp.anagramma.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class anagrammaDAO {
	public boolean parolaEsiste(String parola) {
		final String sql = "SELECT COUNT(*) AS numero " + 
				"FROM parola " + 
				"WHERE nome=?";


		try {
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			if(rs.next()==true) {
				if (rs.getInt("numero")==1) {
					conn.close();
					return true;
				}
			}
		conn.close();
		
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		return false;
		
		
	}
	
	public HashSet<String> getDizionario() {
		final String sql = "SELECT nome " + 
				"FROM parola ";


		try {
			HashSet<String> dizionario = new HashSet<String>();
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()==true) {
				dizionario.add(rs.getString("nome"));	
				}
		conn.close();
		return dizionario;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
		
	}

}
