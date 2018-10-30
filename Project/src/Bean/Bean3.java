package Bean;

import java.io.Serializable;

public class Bean3 implements Serializable{
	private int id;
	private String login_id;
	private String password;
	private String name;
	private String  birth_date;



	public Bean3(){}
	public Bean3(int id,String login_id,String password,String name,String birth_date){
		this.id = id;
		this.login_id = login_id;
		this.password = password;
		this.name = name;
		this.birth_date= birth_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
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
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}


}
