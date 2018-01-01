package webapp.arcticbank.model;

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
public class CreditCard {
	
	@Id
	@Column(name="card_id", nullable=false, unique=true)
	private long card_id;
	
	
	@Column(name="pin_code", nullable=false, length=4)
	private long pin_code;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 @JoinTable(name = "user_cards", joinColumns = {@JoinColumn(name = "card_id")}, 
     inverseJoinColumns = {@JoinColumn(name = "user_id")})
	private User user;
	
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

	public long getPin_code() {
		return pin_code;
	}

	public void setPin_code(long pin_code) {
		this.pin_code = pin_code;
	}

	@Override
	public String toString() {
		return "CreditCard [card_id=" + card_id + ", pin_code=" + pin_code + ", user=" + user + "]";
	}
	

}
