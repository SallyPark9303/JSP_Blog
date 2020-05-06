package org.board.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.BoardDAO;
import com.board.BoardDTO;
import com.member.MemberDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class boardwriter
 */
@WebServlet("/Blog/create.pr")
public class postAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String savePath="upload";
		int uploadFileSize=5*1024*1024;
		String encType="UTF-8";
		ServletContext context= getServletContext();
		String uploadFilePath=context.getRealPath(savePath);
		System.out.println("uploadFilePath:"+uploadFilePath);
		
		MultipartRequest multi = new MultipartRequest(
				request,
				uploadFilePath,
				uploadFileSize,
				encType,
				new DefaultFileRenamePolicy()	
				);
		String fileName= multi.getFilesystemName("profile_image");
		System.out.println("fileName :"  + fileName);
        String  title=multi.getParameter("title");
        String description=multi.getParameter("description");
        HttpSession session = request.getSession();
        MemberDTO sdto = (MemberDTO)session.getAttribute("sessDto");
				
	    BoardDTO dto = new BoardDTO();
	    dto.setDescription(description);
	    dto.setFilename(fileName);
	    dto.setTitle(title);
	    dto.setWriter(sdto.getNickname());
		BoardDAO dao =BoardDAO.getInstance();
	    dao.boardInsert(dto);
		
		response.sendRedirect("postList.pr");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
