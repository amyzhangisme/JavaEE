package main.ioc.aop;


public interface ClassFilter {

    boolean matches(Class targetClass);
}
