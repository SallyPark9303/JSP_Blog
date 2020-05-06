package org.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.MemberDAO;
import com.member.MemberDTO;


/**
 * Servlet implementation class MemberUpdate
 */
@WebServlet("/Blog/memUpdate.pr")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		MemberDTO dto=new MemberDTO();
		
		dto.setEmail(request.getParameter("email"));
		dto.setNickname(request.getParameter("nickname"));
		dto.setPwd(request.getParameter("pwd"));
		MemberDAO dao = MemberDAO.getInstance();
		dao.memUpdate(dto);
		response.sendRedirect("logout.pr");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
