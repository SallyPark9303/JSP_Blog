package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.member.MemberDTO;

public class MemberDAO {

	
	
	//디비설정
	private static MemberDAO instance;

	public static MemberDAO getInstance() {
		if(instance==null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	private Connection getConnection() throws Exception{ // db연동
		Context initCtx=new InitialContext();
		Context envCtx=(Context) initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();	
	
}
	//로그인 체크
	public MemberDTO loginCheck(String email, String pwd) {
		Connection con= null;
		Statement st = null;
		ResultSet rs = null;
	
		MemberDTO dto =null; //회원이 아님
		try {
			con = getConnection();
			String sql = "select * from blog where email='"+email+"'"; //pwd를 구함
			st = con.createStatement();
			rs =st.executeQuery(sql);
			if(rs.next()) {//회원인데 비번이 맞는지 모름//rs가 있다면 회원이라는 뜻, 회원인지 비번오류 구분
				dto=new MemberDTO();
				if(rs.getString("pwd").equals(pwd)) {
					dto.setAdmin(rs.getInt("admin")); //1,0
					dto.setEmail(rs.getString("email"));
					dto.setPwd(rs.getString("pwd"));
					dto.setNickname(rs.getString("nickname"));
			
				}else {
					dto.setAdmin(2);
				}
			}
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return dto;
	}
	
	//회원가입
	public void memInsert(MemberDTO dto) {
		
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=getConnection();
			String sql="insert into blog values(?,?,0,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getNickname());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}
		
		
	}
	
	//관리자-회원목록
	public ArrayList<MemberDTO> memList() {
		
		Connection con=null;
		Statement st=null;
		ArrayList<MemberDTO> arr= new ArrayList<MemberDTO>();
		ResultSet rs=null;
		
		try{
			con=getConnection();
			String sql="select * from blog";

			st= con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				MemberDTO bl= new MemberDTO();
				bl.setEmail(rs.getString("email"));
				bl.setAdmin(rs.getInt("admin"));
				bl.setNickname(rs.getString("nickname"));

				arr.add(bl);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		} return arr;
	}
	
	
	//삭제
	public void memDelete(String email) {
		Connection con = null;
		Statement st= null;
		try {
			con=getConnection();
			String sql="delete from blog where email='"+email+"'"; //문자열이기 때문에 홋따움표 필요
			st=con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,st);
		}			
	}
	
	// 정보업데이트
	public int memUpdate(MemberDTO dto) {
		Connection con =null;
		PreparedStatement ps =null;
		int flag=0;
		
		
		try {
			con=getConnection();
			String sql="update blog set pwd=?, nickname=? where email=?"; 
		ps=con.prepareStatement(sql);
	
		ps.setString(1, dto.getPwd());
		ps.setString(2, dto.getNickname());
		ps.setString(3, dto.getEmail());
	
		flag= ps.executeUpdate();//정상적으로 처리되면 1 리턴
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}
			return flag;
		
	}
	//정보보기
	public MemberDTO memDetail(String email) {
		Connection con=null;
		Statement st=null;
		MemberDTO mdto=null;
		ResultSet rs=null;

		try {
			con=getConnection();
		String sql="select * from blog where email='"+email+"'"; 
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				 mdto= new MemberDTO();
				 mdto.setEmail(rs.getString("email"));
				 mdto.setNickname(rs.getString("nickname"));			   
				 mdto.setPwd(rs.getString("pwd")); 
			}

		
		} catch (Exception e) {
	
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		} 
		
		return mdto;
	}

	

	
	//종료메서드
	private void closeConnection(Connection con, PreparedStatement ps) {

		try {
			if(con!=null)
				con.close();
			if(ps!=null)
				ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void closeConnection(Connection con, Statement st, ResultSet rs) {

		try {
			if(con!=null)
				con.close();
			if(st!=null)
				st.close();
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//종료메서드
	private void closeConnection(Connection con, Statement st) {

		try {
			if(con!=null)
				con.close();
			if(st!=null)
				st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
