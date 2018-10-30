package Servlest;

	import java.io.Serializable;

	/**
	 * ログインユーザ情報クラス.
	 */
	public class LoginUserBean implements Serializable {

	    private static final long serialVersionUID = 1L;

	    private String id;
	    private String name;


	    public LoginUserBean() {
	        this.id = "";
	        this.name = "";
	    }


	    public String getId() {
	        return this.id;
	    }


	    public void setId(String id) {
	        this.id = id;
	    }


	    public String getName() {
	        return this.name;
	    }


	    public void setName(String name) {
	        this.name = name;
	    }


	}


