package model.purchasemodel;

public class ScmUser {
	private String account;
	private String password;
	private String name;
	private String createdate;
	private String status;
	public ScmUser(){}
	public ScmUser(String account, String password, String name,
			String createdate, String status) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.createdate = createdate;
		this.status = status;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
