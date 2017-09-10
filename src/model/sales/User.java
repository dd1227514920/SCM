package model.sales;

public class User {
	private String username;
	private String password;
	private String name;
	private String createDate;
	private String status;
	private String auth;

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String name, String createDate, String status,
			String auth) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.createDate = createDate;
		this.status = status;
		this.auth = auth;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getStatus() {
		return status;
	}

	public String getAuth() {
		return auth;
	}

}
