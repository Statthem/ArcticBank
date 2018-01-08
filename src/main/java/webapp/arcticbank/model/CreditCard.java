package webapp.arcticbank.model;

import java.io.Serializable;

import java.sql.Timestamp;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCard implements Serializable{
	public CreditCard(){}
	
	@Id
	@Column(name="id", nullable=false, unique=true)
	private long id;
	
	@Column(name="card_id", nullable=false, unique=true)
	private long card_id;
	
	@Column(name="creation_date")
	private Timestamp creation_date;
	
	@Column(name="pin_code", nullable=false, length=4)
	private String pin_code;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name="balance")
	BigDecimal balance;
	
	public long getCard_id(){
		return card_id;
	}
	
	public void  setCard_id(long card_id){
		this.card_id = card_id;
	}
	
	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user = user;
	}

	public String getPin_code() {
		return pin_code;
	}

	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}

	@Override
	public String toString() {
		return "CreditCard [card_id=" + card_id + ", pin_code=" + pin_code + ", user=" + user + "]";
	}

	public Timestamp getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	
	

}
