package com.tgb.container.client;

import com.tgb.container.BeanFactory;
import com.tgb.container.ClassPathXmlApplicationContext;
import com.tgb.container.service.Service;

public class Client {
	public static void main(String[] args) throws Exception {
		//加载配置文件
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml","test");
		Service service = (Service) factory.getBean("service");
		service.serviceMethod();

	}
}
