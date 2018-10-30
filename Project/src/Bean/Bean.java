package Bean;

import java.io.Serializable;
import java.sql.Date;

public class Bean implements Serializable{
	private int id;
	private String login_id;
	private String name;
	private Date  birth_date;
	public Bean(){}
	public Bean(int id,String login_id,String name,Date birth_date){
		this.name = name;
		this.birth_date= birth_date;
		this.login_id = login_id;
		this.id= id;
	}
	public Bean(int id,String name,Date birth_date){
		this.name = name;
		this.id=id;
		this.birth_date = birth_date;
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
	public Date getbirth_date() {
		return  birth_date;
	}
	public void setbirth_date(Date birth_date) {
		this.birth_date =  birth_date;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}


}
