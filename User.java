package entity;

public class User {
	private int id;
	private String user_name;
	private String user_password;
	private int user_age;
	private Double sal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", user_password=" + user_password + ", user_age="
				+ user_age + ", sal=" + sal + "]";
	}
	
	public User() {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_age = user_age;
		this.sal = sal;
	}
	
	
	
	
}
