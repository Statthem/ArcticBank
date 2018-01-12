package webapp.arcticbank.currencies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {

	String USD;
	String EUR;
	String UAH;
	String RUB;
	String CNY;
	String JPY;
	String GBP;

	public String getUSD() {
		return USD;
	}

	public void setUSD(String uSD) {
		USD = uSD;
	}

	public String getEUR() {
		return EUR;
	}

	public String getUAH() {
		return UAH;
	}

	public String getRUB() {
		return RUB;
	}

	public String getCNY() {
		return CNY;
	}

	public String getJPY() {
		return JPY;
	}

	public String getGBP() {
		return GBP;
	}

	public void setEUR(String eUR) {
		EUR = eUR;
	}

	public void setUAH(String uAH) {
		UAH = uAH;
	}

	public void setRUB(String rUB) {
		RUB = rUB;
	}

	public void setCNY(String cNY) {
		CNY = cNY;
	}

	public void setJPY(String jPY) {
		JPY = jPY;
	}

	public void setGBP(String gBP) {
		GBP = gBP;
	}
}
