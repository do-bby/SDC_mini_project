package bootcamp;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;

public class BootcampDAO {
	//전체 리스트 불러오기
	public List<BootcampVO> listAll(){
		Connection conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		List<BootcampVO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select bnum,bprogram,bacademy,rogo,realimg,url,mnum,adress from bootcamps");
			BootcampVO vo = null;
			while (rs.next()) {
				vo = new BootcampVO();
				vo.setId(rs.getInt("bnum"));
				vo.setB_name(rs.getString("bprogram"));
				vo.setA_name(rs.getString("bacademy"));
				vo.setRogo(rs.getString("rogo"));
				vo.setRealimg(rs.getString("realimg"));
				vo.setSite(rs.getString("url"));
				vo.setM_id(rs.getInt("mnum"));
				vo.setAddress(rs.getString("adress"));
			
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	//선택된 부트캠프 하나에 대한 정보 불러오기
	public BootcampVO listOne(int id){
		Connection conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		BootcampVO vo = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select bnum,bprogram,bacademy,rogo,realimg,url,mnum,adress from bootcamps where bnum = "+id);
			while (rs.next()) {
				vo = new BootcampVO();
				vo.setId(rs.getInt("bnum"));
				vo.setB_name(rs.getString("bprogram"));
				vo.setA_name(rs.getString("bacademy"));
				vo.setRogo(rs.getString("rogo"));
				vo.setRealimg(rs.getString("realimg"));
				vo.setSite(rs.getString("url"));
				vo.setM_id(rs.getInt("mnum"));
				vo.setAddress(rs.getString("adress"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return vo;
	}
	
	//부트캠프과정명 or 학원명으로 찾기
	public List<BootcampVO> search(String name) {
		Connection conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		BootcampVO vo = null;
		ResultSet rs = null;
		List<BootcampVO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(
					"select bnum,bprogram,bacademy,rogo,realimg,url,mnum from bootcamps where bprogram = ? or bacademy = ?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BootcampVO();
				vo.setId(rs.getInt("id"));
				vo.setB_name(rs.getString("b_name"));
				vo.setA_name(rs.getString("a_name"));
				vo.setRogo(rs.getString("rogo"));
				vo.setRealimg(rs.getString("realimg"));
				vo.setSite(rs.getString("site"));
				vo.setM_id(rs.getInt("m_id"));
			
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	
	//부트캠프 등록하기
	public boolean insert(BootcampVO vo) {
		Connection conn = ConnectDB.connect();
		boolean result = true;
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into bootcamps values(bootcamps_seq.nextval,?,?,?,?,?,?)");
			pstmt.setString(2, vo.getB_name());
			pstmt.setString(3, vo.getA_name());
			pstmt.setString(4, vo.getRogo());
			pstmt.setString(5,vo.getRealimg());
			pstmt.setString(6, vo.getSite());
			pstmt.setInt(7, vo.getM_id());
			
		}catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.close(conn);
		}
		return result;
	}
	
	//정보 수정
	public boolean update(BootcampVO vo) {
		Connection conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"update bootcamps set " + 
					"bprogram = ?, " + 
					"bacademy = ?, " + 
					"rogo = ? " +
					"realimg = ? " +
					"site = ? " +
					"mnum = ? " +
					"where bnum = ?");
			
			pstmt.setString(1, vo.getB_name());
			pstmt.setString(2, vo.getA_name());
			pstmt.setString(3, vo.getRogo());
			pstmt.setString(4,vo.getRealimg());
			pstmt.setString(5, vo.getSite());
			pstmt.setInt(6, vo.getM_id());
			pstmt.setInt(7, vo.getId());
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
			pstmt = conn.prepareStatement("delete from bootcamps where mnum = " + id);
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
