package org.board.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.board.BoardDAO;
import com.board.CommentVO;

/**
 * Servlet implementation class commentList
 */
@WebServlet("/Blog/commentList.pr")
public class commentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		int bnum=Integer.parseInt(request.getParameter("num"));
		BoardDAO dao =BoardDAO.getInstance();
		ArrayList<CommentVO> arr=dao.commentList(bnum);
		JSONArray jarr = new JSONArray();
		for(CommentVO cv:arr) {
			JSONObject obj = new JSONObject();
			obj.put("bnum",cv.getBnum());
			obj.put("cnum",cv.getCnum());
			obj.put("msg",cv.getMsg());
			obj.put("regdate",cv.getRegdate());
			obj.put("name",cv.getName());
			jarr.add(obj);
		}
		
		response.setContentType("text/html;charset=utf-8"); //È­¸é¿¡ »Ñ¸²
		PrintWriter out =response.getWriter();
     	out.println(jarr.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
