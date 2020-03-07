package it.polito.tdp.anagramma.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class anagrammaDAO {
	public boolean parolaEsiste(String parola) {
		final String sql = "SELECT COUNT(*) AS numero\r\n" + 
				"FROM parola\r\n" + 
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

}
