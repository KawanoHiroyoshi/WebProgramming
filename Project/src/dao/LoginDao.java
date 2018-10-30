package dao;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	/**
	 * DAOクラス.
	 *
	 * DaoFuctory
	 */
	public class LoginDao {

	    private Connection con = null;
	    private ResultSet rs = null;
	    private PreparedStatement ps = null;

	    private final String SQL_ID = "root";
	    private final String SQL_PASS = "password";

	    /**
	     * データベースから指定されたIDとパスワードを使ってユーザ情報を検索します.
	     *
	     * @param id	ログインID
	     * @param pass パスワード
	     * @return ユーザ情報（ResultSet）
	     */
	    public ResultSet selectUser(String id, String pass) {
	        try {
	            // JDBCドライバのロード
	            // 「com.mysql.jdbc.Driver」クラス名
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // データベースと接続（本来はユーザやパスワードも別管理にしておくのが理想）
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rezodb?useUnicode=true&characterEncoding=utf8&serverTimezone=JST", "root","password");

	            // SQL文を生成
	            ps = con.prepareStatement("select * from user where login_id = ? and password = ?");

	            // 生成したSQL文の「？」の部分にIDとパスワードをセット
	            ps.setString(1, id);
	            ps.setString(2, pass);

	            // SQLを実行
	            rs = ps.executeQuery();

	        } catch (ClassNotFoundException cne) {
	            cne.printStackTrace();
	        } catch (SQLException sqle) {
	            sqle.printStackTrace();
	        }
	        return rs;
	    }

	    /**
	     * コネクションをクローズします.
	     */
	    public void close() {
	        try {
	            // データベースとの接続を解除する
	            if (con != null) {
	                con.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException sqle) {
	            // データベースとの接続解除に失敗した場合
	            sqle.printStackTrace();
	        }
	    }
	}


