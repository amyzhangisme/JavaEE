package test1;

import com.tgb.container.ClassPathXmlApplicationContext;

public class testmain {

    public static void main(String[] args) {
        String locations = "bean1.xml";
          ClassPathXmlApplicationContext ctx = 
		    new ClassPathXmlApplicationContext(locations,"test1");
          boss boss = (boss) ctx.getBean("boss");
          System.out.println(boss.tostring());
    }
}