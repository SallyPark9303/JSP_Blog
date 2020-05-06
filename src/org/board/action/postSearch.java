package org.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.BoardDAO;
import com.board.BoardDTO;

/**
 * Servlet implementation class postSearch
 */
@WebServlet("/Blog/postsearch.do")
public class postSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.setCharacterEncoding("utf-8");
	BoardDAO dao= BoardDAO.getInstance();		
   
	String word = request.getParameter("word");		
	
	ArrayList<BoardDTO> arr = dao.getPostList(word);	
	request.setAttribute("arrList", arr);
	
	RequestDispatcher rd = request.getRequestDispatcher("SeaerchBoard.jsp");
    rd.forward(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
