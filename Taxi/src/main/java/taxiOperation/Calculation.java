package taxiOperation;

public class Calculation {
	public double taxiBill(String kms, String car) {
	    double payableAmount = 0.0;
	    double tempkms = Double.parseDouble(kms);
	    
	    if (car.equals("mini")) {
            payableAmount = (tempkms * 25);
            payableAmount = payableAmount + (payableAmount * 0.18);
        } else if (car.equals("sedan")) { 
            payableAmount = (tempkms * 40);
            payableAmount = payableAmount + (payableAmount * 0.18);
        } else if (car.equals("prime")) { 
            payableAmount = (tempkms * 80);
            payableAmount = payableAmount + (payableAmount * 0.18);
        }
        return payableAmount;
    }

}
