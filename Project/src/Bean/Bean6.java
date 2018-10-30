package Bean;

public class Bean6 {
	private int id;
	private String login_id;
	private String name;
	private String  birth_date;
	public Bean6(){}
	public Bean6(int id,String login_id,String name,String birth_date){
		this.id = id;
		this.login_id = login_id;
		this.name = name;
		this.birth_date= birth_date;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
