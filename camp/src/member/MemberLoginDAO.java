package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.MemberVO;
import db.ConnectDB;

public class MemberLoginDAO {
	
	//로그인
	public boolean selectLogin(MemberVO vo) {
		Connection conn = ConnectDB.connect(); //db연결
		PreparedStatement pstmt = null; //? 형식으로 쿼리문 작성가능, sql 인젝션 방어
		ResultSet rs = null;
		
		boolean result = false;//초기에는 false로 로그인시 true로 변경
		String id = vo.getid();
		String pwd = vo.getpwd();
		
		try {
			pstmt = conn.prepareStatement(
					"select decode(count(*), 1, 'true', 'false') as result "
				    + "from members "
				    + "where id= ? "
				    + "and pwd= ? "
					);
			pstmt.setString(1, id); //첫번째 물음표에 id 값으로 바꿈
			pstmt.setString(2, pwd); //두번째 물음표에 pwd 값으로 바꿈
			rs = pstmt.executeQuery(); //DB에 쿼리를 전송하고 결과값을 받는다
			
			rs.next();	//커서를 첫 번째 레코드에 위치한다. 호출 안하면 값을 안갖고오나봄
			
			//'result'라는 레코드의  값을 boolean으로 변환
			result = Boolean.parseBoolean(rs.getString("result"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		
		return result;
	}
	
	//비밀번호 찾기
	public String selectPwd(MemberVO vo) {
		Connection conn = ConnectDB.connect(); //db연결
		PreparedStatement pstmt = null; //? 형식으로 쿼리문 작성가능, sql 인젝션 방어
		ResultSet rs = null;
		
		String id = vo.getid();
		String pwd = null;
		String question = vo.getquestion();
		String answer = vo.getanswer();
		
		try {
			pstmt = conn.prepareStatement(
					" select pwd from members where id = ? and question = ? and answer = ?"
					);
			pstmt.setString(1, id);
			pstmt.setString(2, question);
			pstmt.setString(3, answer);
			rs = pstmt.executeQuery();
			rs.next(); 
			
			pwd = rs.getString("pwd");
			System.out.println(pwd);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		
		return pwd;
	}
}
