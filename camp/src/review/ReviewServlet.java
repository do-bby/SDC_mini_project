package review;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String goodMemo = request.getParameter("goodmemo");// 장점
		String badMemo = request.getParameter("badmemo"); // 단점 
		int score = Integer.parseInt(request.getParameter("totalScore")); // 총점
		int tScore = Integer.parseInt(request.getParameter("teachScore")); // 강사진만족도
		int eScore = Integer.parseInt(request.getParameter("learnScore")); // 학습환경 만족도
		int sScore = Integer.parseInt(request.getParameter("eduScore")); // 교육지원 수준
		
		
		ReviewDAO dao = new ReviewDAO();
		if(action.equals("insert")) {
			ReviewVO vo = new ReviewVO();
			vo.setGood(goodMemo);
			vo.setBad(badMemo);
			vo.setScore(score);
			vo.setT_score(tScore);
			vo.setE_score(eScore);
			vo.setS_score(sScore);
			vo.setB_id(1);
			vo.setM_id(1);

			
			boolean result = dao.insert(vo);
			if (result)
				request.setAttribute("msg", "후기 작성이 완료되었습니다.");
			else 
				request.setAttribute("msg", "후기 작성에 실패하였습니다.");
			List<ReviewVO> list = dao.listAll();
			if (list.size() > 0)
				request.setAttribute("list", list);
		}else {
			ReviewVO vo = new ReviewVO();
			vo.setGood(goodMemo);
			vo.setBad(badMemo);
			vo.setScore(score);
			vo.setT_score(tScore);
			vo.setE_score(eScore);
			vo.setS_score(sScore);
			vo.setB_id(1);
			vo.setM_id(1);
			boolean result = dao.update(vo);
			if (result) {
				request.setAttribute("msg", "님의 글이 성공적으로 수정했어요^^");
				
			}else {
				request.setAttribute("msg", "님의 글 수정 작업을 실패했어요ㅜㅜ");
			} 
				
			List<ReviewVO> list = dao.listAll();
			if (list.size() > 0)
				request.setAttribute("list", list);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ReviewSucess.jsp");
		rd.forward(request, response);

	}


		
		
	

}
