package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp; //이용예정
import java.util.ArrayList;//이용예정
import java.util.List;//이용예정
import member.MemberVO;
import db.ConnectDB;

public class MemberDAO {
	public boolean insertM(MemberVO vo) {
		Connection conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO members VALUES(mnum.NEXTVAL,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2,vo.getid());
			pstmt.setString(3,vo.getpwd());
			pstmt.setString(4,vo.getname());
			pstmt.setString(5,vo.getemail());
			pstmt.setInt(6,vo.getpnum());
			pstmt.setString(7,vo.getnname());
			pstmt.executeUpdate();
			return true;
		} catch(SQLException e) {
			System.err.println("회원정보 insert과정에서 오류 발생"+e);
			return false;
		}finally {
			close(pstmt,null,conn);
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
