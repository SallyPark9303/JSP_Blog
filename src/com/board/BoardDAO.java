package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BoardDAO {
	
	//디비설정
	private static BoardDAO instance;

	public static BoardDAO getInstance() {
		if(instance==null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	private Connection getConnection() throws Exception{ // db연동
		Context initCtx=new InitialContext();
		Context envCtx=(Context) initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();	
	
}
	
	//추가
	public void boardInsert(BoardDTO dto) {
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		String sql="";
		int number=0;
		//부모글
		int num= dto.getNum();
		int ref= dto.getRef();
		int re_step= dto.getRe_step();
		int re_level =dto.getRe_level();
		try {
			con=getConnection();
			ps=con.prepareStatement("select max(num) from bboard");
			rs=ps.executeQuery();
			if(rs.next()) {
				number=rs.getInt(1)+1;
			}else {
				number=1;
			}
			if(num!=0) {//답변글
				sql="update bboard set re_step=re_step+1 where ref=? and re_step>?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, ref);
			ps.setInt(2, re_step);
			ps.executeUpdate();
			re_step = re_step+1;
			re_level =re_level +1;
			}else {//새글
				ref=number;
				re_step=0;
				re_level=0;
			}
				
			
		
			sql="insert into "
					+ "bboard(num, writer, title, description, filename,"
					+ "readcount, reg_date, ref, re_step, re_level)"
					+ "values(bboard_seq.nextval,?,?,?,?,0,to_char(sysdate,'yyyy/mm/dd'),?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getDescription());
		ps.setString(4, dto.getFilename());
	//	ps.setInt(5, dto.getReadcount());
		ps.setInt(5, dto.getRef());
		ps.setInt(6, dto.getRe_step());
		ps.setInt(7, dto.getRe_level());
			ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();			
		}finally {
			closeConnection(con,ps);
		}
	}
	
	//전체보기
	
	public ArrayList<BoardDTO> postList() {
		Connection con=null;
		Statement st=null;
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
		ResultSet rs=null;

		try{
			con=getConnection();
			String sql="select * from bboard";

			st= con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO bo= new BoardDTO();
				bo.setNum(rs.getInt("num"));
				bo.setTitle(rs.getString("title"));
				bo.setDescription(rs.getString("description"));
				bo.setFilename(rs.getString("filename"));
			    bo.setWriter(rs.getString("writer"));
				arr.add(bo);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		} return arr;
	}
	
	//comment 추가
	public void commentInsert(CommentVO cvo) {
		Connection con = null;
		PreparedStatement ps =null;
		try {
		con=getConnection();
		//cnum,name,regdate,msg,bnum
		String sql="insert into BCOMMENT values(bcomment_seq.nextval,?,sysdate,?,?)";
		System.out.println(sql);
		ps=con.prepareStatement(sql);
		ps.setString(1,cvo.getName());
		ps.setString(2,cvo.getMsg());
		ps.setInt(3,cvo.getBnum());
		ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
	}
	
}
	
	

	public ArrayList<CommentVO> commentList(int bnum) {
		Connection con=null;
		Statement st=null;
		ArrayList<CommentVO> arr = new ArrayList<CommentVO>();
		ResultSet rs=null;
		
		try {
			
			con=getConnection();
			String sql="select * from bcomment where bnum="+bnum+" order by cnum desc";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				CommentVO cvo = new CommentVO();
				cvo.setBnum(rs.getInt("bnum"));
				cvo.setCnum(rs.getInt("cnum"));
				cvo.setMsg(rs.getString("msg"));
				cvo.setRegdate(rs.getString("regdate"));
				cvo.setName(rs.getString("name"));
				arr.add(cvo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,st);
	}
		return arr;				
		}
	
	
	
	public ArrayList<BoardDTO> getPostList(String word) {
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> arr= new ArrayList<BoardDTO>();
	
		try{
			con = getConnection();
	//검색
			String	sql=  "select * from bboard where title like '%"+word+"%'";
			st = con.prepareStatement(sql);			
			rs = st.executeQuery(sql);
			while(rs.next()) 
			{
				BoardDTO bo=new BoardDTO();
                   bo.setNum(rs.getInt("num"));
                   bo.setWriter(rs.getString("writer"));
                   bo.setTitle(rs.getString("title"));
                   bo.setDescription(rs.getString("description"));
                   bo.setReg_date(rs.getString("reg_date"));
                   arr.add(bo);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return arr;
		
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
