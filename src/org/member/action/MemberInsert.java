package org.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.MemberDAO;
import com.member.MemberDTO;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/Blog/memInsert.pr")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher rd=request.getRequestDispatcher("congratulationMsg.jsp");
	rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 request.setCharacterEncoding("utf-8");
		 String email=request.getParameter("email");
		 String pwd=request.getParameter("pwd");
		 String nickname=request.getParameter("nickname");
	     MemberDTO dto =new MemberDTO();
		 MemberDAO dao = MemberDAO.getInstance();
	
		 dto.setEmail(email);
		 dto.setPwd(pwd);
		 dto.setNickname(nickname);
		 dao.memInsert(dto);
		 response.sendRedirect("congratulationMsg.jsp");
	
		 
	
	}

}
