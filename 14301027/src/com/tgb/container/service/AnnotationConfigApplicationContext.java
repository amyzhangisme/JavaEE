//package com.tgb.container.service;
//
//
//
//public class AnnotationConfigApplicationContext extends GenericApplicationContext {
//	//创建一个读取注解的Bean定义读取器，并将其设置到容器中
//	private final AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(this);
//	//创建一个扫描指定类路径中注解Bean定义的扫描器，并将其设置到容器中
//	private final ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(this);
////默认构造函数，初始化一个空容器，容器不包含任何 Bean 信息，需要在稍后通过调用其register() //方法注册配置类，并调用refresh()方法刷新容器，触发容器对注解Bean的载入、解析和注册过程
//	public AnnotationConfigApplicationContext() {
//	}
//	//最常用的构造函数，通过将涉及到的配置类传递给该构造函数，以实现将相应配置类中的Bean
////自动注册到容器中
//	public AnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
//		register(annotatedClasses);
//		refresh();
//	}
////该构造函数会自动扫描以给定的包及其子包下的所有类，并自动识别所有的Spring Bean，将其
////注册到容器中
//	public AnnotationConfigApplicationContext(String... basePackages) {
//		scan(basePackages);
//		refresh();
//	}
//	//为容器的注解Bean读取器和注解Bean扫描器设置Bean名称产生器
//	public void setBeanNameGenerator(BeanNameGenerator beanNameGenerator) {
//		this.reader.setBeanNameGenerator(beanNameGenerator);
//		this.scanner.setBeanNameGenerator(beanNameGenerator);
//	}
//	//为容器的注解Bean读取器和注解Bean扫描器设置作用范围元信息解析器
//	public void setScopeMetadataResolver(ScopeMetadataResolver scopeMetadataResolver) {
//		this.reader.setScopeMetadataResolver(scopeMetadataResolver);
//		this.scanner.setScopeMetadataResolver(scopeMetadataResolver);
//	}
//	//为容器注册一个要被处理的注解Bean，新注册的Bean，必须手动调用容器的
////refresh()方法刷新容器，触发容器对新注册的Bean的处理
//	public void register(Class<?>... annotatedClasses) {
//		this.reader.register(annotatedClasses);
//	}
//	//扫描指定包路径及其子包下的注解类，为了使新添加的类被处理，必须手动调用
//	//refresh()方法刷新容器
//	public void scan(String... basePackages) {
//		this.scanner.scan(basePackages);
//	}
//}
