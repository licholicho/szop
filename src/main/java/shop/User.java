package shop;


public class User {


	private int id;
	String name;
	String surname;
	String login;
	String password;
	String email;
	
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public User(String login, String password, int id) {
		super();
		this.login = login;
		this.password = password;
		this.id = id;
	}
	
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}

