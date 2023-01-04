package bootcamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;




public class BootcampDAO<PrepareStatement> {
	public List<BootcampVO> listAll(){
		Connection conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		List<BootcampVO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT bnum,bname,bimg,goodcom,badcom,bscope,instsat,edusat,learnsat FROM bootcams");
			BootcampVO vo = null;
			while (rs.next()) {
				vo = new BootcampVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setImg(rs.getString("img"));
				vo.setGood(rs.getString("good"));
				vo.setBad(rs.getString("bad"));
				vo.setScore(rs.getInt("score"));
				vo.setT_score(rs.getInt("t_score"));
				vo.setS_score(rs.getInt("s_score"));
				vo.setE_score(rs.getInt("e_score"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	
	
	public boolean insert(BootcampVO vo) {
		Connection conn = ConnectDB.connect();
		boolean result = true;
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into bootcams values(bootcams_seq.nextval,?,?,?,?,?,?,?,?)");
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getImg());
			pstmt.setString(4, vo.getGood());
			pstmt.setString(5,vo.getBad());
			pstmt.setInt(6, vo.getScore());
			pstmt.setInt(7, vo.getT_score());
			pstmt.setInt(8, vo.getS_score());
			pstmt.setInt(9, vo.getE_score());
			
		}catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return true;
	}
	
	
	

	
	
}
