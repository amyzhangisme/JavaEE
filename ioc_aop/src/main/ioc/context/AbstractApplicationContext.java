package main.ioc.context;

import main.ioc.beans.BeanPostProcessor;
import main.ioc.beans.factory.AbstractBeanFactory;

import java.util.List;


public abstract class AbstractApplicationContext implements ApplicationContext {
	protected AbstractBeanFactory beanFactory;

	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public void refresh() throws Exception {
		//加载bean
		loadBeanDefinitions(beanFactory);
		//注册之前，干点什么事情
		registerBeanPostProcessors(beanFactory);
		onRefresh();
	}

	protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

	protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
		List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
		for (Object beanPostProcessor : beanPostProcessors) {
			beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
		}
	}

	protected void onRefresh() throws Exception{
        beanFactory.preInstantiateSingletons();
    }

	//调用beanfactory工厂获取bean的实例对象
	@Override
	public Object getBean(String name) throws Exception {
		return beanFactory.getBean(name);
	}
}
