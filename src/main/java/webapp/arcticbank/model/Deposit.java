package webapp.arcticbank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deposits")
public class Deposit implements Serializable{
	public Deposit(){}
	
	@Id
	@Column(name="id", nullable=false, unique=true)
	private long deposit_id;
	
	@Column(name="creation_date")
	private Date creation_date;
	
	@Column(name="expiration_date")
	private Date expiration_date;
	
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name="balance")
	BigDecimal balance;

	public long getDeposit_id() {
		return deposit_id;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public User getUser() {
		return user;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setDeposit_id(long deposit_id) {
		this.deposit_id = deposit_id;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	

}
