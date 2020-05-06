package org.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.BoardDAO;
import com.board.BoardDTO;
import com.board.CommentVO;
import com.member.MemberDTO;

/**
 * Servlet implementation class commentInsert
 */
@WebServlet("/Blog/commentInsert.pr")
public class commentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String msg=request.getParameter("msg");
		int bnum=Integer.parseInt(request.getParameter("num"));
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");
		
		
			
		MemberDTO sdto = (MemberDTO)session.getAttribute("sessDto");
		
		CommentVO cvo = new CommentVO();
		cvo.setMsg(msg);
		cvo.setName(sdto.getNickname());
		cvo.setBnum(bnum);
		
		BoardDAO dao =BoardDAO.getInstance();
		dao.commentInsert(cvo);
        response.sendRedirect("commentList.pr?num="+bnum);		
		
		
		
	

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
