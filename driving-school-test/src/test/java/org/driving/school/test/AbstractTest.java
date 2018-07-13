package org.driving.school.test;

import org.driving.school.startup.Main;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 
 * @author pengcheng.yang
 * @desc JUnit测试父类
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class AbstractTest {
	static {
		System.out.println("******单元测试启动******");
	}
}
