package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bootcamp.BootcampVO;
import member.MemberVO;
import db.ConnectDB;

public class MemberLoginDAO {
	public List<MemberVO> listAll(){
		Connection conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT mnum, id, pwd, name, email, pnum, nname FROM members");
			MemberVO vo = null;
			while (rs.next()) {
				vo = new MemberVO();
				vo.setid(rs.getString("id"));
				vo.setpwd(rs.getString("pwd"));
				vo.setname(rs.getString("name"));
				vo.setemail(rs.getString("email"));
				vo.setpnum(rs.getInt("pnum"));
				vo.setnname(rs.getString("nname"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	public boolean insertMember(MemberVO vo) {
		Connection conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO members VALUES(membersseq.nextval,?,?,?,?,?,?)");

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("등록 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}
	private void close(Statement s, ResultSet r, Connection conn) {
		try {
			if (r != null)
				r.close();
			if (s != null)
				s.close();
			ConnectDB.close(conn);
		} catch (SQLException e) {
			System.err.println("객체 close 과정에서 문제 발생" + e);
		}
	}
}
