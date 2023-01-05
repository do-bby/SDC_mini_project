package review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bootcamp.BootcampDAO;
import bootcamp.BootcampVO;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ReviewServlet() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		ReviewDAO dao = new ReviewDAO();
		if(keyword == null) {
			if(action != null && action.equals("delete")) {
				boolean result = dao.delete(Integer.parseInt(id));
				if (result) {
					request.setAttribute("msg", "의 대한 정보가 성공적으로 삭제되었습니다.");
				} else {
					request.setAttribute("msg", "의 대한 정보가 삭제되지 않았습니다.");
				}				
			}
		}
		else {
			
		}
		request.getRequestDispatcher("/review/reviews.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
