package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnagrammaDAO {

	public boolean isCorrect(String Anagramma) {

		final String sql = "SELECT * FROM parola WHERE nome=?";

		try {
			Connection conn = DBconnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, Anagramma);
			
			List<String> anagrammi = new ArrayList<String>();

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				anagrammi.add(new String(rs.getString("nome")));
			}

			conn.close();
			if(anagrammi.size()==1)
				return true;
			return false;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore DB", e);
		}
	}
	
}
