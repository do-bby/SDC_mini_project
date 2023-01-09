package member;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import member.MemberVO;
import db.ConnectDB;

public class MemberDAO {
	//회원가입 정보 저장
	public boolean insertM(MemberVO vo) {
		Connection conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO members VALUES(membersseq.NEXTVAL,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getid());
			pstmt.setString(2,vo.getpwd());
			pstmt.setString(3,vo.getname());
			pstmt.setString(4,vo.getemail());
			pstmt.setInt(5,vo.getpnum());
			pstmt.setString(6,vo.getnname());
			pstmt.executeUpdate();
			return true;
		} catch(SQLException e) {
			System.err.println("회원정보 insert과정에서 오류 발생"+e);
			return false;
		}finally {
			close(pstmt,null,conn);
		}
	}
	
	//close 함수
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
	
	//id중복 확인
	 public boolean duplicateIdCheck(String id)
	    {
		 	Connection conn = ConnectDB.connect();
	        PreparedStatement pstm = null;
	        ResultSet rs = null;

	        try {
	            // 쿼리
	            StringBuffer query = new StringBuffer();
	            query.append("SELECT ID FROM members WHERE ID=?");
	                        
	            pstm = conn.prepareStatement(query.toString());
	            pstm.setString(1, id);
	            rs = pstm.executeQuery();
	            
	            if(rs.next()) {
	            	return true; //해당 아이디 존재
	            }else {
	            	return false;
	            }
	                
	            
	        } catch (Exception sqle) {
	            throw new RuntimeException(sqle.getMessage());
	        } finally {
	        	close(pstm,null,conn);
	        }
	    }
	 
	 public boolean duplicateNicknameCheck(String nickname)
	    {
		 	Connection conn = ConnectDB.connect();
	        PreparedStatement pstm = null;
	        ResultSet rs = null;
	        
	        try {
	            // 쿼리
	            StringBuffer query = new StringBuffer();
	            query.append("SELECT nname FROM members WHERE nname=?");
	                        
	            pstm = conn.prepareStatement(query.toString());
	            pstm.setString(1, nickname);
	            rs = pstm.executeQuery();
	            
	            if(rs.next()) {
	            	return true; //해당 아이디 존재
	            }else {
	            	return false;
	            }
	                
	            
	        } catch (Exception sqle) {
	            throw new RuntimeException(sqle.getMessage());
	        } finally {
	        	close(pstm,null,conn);
	        }
	    }
	
	 public List<MemberVO> getMember(String id){
		 List<MemberVO> list = new ArrayList<>();
		 Connection conn = ConnectDB.connect();
		 PreparedStatement pstm = null;
		 ResultSet rs = null;
		 
		 try {
			 	pstm = conn.prepareStatement("SELECT * FROM members WHERE ID=?");
			 	pstm.setString(1, id);
				 rs = pstm.executeQuery(); 
				 MemberVO vo = null;
				 while(rs.next()) {
					 vo = new MemberVO();
					 vo.setid(rs.getString("id"));
					 vo.setpwd(rs.getString("pwd"));
					 vo.setname(rs.getString("name"));
					 vo.setemail(rs.getString("email"));
					 vo.setpnum(rs.getInt("pnum"));
					 vo.setnname(rs.getString("nname"));
					 list.add(vo);
				 }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close(pstm,null,conn);
		 }
		 return list;
	 }
	 
	 public int infoUpdate(String mid, String mpwd, String mname, String memail, int mpnum, String mnname) {
		 Connection conn = ConnectDB.connect();
		 int value = 0;
			PreparedStatement pstmt = null;
			try {
				String sql = "UPDATE members SET id=?, pwd=?, name=?, email=?, pnum=?, nname=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,mid);
				pstmt.setString(2,mpwd);
				pstmt.setString(3,mname);
				pstmt.setString(4,memail);
				pstmt.setInt(5,mpnum);
				pstmt.setString(6,mnname);
				pstmt.executeUpdate();
			} catch(SQLException e) {
				System.err.println("회원정보 수정 과정에서 오류 발생"+e);
			}finally {
				close(pstmt,null,conn);
			}
			return value;
		}
	 }

