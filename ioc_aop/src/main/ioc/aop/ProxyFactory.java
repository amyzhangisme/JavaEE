package main.ioc.aop;


//获取代理
public class ProxyFactory extends AdvisedSupport implements AopProxy {

	@Override
	public Object getProxy() {
		return createAopProxy().getProxy();
	}

	protected final AopProxy createAopProxy() {
		return new ProxyFactoryBean(this);
	}
}
