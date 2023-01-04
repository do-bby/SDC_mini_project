package bootcamp;

public class BootcampVO {
	private int id;
	private String name;
	private int img;
	private String good;
	private String bad;
	private int score;
	private int t_score;
	private int s_score;
	private int e_score;
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
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
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
