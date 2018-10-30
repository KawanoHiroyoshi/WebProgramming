package Bean;

public class Bean5 {
	private String login_id;
	private String name;
	private String  birth_date;
	private String  birth_date2;
	public Bean5(){}
	public Bean5(String login_id,String name,String birth_date,String  birth_date2){
		this.login_id = login_id;
		this.name = name;
		this.birth_date= birth_date;
		this.birth_date2 = birth_date2;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getBirth_date2() {
		return birth_date2;
	}
	public void setBirth_date2(String birth_date2) {
		this.birth_date2 = birth_date2;
	}

}
