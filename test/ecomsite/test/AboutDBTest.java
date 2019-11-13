package ecomsite.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		JdbcTemplate jdbc = new JdbcTemplate(ds);
		jdbc.execute("delete from about");
	}

	@Test
	public void testMethod() {
		
		//create
		/*List<AboutModel> ams = new ArrayList<AboutModel>();
		AboutModel am1 = new AboutModel("Test data1", "test description 1", "01-12-2019", 45);
		AboutModel am2 = new AboutModel("Test data2", "test description 2", "02-12-2019", 46);
		AboutModel am3 = new AboutModel("Test data3", "test description 3", "03-12-2019", 47);
		AboutModel am4 = new AboutModel("Test data4", "test description 4", "04-12-2019", 48);
		AboutModel am5 = new AboutModel("Test data5", "test description 5", "05-12-2019", 49);
		ams.add(am1); ams.add(am2); ams.add(am3); ams.add(am4); ams.add(am5);
		
		assertEquals("create should return 5", 5, about.createAbout(ams).length);
*/
		
		
		//retrieve
		List<AboutModel> am = about.getModels();
		assertEquals("Test from UserDBTest", 5, am.size());
		assertEquals("test",1,1);
		
	}
	

}
