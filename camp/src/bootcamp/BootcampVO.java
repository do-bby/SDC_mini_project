package bootcamp;

import java.sql.Blob;

public class BootcampVO {
	private int id;			// 부트캠프 번호
	private String name;	// 부트캠프 이름
	private String img;		// 부트캠프 이미지
	private String good;	// 장점
	private String bad;		// 단점
	private int score;		// 총 평점
	private int t_score;	// 강사진 만족도
	private int s_score;  	// 교육지원 수준
	private int e_score;	// 학습환경 만족도
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getGood() {
		return good;
	}
	public void setGood(String good) {
		this.good = good;
	}
	public String getBad() {
		return bad;
	}
	public void setBad(String bad) {
		this.bad = bad;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getT_score() {
		return t_score;
	}
	public void setT_score(int t_score) {
		this.t_score = t_score;
	}
	public int getS_score() {
		return s_score;
	}
	public void setS_score(int s_score) {
		this.s_score = s_score;
	}
	public int getE_score() {
		return e_score;
	}
	public void setE_score(int e_score) {
		this.e_score = e_score;
	}
	@Override
	public String toString() {
		return "BootcampVO [id=" + id + ", name=" + name + ", img=" + img + 
				", good=" + good + 
				", bad=" + bad +
				", score=" + score +
				", t_score=" + t_score +
				", e_score=" + e_score +
				", s_score=" + s_score +"]";
	}
}
