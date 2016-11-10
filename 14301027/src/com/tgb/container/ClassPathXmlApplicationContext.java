package com.tgb.container;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.text.FieldView;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;



import Annotation.Autowired;
import test1.car;

/**
 * 容器
 * 
 * @author 张玉会
 * 
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

	// 用于存放bean
	private List<BeanDefinition> beanDefines = new ArrayList<BeanDefinition>();
	// 用于存放bean的实例
	private Map<String, Object> sigletons =new HashMap<String, Object>();
	
	private Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>();

	public ClassPathXmlApplicationContext(String fileName,String packagename) {

		this.readXML(fileName);
		readAnnotation(packagename);
		this.instanceBeans();		
		this.injectObject();
		injectAurowiredObject(packagename);
	}




	/**
	 * 为bean对象属性注入值
	 */
	private void injectObject() {
		for (BeanDefinition beanDefinition :beanDefines) {
			//			System.out.println("2."+beanDefinition.getId());
			Object bean = sigletons.get(beanDefinition.getId());
			System.out.println("ID:"+beanDefinition.getId());
			if(bean != null){
				try {
					// 通过Introspector取得bean的定义信息，之后在获得他的属性值，返回数组
					PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();

					for(PropertyDefinition propertyDefinition:beanDefinition.getPropertys()){
						for(PropertyDescriptor properdesc: ps){

							if(propertyDefinition.getName().equals(properdesc.getName())){
								// 获取属性的setter方法,private
								Method setter = properdesc.getWriteMethod(); 
								if(setter != null){

									Object value ;
									if(propertyDefinition.getRef()!=null){
										value=sigletons.get(propertyDefinition.getRef());
										
									}
									else
										value = propertyDefinition.getValue();

									// 允许访问私有方法
									setter.setAccessible(true); 
									// 把属性注入到对象
									setter.invoke(bean, value); 
								}
								break;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 完成bean的实例化
	 */
	private void instanceBeans() {
		for(BeanDefinition beanDefinition : beanDefines){
			try {
				if(beanDefinition.getClassName() != null && !"".equals(beanDefinition.getClassName().trim())){
					//					System.out.println("1."+beanDefinition.getId()+beanDefinition.getClassName());
					
					sigletons.put(beanDefinition.getId(),Class.forName(beanDefinition.getClassName()).newInstance());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取xml配置文件
	 */
	private void readXML(String fileName) {
		// 创建SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();

		try {
			// 读取资源，获得document对象
			Document doc = saxBuilder.build(this.getClass().getClassLoader()
					.getResourceAsStream(fileName));
			// 获取根元素
			Element rootEle = doc.getRootElement();
			// 从跟元素获取所有的自元素，建立元素集合
			List listBean = XPath.selectNodes(rootEle, "/beans/bean");

			// 遍历跟元素的自元素，扫描配置文件bean
			for (int i = 0; i < listBean.size(); i++) {
				// 将跟元素beans下的自元素bean作为一个新的子根源素
				Element elementBean = (Element) listBean.get(i);
				//获取id属性
				String id = elementBean.getAttributeValue("id");
				//获取class属性
				String clazz = elementBean.getAttributeValue("class");				
				BeanDefinition beanDefine = new BeanDefinition(id,clazz);
				// 获取子根元素bean下的所有property自元素
				List listProperty = elementBean.getChildren("property");
				// 遍历自跟元素的所有自元素集合遍历property元素)
				for (int j = 0; j < listProperty.size(); j++) {
					// 获取property属性
					Element elmentProperty = (Element)listProperty.get(j);
					//获取name属性
					String propertyName = elmentProperty.getAttributeValue("name");
					// 获取ref属性
					String propertyref = elmentProperty.getAttributeValue("ref");
					//获取value属性
					String propertyvalue = elmentProperty.getAttributeValue("value");

					PropertyDefinition propertyDefinition = new PropertyDefinition(propertyName,propertyref,propertyvalue);

					beanDefine.getPropertys().add(propertyDefinition);
				}

				// 将javabean添加到集合中

				//				System.out.println(beanDefine.getClassName());
				//				System.out.println(beanDefine.getId());
				beanDefines.add(beanDefine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 读取注解
	 */
	private void readAnnotation(String packagename){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		classSet=ClassUtil.getBeanClassSet(packagename);
		for (Iterator<Class<?>> it = classSet.iterator();it.hasNext();){
			Class<?> classname = it.next();
//			System.out.println(classname.getName());
			BeanDefinition beanDefine = new BeanDefinition(classname.getSimpleName(),classname.getName());
			beanDefines.add(beanDefine);
			try {
				//System.out.println(classname);
				beanMap.put(classname, Class.forName(classname.getName().toString()).newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Aurowired
	 */
	private void injectAurowiredObject(String packagename)
	{

		
        if (!sigletons.isEmpty()) {
            for (Entry<String, Object> beanEntry : sigletons.entrySet()) {
                String beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanInstance.getClass().getDeclaredFields();
                if (beanFields.length>0) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Autowired.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = sigletons.get(beanFieldClass.getSimpleName());
                            System.out.println(beanFieldInstance);
                            System.out.println(sigletons);
                            if (beanFieldInstance != null) {
                                //ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                                beanField.setAccessible(true);
                                try {
									beanField.set(beanInstance, beanFieldInstance);
								} catch (IllegalArgumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                            }
                        }
                    }
                }
            }
            }
        
	}


	/**
	 * 获取bean实例
	 */
	@Override
	public Object getBean(String beanName) {
		return this.sigletons.get(beanName);
	}
}
