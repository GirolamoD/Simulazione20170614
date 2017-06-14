package it.polito.tdp.artsmia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.artsmia.model.ArtObject;
import it.polito.tdp.artsmia.model.Exhibition;
import it.polito.tdp.artsmia.model.Pair;

public class ArtsmiaDAO {

	public List<ArtObject> listObject() {
		
		String sql = "SELECT * from objects";

		List<ArtObject> result = new ArrayList<>();

		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				result.add(new ArtObject(res.getInt("object_id"), res.getString("classification"), res.getString("continent"), 
						res.getString("country"), res.getInt("curator_approved"), res.getString("dated"), res.getString("department"), 
						res.getString("medium"), res.getString("nationality"), res.getString("object_name"), res.getInt("restricted"), 
						res.getString("rights_type"), res.getString("role"), res.getString("room"), res.getString("style"), res.getString("title")));
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Integer> getYears(){
		final String sql = "SELECT DISTINCT begin FROM exhibitions ORDER BY begin ASC";
		List<Integer> result = new ArrayList<Integer>() ;
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(res.getInt("begin")) ;
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Exhibition> getExhibitions(Integer year){
		
		final String sql = "SELECT e.exhibition_id,exhibition_department,exhibition_title,begin,end, COUNT(*) AS cnt "
						+ "	FROM exhibitions e, exhibition_objects eo WHERE begin = ? AND e.exhibition_id=eo.exhibition_id " +
							"GROUP BY e.exhibition_id";
		
		List<Exhibition> result = new ArrayList<>() ;
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, year);

			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new Exhibition(res.getInt("exhibition_id"),res.getString("exhibition_department"),
							res.getString("exhibition_title"),Year.of(res.getInt("begin")),Year.of(res.getInt("end")))) ;
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	

	
	
}
