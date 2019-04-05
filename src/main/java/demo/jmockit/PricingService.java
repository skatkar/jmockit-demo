package demo.jmockit;

import java.util.List;
import java.util.Map;

public interface PricingService {

	public Map<Long,Double> price(List<Long> skus);

}
