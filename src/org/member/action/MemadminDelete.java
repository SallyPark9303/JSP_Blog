package org.member.action;

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

import com.member.MemberDAO;
import com.member.MemberDTO;


/**
 * Servlet implementation class MemadminDelete
 */
@WebServlet("/Blog/memAdminDelete.pr")
public class MemadminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemadminDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String email=request.getParameter("email");
		MemberDAO dao = MemberDAO.getInstance();
		dao.memDelete(email);
		ArrayList<MemberDTO> arr =dao.memList();
		JSONArray jarr = new JSONArray();
		for(MemberDTO m:arr) { 

			JSONObject obj = new JSONObject();
			obj.put("email", m.getEmail());
			obj.put("nickname", m.getNickname());

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
