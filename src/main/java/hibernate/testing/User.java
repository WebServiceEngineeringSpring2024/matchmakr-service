package hibernate.testing;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user") // must be used if class name differs from database table name
public class User {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String photo;
	private Boolean online;
	private char language;
	private String city;
	private char state;
	private char country;
	private Integer personality;
	private Timestamp created;
	private Timestamp updated;
	
	//@Column(name = "user_id") // hibernate can pickup on this automatically, but if name differs from db table, must use tag
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	// identical to table column name--no need to tag
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
		
}