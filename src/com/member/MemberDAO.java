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

	
	
	//�����
	private static MemberDAO instance;

	public static MemberDAO getInstance() {
		if(instance==null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	private Connection getConnection() throws Exception{ // db����
		Context initCtx=new InitialContext();
		Context envCtx=(Context) initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();	
	
}
	//�α��� üũ
	public MemberDTO loginCheck(String email, String pwd) {
		Connection con= null;
		Statement st = null;
		ResultSet rs = null;
	
		MemberDTO dto =null; //ȸ���� �ƴ�
		try {
			con = getConnection();
			String sql = "select * from blog where email='"+email+"'"; //pwd�� ����
			st = con.createStatement();
			rs =st.executeQuery(sql);
			if(rs.next()) {//ȸ���ε� ����� �´��� ��//rs�� �ִٸ� ȸ���̶�� ��, ȸ������ ������� ����
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
	
	//ȸ������
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
	
	//������-ȸ�����
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
	
	
	//����
	public void memDelete(String email) {
		Connection con = null;
		Statement st= null;
		try {
			con=getConnection();
			String sql="delete from blog where email='"+email+"'"; //���ڿ��̱� ������ Ȫ����ǥ �ʿ�
			st=con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,st);
		}			
	}
	
	// ����������Ʈ
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
	
		flag= ps.executeUpdate();//���������� ó���Ǹ� 1 ����
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}
			return flag;
		
	}
	//��������
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

	

	
	//����޼���
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

	//����޼���
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
