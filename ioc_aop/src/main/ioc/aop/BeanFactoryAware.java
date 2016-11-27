package main.ioc.aop;

import main.ioc.beans.factory.BeanFactory;


public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
