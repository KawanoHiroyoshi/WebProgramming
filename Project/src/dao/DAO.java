package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import Bean.Bean;
import Bean.Bean2;
import Bean.Bean3;
import Bean.Bean4;
import Bean.Bean5;
import Bean.Bean6;
public class DAO {
private Connection db;
  private PreparedStatement ps;
  private ResultSet rs;
  int i = 0;


  //接続共通処理
  final String SQL_ID = "root";
  final String SQL_PASS = "password";



  //切断共通処理
  private void disconnect() {
    try {
      if (rs != null) {
        rs.close();
      }
      if (ps != null) {
        ps.close();
      }
      if (db != null) {
       db.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }



  public List<Bean> findAll(){
    List<Bean> list=new ArrayList<>();
    try {
    	 Class.forName("com.mysql.cj.jdbc.Driver");

      db = DriverManager.getConnection("jdbc:mysql://localhost:3306/rezodb?useUnicode=true&characterEncoding=utf8&serverTimezone=JST", "root", "password");

      ps = db.prepareStatement("SELECT * FROM user WHERE login_id not in ('admin')");

      rs = ps.executeQuery();

      while(rs.next()){

    	int id=rs.getInt("id");

    	String login_id = rs.getString("login_id");

        String name = rs.getString("name");

        Date  birth_date = rs.getDate("birth_date");

        list.add(new Bean(id,login_id,name,birth_date));

      }

    } catch (SQLException e) {

      e.printStackTrace();

    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	}finally{

      this.disconnect();

    }
    return list;
  }

  public int insertOne(Bean2 Bean2) throws NamingException{
		try {
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}

			db = DriverManager.getConnection("jdbc:mysql://localhost:3306/rezodb?useUnicode=true&characterEncoding=utf8&serverTimezone=JST", "root", "password");
			ps=db.prepareStatement("INSERT INTO user(login_id,name,birth_date,password,create_date,update_date) VALUES(?,?,?,?,now(),now())");
			ps.setString(1, Bean2.getLogin_id());
			ps.setString(2, Bean2.getName());
			ps.setString(3, Bean2.getbirth_date());
			ps.setString(4, Bean2.getPassword());
			i = ps.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
		return i;
  }
  public Bean3 findOne(int id) throws NamingException{
	  Bean3 Bean3=null;
		try {
			 try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				}
				db = DriverManager.getConnection("jdbc:mysql://localhost:3306/rezodb?useUnicode=true&characterEncoding=utf8&serverTimezone=JST", "root", "password");
			ps=db.prepareStatement("SELECT * FROM user WHERE id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				String name = rs.getString("name");
				String login_id = rs.getString("login_id");
				String password = rs.getString("password");
				String birth_date = rs.getString("birth_date");
				Bean3 = new Bean3(id,login_id,password,name,birth_date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
		return Bean3;
	}
  public void updateOne(Bean3 Bean) throws NamingException{
		try {
			 try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				}
				db = DriverManager.getConnection("jdbc:mysql://localhost:3306/rezodb?useUnicode=true&characterEncoding=utf8&serverTimezone=JST", "root", "password");
			ps=db.prepareStatement("UPDATE user SET name=?,birth_date=?,password=?,update_date= now() WHERE id=?");
			ps.setString(1, Bean.getName());
			ps.setString(2, Bean.getBirth_date());
			ps.setString(3, Bean.getPassword());
			ps.setInt(4, Bean.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
	}
  public void updateOne2(Bean3 Bean) throws NamingException{
		try {
			 try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				}
				db = DriverManager.getConnection("jdbc:mysql://localhost:3306/rezodb?useUnicode=true&characterEncoding=utf8&serverTimezone=JST", "root", "password");
			ps=db.prepareStatement("UPDATE user SET name=?,birth_date=?,update_date= now() WHERE id=?");
			ps.setString(1, Bean.getName());
			ps.setString(2, Bean.getBirth_date());
			ps.setInt(3, Bean.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
	}
  public void deleteOne(int id) throws NamingException{
		try {
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				}
				db = DriverManager.getConnection("jdbc:mysql://localhost:3306/rezodb?useUnicode=true&characterEncoding=utf8&serverTimezone=JST", "root", "password");
			ps=db.prepareStatement("DELETE FROM user WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
	}

public Bean4 find(int id) throws NamingException{
	Bean4 Bean4=null;
	try {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			db = DriverManager.getConnection("jdbc:mysql://localhost:3306/rezodb?useUnicode=true&characterEncoding=utf8&serverTimezone=JST", "root", "password");
		ps=db.prepareStatement("SELECT * FROM user WHERE id=?");
		ps.setInt(1, id);
		rs=ps.executeQuery();
		if(rs.next()){

			String name = rs.getString("name");
			String login_id = rs.getString("login_id");
			String password = rs.getString("password");
			String birth_date = rs.getString("birth_date");
			String create_date = rs.getString("create_date");
			String update_date = rs.getString("update_date");
			String str1 =  birth_date ;
			StringBuilder builder = new StringBuilder(str1);
			int i = builder.indexOf("-");
			builder.replace(i, i + 1, "年");
			i = builder.indexOf("-");
			builder.replace(i, i + 1, "月");
			builder.append("日");
			String result = builder.toString();
			birth_date =  result;

			String str2 =  create_date ;
			StringBuilder builder2 = new StringBuilder(str2);
			int i2 = builder2.indexOf("-");
			builder2.replace(i2, i2 + 1, "年");
			i2 = builder2.indexOf("-");
			builder2.replace(i2, i2 + 1, "月");
			i2 = builder2.indexOf("");
			builder2.insert(10,"日");
			String result2 = builder2.toString();
			create_date =  result2;

			String str3 =  update_date;
			StringBuilder builder3 = new StringBuilder(str3);
			int i3 = builder3.indexOf("-");
			builder3.replace(i3, i3 + 1, "年");
			i3 = builder3.indexOf("-");
			builder3.replace(i3, i3 + 1, "月");
			i3 = builder3.indexOf("");
			builder3.insert(10,"日");
			String result3 = builder3.toString();
			update_date =  result3;





			Bean4 = new Bean4(id,login_id,password,name,birth_date,create_date,update_date);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		this.disconnect();
	}
	return Bean4;
}
public List<Bean6> retrievalOne(Bean5 Bean) throws NamingException{
	 List<Bean6> list=new ArrayList<>();
	 String SQL_retrieval = "SELECT * FROM user WHERE login_id not in ('admin')";
	try {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		 if(!(Bean.getLogin_id().equals(""))) {
			 SQL_retrieval = SQL_retrieval + ("AND login_id LIKE "+ "'" + Bean.getLogin_id() + "'");
		 }
		 if(!(Bean.getName().equals(""))) {
			 SQL_retrieval = SQL_retrieval + ("AND name LIKE " +"'" + "%" + Bean.getName() + "%"+ "'");
		 }
		 if(!(Bean.getBirth_date().equals(""))){
			 SQL_retrieval = SQL_retrieval + ("AND birth_date BETWEEN "+"'" + Bean.getBirth_date()+ "'");
			 if(!(Bean.getBirth_date2().equals(""))) {
				 SQL_retrieval = SQL_retrieval + ("AND " +"'"+ Bean.getBirth_date2()+ "'");
			 }
		 }
			 if(!(Bean.getBirth_date2().equals(""))) {
				 if(Bean.getBirth_date().equals("")){
				 SQL_retrieval = SQL_retrieval + ("AND birth_date BETWEEN " +"'"+ Bean.getBirth_date2()+ "'");
				 }
			 }

			db = DriverManager.getConnection("jdbc:mysql://localhost:3306/rezodb?useUnicode=true&characterEncoding=utf8&serverTimezone=JST", "root", "password");
			ps=db.prepareStatement(SQL_retrieval);


			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String login_id = rs.getString("login_id");
				String name = rs.getString("name");
				String birth_date = rs.getString("birth_date");
				 list.add(new Bean6(id,name,login_id,birth_date));
				}

	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		this.disconnect();
	}
	return list;



}

}



