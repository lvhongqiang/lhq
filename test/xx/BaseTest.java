package xx; /**
 * 
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lvhongqiang
 *
 */
public class BaseTest {
	protected static ApplicationContext ctx;
	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml",
				"spring-struts.xml");
	}
}
