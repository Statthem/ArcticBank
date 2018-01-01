package webapp.arcticbank.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users") 
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="first_name", length=30, nullable=false)
	private String first_name;
	
	@Column(name="second_name",  length=30, nullable=false)
	private String second_name;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="user_password", nullable=false)
	private String user_password;
	
	@Column(name="post_index", nullable=false)
	private String post_index;
	
	@Column(name="date_of_birthday", nullable=false)
	private Date date_of_birthday;
	
	@Column(name="country", nullable=true)
	private String country;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 @JoinTable(name = "user_cards", joinColumns = {@JoinColumn(name = "user_id")}, 
     inverseJoinColumns = {@JoinColumn(name = "card_id")})
	private Set<CreditCard> credit_cards;	

	public int getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public String getEmail() {
		return email;
	}

	public String getUser_password() {
		return user_password;
	}

	public String getPost_index() {
		return post_index;
	}

	public Date getDate_of_birthday() {
		return date_of_birthday;
	}

	public String getCountry() {
		return country;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public void setPost_index(String post_index) {
		this.post_index = post_index;
	}

	public void setDate_of_birthday(Date date_of_birthday) {
		this.date_of_birthday = date_of_birthday;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<CreditCard> getCredit_cards() {
		return credit_cards;
	}

	public void setCredit_cards(Set<CreditCard> credit_cards) {
		this.credit_cards = credit_cards;
	}

	
	
}
