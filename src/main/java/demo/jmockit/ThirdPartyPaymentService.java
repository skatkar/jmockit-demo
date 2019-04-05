package demo.jmockit;

public interface ThirdPartyPaymentService {

	boolean pay(int amount) throws PaymentFailedException;
}
