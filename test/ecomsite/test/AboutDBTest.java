package ecomsite.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ecomsite.java.dbmodels.AboutModel;
import ecomsite.java.services.AboutService;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:/ecomsite/xml/beans/dao_bean.xml",
		"classpath:/ecomsite/xml/beans/security_bean.xml",
		"classpath:/ecomsite/xml/beans/service_bean.xml",
		"classpath:/ecomsite/config/dao_bean_test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AboutDBTest {

	@Autowired
	DataSource ds;
	@Autowired
	AboutService about;
	
	@Before
	public void init() {
		//JdbcTemplate jdbc = new JdbcTemplate(ds);
		//jdbc.execute("delete from about where _id = 38");
	}

	@Test
	public void testMethod() {
		List<AboutModel> am = about.getModels();
		assertEquals("Test from UserDBTest", 5, am.size());
		
	}

}
