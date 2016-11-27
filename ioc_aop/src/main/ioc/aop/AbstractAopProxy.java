package main.ioc.aop;


public abstract class AbstractAopProxy implements AopProxy {

	
    protected AdvisedSupport advised;

    //传入通知事件
    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
