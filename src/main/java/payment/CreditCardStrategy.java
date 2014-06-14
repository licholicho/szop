package payment;

public class CreditCardStrategy implements PaymentStrategy{

	 	private String name;
	    private String cardNumber;
	    private String cvv;
	    private String dateOfExpiry;
	     
	    public CreditCardStrategy() {}
	    
	    public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
	        this.name=nm;
	        this.cardNumber=ccNum;
	        this.cvv=cvv;
	        this.dateOfExpiry=expiryDate;
	    }

	    public String pay(double amount) {
	        return amount +" zaplacono karta kredytowa.";
	    }
	 


}
