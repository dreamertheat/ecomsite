package ecomsite.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:ecomsite/xml/beans/security_bean.xml",
		"classpath:ecomsite/xml/beans/service_bean.xml","classpath:ecomsite/config/dao_bean_test.xml" })
public class UserDBTest {
	
	@Test
	public void testMethod() {
		assertEquals("Test from UserDBTest", 1, 1);
	}
	
}
