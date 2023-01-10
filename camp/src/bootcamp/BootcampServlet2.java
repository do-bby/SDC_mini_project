package bootcamp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bootcamp2")
public class BootcampServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BootcampServlet2() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("bnum");//??
		String action = request.getParameter("action");
		System.out.println(action);
		BootcampDAO2 dao = new BootcampDAO2();
		if(keyword == null) {
			if(action != null && action.equals("delete")) {
				System.out.println(id); //null
				boolean result = dao.delete(Integer.parseInt(id));
				if (result) {
					request.setAttribute("msg", "의 대한 정보가 성공적으로 삭제되었습니다.");
				} else {
					request.setAttribute("msg", "의 대한 정보가 삭제되지 않았습니다.");
				}				
			}
			//action == null, keyword == null
			else {
				request.setAttribute("list", dao.listAll());
			}
		}
		
		else {
			List<BootcampVO2> list = dao.search(keyword);
			if (list.size() == 0) {
				request.setAttribute("msg", keyword + "의 대한 정보가 없습니다.");
			} else {
				request.setAttribute("list", dao.search(keyword));
				
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("BootCampMain.jsp");
		rd.forward(request, response);
		
	}
/*
 *  private String b_name;	// 부트캠프 이름
	private String a_name;	// 학원이름
	private String rogo;	// 학원로고
	private String realimg;	// 실제 학원이미지
	private String site; // 사이트 링크
	private int m_id; // 회원 id
	
 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String b_name = request.getParameter("bprogram");
		String a_name = request.getParameter("bacademy");
		String rogo = request.getParameter("rogo");
		String realimg = request.getParameter("realimg");
		String site = request.getParameter("site");
		String m_id = request.getParameter("mnum");
		String address = request.getParameter("address");
		BootcampDAO2 dao = new BootcampDAO2();
		if(action.equals("insert")) {
			BootcampVO2 vo = new BootcampVO2();
			vo.setB_name(b_name);
			vo.setA_name(a_name);
			vo.setRogo(rogo);
			vo.setRealimg(realimg);
			vo.setSite(site);
			vo.setM_id(Integer.parseInt("1"));
			vo.setAddress(address);
			
			boolean result = dao.insert(vo);
			if (result) {			
				request.setAttribute("msg", "성공적으로 등록되었습니다.");			
			} else {
				request.setAttribute("msg", "등록되지 않았습니다.");
			}
		} else {
			BootcampVO2 vo = new BootcampVO2();
			vo.setB_name(b_name);
			vo.setA_name(a_name);
			vo.setRogo(rogo);
			vo.setRealimg(realimg);
			vo.setSite(site);
			vo.setM_id(Integer.parseInt("1"));
			vo.setAddress("뮤");
			boolean result = dao.update(vo);
			if (result) {			
				request.setAttribute("msg", "성공적으로 수정되었습니다.");			
			} else {
				request.setAttribute("msg", "수정되지 않았습니다.");
			}
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("BootcampSucess.jsp").forward(request, response);
	}

}
