package gra;

import java.io.Serializable;

public class Gracz implements Serializable{

	private static final long serialVersionUID = 2533970080559106594L;
	private String name;
	private boolean token;
	private int id;
	
	public Gracz(){
		id = 0;
		name = "Gracz";
		token = false;
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
	public boolean getToken() {
		return token;
	}
	public void setToken(boolean token) {
		this.token = token;
	}
}
