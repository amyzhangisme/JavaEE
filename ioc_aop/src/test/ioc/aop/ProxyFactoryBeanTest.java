package test.ioc.aop;

import org.junit.Test;

import main.ioc.aop.AdvisedSupport;
import main.ioc.aop.ProxyFactoryBean;
import main.ioc.aop.TargetSource;
import main.ioc.context.ApplicationContext;
import main.ioc.context.ClassPathXmlApplicationContext;
import test.ioc.HelloWorldService;
import test.ioc.HelloWorldServiceImpl;


public class ProxyFactoryBeanTest {

	@Test
	public void testInterceptor() throws Exception {
		// --------- helloWorldService without AOP
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();

		// --------- helloWorldService with AOP
		// 1. 设置被代理对象(Joinpoint)
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldServiceImpl.class,
				HelloWorldService.class);
		advisedSupport.setTargetSource(targetSource);

		// 2. 设置拦截器(Advice)
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);

		// 3. 创建代理(Proxy)
        ProxyFactoryBean AopProxy = new ProxyFactoryBean(advisedSupport);
		HelloWorldService helloWorldServiceProxy = (HelloWorldService) AopProxy.getProxy();

		// 4. 基于AOP的调用
		helloWorldServiceProxy.helloWorld();

	}
}
