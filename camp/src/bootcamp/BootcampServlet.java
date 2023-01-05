package bootcamp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bootcamp")
public class BootcampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BootcampServlet() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		BootcampDAO dao = new BootcampDAO();
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
			List<BootcampVO> list = dao.search(keyword);
			if (list != null && list.size() == 0) {
				request.setAttribute("msg", keyword + "의 대한 정보가 없습니다.");
			} else {
				request.setAttribute("list", dao.search(keyword));
			}
		}
		request.getRequestDispatcher("/bootcamp/bootcamps.jsp").forward(request, response);
	}
/*
 *  private String b_name;	// 부트캠프 이름
	private String a_name;	// 학원이 름
	private String rogo;	// 학원로고
	private String realimg;	// 실제 학원이미지
	private String site; // 사이트 링크
	private int m_id; // 회원 id
	
 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String b_name = request.getParameter("b_name");
		String a_name = request.getParameter("a_name");
		String rogo = request.getParameter("rogo");
		String realimg = request.getParameter("realimg");
		String site = request.getParameter("site");
		String m_id = request.getParameter("m_id");
		BootcampDAO dao = new BootcampDAO();
		BootcampVO vo = new BootcampVO();
		vo.setB_name(b_name);
		vo.setA_name(a_name);
		vo.setRogo(rogo);
		vo.setRealimg(realimg);
		vo.setSite(site);
		vo.setM_id(Integer.parseInt(m_id));
		if(action == "insert") {
			boolean result = dao.insert(vo);
			if (result) {			
				request.setAttribute("msg", "성공적으로 등록되었습니다.");			
			} else {
				request.setAttribute("msg", "등록되지 않았습니다.");
			}
		} else {
			boolean result = dao.update(vo);
			if (result) {			
				request.setAttribute("msg", "성공적으로 수정되었습니다.");			
			} else {
				request.setAttribute("msg", "수정되지 않았습니다.");
			}
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/bootcamp/bootcamps.jsp").forward(request, response);
	}

}
