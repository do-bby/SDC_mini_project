package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.ConnectDB;

public class ReviewDAO {
		//전체 리뷰 불러오기
		public List<ReviewVO> listAll(){
			Connection conn = ConnectDB.connect();
			Statement stmt = null;
			ResultSet rs = null;
			List<ReviewVO> list = new ArrayList<>();
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(
						"select rnum,goodcom,badcom,bscope,instsat,edusat,learnsat,bnum,mnum from reviews");
				ReviewVO vo = null;
				while (rs.next()) {
					vo = new ReviewVO();
					vo.setGood(rs.getString("goodcom"));
					vo.setBad(rs.getString("badcom"));
					vo.setScore(rs.getInt("bscope"));
					vo.setT_score(rs.getInt("instsat"));
					vo.setS_score(rs.getInt("edusat"));
					vo.setE_score(rs.getInt("learnsat"));
					vo.setB_id(rs.getInt("bnum"));
					vo.setM_id(rs.getInt("mnum"));
				
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.close(conn);
			}
			return list;
		}
		//특정 회원이 쓴 리뷰 불러오기
		public ReviewVO listOne(int id){
			Connection conn = ConnectDB.connect();
			Statement stmt = null;
			ResultSet rs = null;
			ReviewVO vo = null;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(
						"select rnum,goodcom,badcom,bscope,instsat,edusat,learnsat,bnum,mnum from reviews where rnum = "+id);
				while (rs.next()) {
					vo = new ReviewVO();
					vo.setId(rs.getInt("rnum"));
					vo.setGood(rs.getString("goodcom"));
					vo.setBad(rs.getString("badcom"));
					vo.setScore(rs.getInt("bscope"));
					vo.setT_score(rs.getInt("instsat"));
					vo.setS_score(rs.getInt("edusat"));
					vo.setE_score(rs.getInt("learnsat"));
					vo.setB_id(rs.getInt("bnum"));
					vo.setM_id(rs.getInt("mnum"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.close(conn);
			}
			return vo;
		}
		
		//특정 부트캠프의 리뷰 불러오기
		public List<ReviewVO> TheBootcampList(int bnum){
			Connection conn = ConnectDB.connect();
			Statement stmt = null;
			ResultSet rs = null;
			ReviewVO vo = null;
			List<ReviewVO> list = new ArrayList<>();
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select rnum,goodcom,badcom,bscope,instsat,edusat,learnsat,bnum,mnum from reviews"
						+ " where bnum = "+bnum);
				while (rs.next()) {
					vo = new ReviewVO();
					vo.setId(rs.getInt("rnum"));
					vo.setGood(rs.getString("goodcom"));
					vo.setBad(rs.getString("badcom"));
					vo.setScore(rs.getInt("bscope"));
					vo.setT_score(rs.getInt("instsat"));
					vo.setS_score(rs.getInt("edusat"));
					vo.setE_score(rs.getInt("learnsat"));
					vo.setB_id(rs.getInt("bnum"));
					vo.setM_id(rs.getInt("mnum"));
								
					list.add(vo);
				}
			} catch (SQLException e) {
					e.printStackTrace();
			} finally {
						ConnectDB.close(conn);
					}
			return  list;
			}
		
		//리뷰 등록하기
		public boolean insert(ReviewVO vo) {
			Connection conn = ConnectDB.connect();
			boolean result = true;
			try {
				PreparedStatement pstmt = conn.prepareStatement("insert into reviews values(reviewsseq.nextval,?,?,?,?,?,?,?,?)");
				pstmt.setString(1, vo.getGood());
				pstmt.setString(2, vo.getBad());
				pstmt.setInt(3, vo.getScore());
				pstmt.setInt(4,vo.getT_score());
				pstmt.setInt(5, vo.getS_score());
				pstmt.setInt(6, vo.getE_score());
				pstmt.setInt(7, vo.getB_id());
				pstmt.setInt(8, vo.getM_id());
				
				pstmt.executeUpdate();
				
			}catch(SQLException e) {
				result = false;
				e.printStackTrace();
			}finally {
				ConnectDB.close(conn);
			}
			return result;
		}
		
		//정보 수정
		public boolean update(ReviewVO vo) {
			Connection conn = ConnectDB.connect();
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(
						"update bootcamps set " + 
						"goodcom = ?, " + 
						"badcom = ?, " + 
						"bscope = ? " +
						"instsat = ? " +
						"edusat = ? " +
						"learnsat = ? " +
						"bnum = ? " +
						"mnum = ? " +
						"where rnum = ?");
				
				pstmt.setString(1, vo.getGood());
				pstmt.setString(2, vo.getBad());
				pstmt.setInt(3, vo.getScore());
				pstmt.setInt(4,vo.getT_score());
				pstmt.setInt(5, vo.getS_score());
				pstmt.setInt(6, vo.getE_score());
				pstmt.setInt(7, vo.getB_id());
				pstmt.setInt(8, vo.getM_id());
				pstmt.setInt(9, vo.getId());
				pstmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				System.err.println("update 과정에서 오류 발생 " + e);
				return false;
			} finally {
				ConnectDB.close(conn);
			}
		}
		
		//삭제
		public boolean delete(int id) {
			Connection conn = ConnectDB.connect();
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement("delete from reviews where rnum = " + id);
				if (pstmt.executeUpdate() != 0)
					return true;
				else
					return false;
			} catch (SQLException e) {
				System.err.println("delete 과정에서 오류 발생 " + e);
				return false;
			} finally {
				ConnectDB.close(conn);
			}
		}
}
