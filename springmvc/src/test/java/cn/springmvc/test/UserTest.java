package cn.springmvc.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;

public class UserTest {
	public static Log log = LogFactory.getLog(UserTest.class);

	private UserService userService;

	@Before
	public void before() {
		log.debug("UserTest before");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring.xml",
						"classpath:conf/spring-mybatis.xml" });
		userService = (UserService) context.getBean("userServiceImpl");
	}

	@Test
	public void addUser() {
		log.debug("UserTest addUser");
		User user = new User();
		user.setNickname("ddddddddd");
		user.setState(2);
		System.out.println(userService.insertUser(user));
	}
}
