package main.ioc.aop;


public interface PointcutAdvisor extends Advisor{

   Pointcut getPointcut();
}
