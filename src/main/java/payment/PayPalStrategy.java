package payment;

public class PayPalStrategy implements PaymentStrategy {

	  private String email;
	    private String password;
	     
	    public PayPalStrategy() {}
	    
	    public PayPalStrategy(String email, String pwd){
	        this.email=email;
	        this.password=pwd;
	    }
	     
	    public String pay(double amount) {
	        return amount + " zaplacono za pomoca Paypal.";
	    }
}
