package org.member.action;

import java.io.IOException;

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
 * Servlet implementation class MemberView
 */
@WebServlet("/Blog/memView.pr")
public class MemberView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO)session.getAttribute("sessDto");
		String email=dto.getEmail();
		MemberDAO dao =MemberDAO.getInstance();
		MemberDTO mdto=dao.memDetail(email);
		request.setAttribute("mdto", mdto);
		RequestDispatcher rd = request.getRequestDispatcher("MemberDetail.jsp"); 
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
