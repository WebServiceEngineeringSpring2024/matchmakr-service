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
	private String language;
	private String city;
	private String state;
	private String country;
	private Integer personality;
	private Timestamp created;
	private Timestamp updated;
	
	//@Column(name = "id") // hibernate can pickup on this automatically, but if name differs from db table, must use tag
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
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public Boolean getOnline() {
		return online;
	}
	
	public void setOnline(Boolean online) {
		this.online = online;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Integer getPersonality() {
		return personality;
	}
	
	public void setPersonality(Integer personality) {
		this.personality = personality;
	}
	
	public Timestamp getCreated() {
		return created;
	}
	
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	public Timestamp getUpdated() {
		return updated;
	}
	
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
		
}