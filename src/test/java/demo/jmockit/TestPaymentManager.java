package demo.jmockit;

import org.junit.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

/**
 * Code that demonstrates Excpetion handling test case scenario
 * 
 */

public class TestPaymentManager {

	@Tested
	private PaymentManager paymentManager;
	
	@Injectable
	private ThirdPartyPaymentService thirdPartyPaymentService;
	
	@Test(expected = PaymentFailedException.class)
	public void shouldNotMakePayment() throws PaymentFailedException {
		
		new Expectations() {{
			thirdPartyPaymentService.pay(anyInt);
			result = new PaymentFailedException();
			times = 1;
			
		}};
		
		paymentManager.pay(100);
	}
}
