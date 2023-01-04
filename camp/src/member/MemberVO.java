package member;

public class MemberVO {
	private int mnum;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private int pnum;
	private String nname;


public void setid(String id) {
	this.id = id;
}

public String getid() {
	return id;
}

public void setpwd(String pwd) {
	this.pwd = pwd;
}

public String getpwd() {
	return pwd;
}
public void setname(String name) {
	this.name = name;
}

public String getname() {
	return name;
}

public void setemail(String email) {
	this.email = email;
}

public String getemail() {
	return email;
}
public void setpnum(int pnum) {
	this.pnum = pnum;
}

public int getpnum() {
	return pnum;
}
public void setnname(String nname) {
	this.nname = nname;
}

public String getnname() {
	return nname;
	}
}
