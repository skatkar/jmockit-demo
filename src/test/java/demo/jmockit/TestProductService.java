package demo.jmockit;

/**
 * Code that demonstrates @Tested and @Injectable annotations
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class TestProductService {

	@Tested
	private ProductService productService;
	
	@Injectable
	private SearchService searchService;
	
	@Injectable
	private PricingService pricingService;
	
	List<Product> products;
	
	private Map<Long,Double> priceMap;
	
	@Before
	public void setup() {
		products = new ArrayList<Product>();
		
		Product p1 = new Product();
		p1.setSku(1L);
		
		Product p2 = new Product();
		p2.setSku(2L);
		
		products.add(p1);
		products.add(p2);
		
		priceMap = new HashMap<Long, Double>();
		priceMap.put(1L, 12.23);
		priceMap.put(2L, 32.23);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldFindProducts() {
		
		new Expectations() {{
			searchService.search("Java threading");
			returns(products);
			times = 1;
			
			pricingService.price((List<Long>) any);
			returns(priceMap);
			times = 1;
		}};
		
		List<Product> products = productService.find("Java threading");
		assertEquals(2, products.size());
		
		Product product = products.get(0);
		assertEquals(1L,product.getSku());
		assertEquals(12.23, product.getPrice(),0);
	}
}
