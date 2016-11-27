package main.ioc.beans.factory;


public interface BeanFactory {

	//获取bean的实例对象
    Object getBean(String name) throws Exception;

}
