package com.smalldogg.springcoreinflearn;

import com.smalldogg.springcoreinflearn.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringCoreInflearnApplicationTests {

	@Autowired
	OrderService orderService;

	@Test
	void contextLoads() {
	}

}
