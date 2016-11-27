package main.ioc.beans;

import java.util.HashMap;
import java.util.Map;

import main.ioc.beans.io.ResourceLoader;


public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

	//bean集合
    private Map<String,BeanDefinition> registry;

    //资源加载器
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
