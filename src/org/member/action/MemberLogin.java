package org.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.MemberDAO;
import com.member.MemberDTO;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/Blog/login.pr")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	String email=request.getParameter("email");
	String pwd =request.getParameter("pwd");
	MemberDAO dao= MemberDAO.getInstance();
	MemberDTO dto=dao.loginCheck(email, pwd);
	int flag=-1; //회원 아님
	if(dto!=null) {//회원
	 flag=dto.getAdmin();//0,1,2
	 if(flag==0||flag==1) {
		 HttpSession session=request.getSession(); 
		 session.setAttribute("sessDto", dto);
	 }
	}response.setContentType("text/html;charset=utf-8");
     PrintWriter out=response.getWriter();
     out.println(flag);
     	
	}

}
