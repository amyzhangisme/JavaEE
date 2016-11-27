package main.ioc.aop;

import org.aopalliance.aop.Advice;


public interface Advisor {

	//获取通知事件
    Advice getAdvice();
}
