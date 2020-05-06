package com.member;

public class MemberDTO {
 private int num;
 private String email;
 private String pwd;
 private int admin;
 private String nickname;
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getEmail() {
	return email == null ? "" : email.trim();
}
public void setEmail(String email) {
	this.email = email;
}
public String getPwd() {
	return pwd == null ? "" : pwd.trim();
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public int getAdmin() {
	return admin ;
}
public void setAdmin(int admin) {
	this.admin = admin;
}
public String getNickname() {
	return nickname == null ? "" : nickname.trim();
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}

 
 
	

}
