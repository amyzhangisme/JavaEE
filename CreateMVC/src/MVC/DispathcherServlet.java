package MVC;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Annotation.RequestMapping;
import dev.edu.javaee.spring.factory.BeanFactory;
import dev.edu.javaee.spring.factory.XMLBeanFactory;
import dev.edu.javaee.spring.resource.LocalFileResource;
import test.test;
public class DispathcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DispathcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubresponse.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");  
		Enumeration<?> enu=request.getParameterNames();  
		ModelAndView mav=new ModelAndView();
		
		while(enu.hasMoreElements()){   
		String paraName=(String)enu.nextElement();  
		  mav.putMap(paraName, request.getParameter(paraName));
		}
		
	    String uri = request.getServletPath() ;  //hello 
	   
        LocalFileResource resource = new LocalFileResource("/Users/Amy/Downloads/CreateMVC/src/MVC/bean.xml");
		
		BeanFactory beanFactory = new XMLBeanFactory(resource);
       
		test test= (test) beanFactory.getBean("test");   //control
		
		Method[]  methods = test.getClass().getMethods();
		
		
		try{
		    for (Method m : methods){
			    RequestMapping requestmapano = m.getAnnotation(RequestMapping.class);
			    String value = requestmapano.value();
			
			    if(value.equals(uri)){  
				
				    ModelAndView return_mav=(ModelAndView)m.invoke(test,mav);
				    uri=return_mav.getViewName(); 
				    List<String> keys = new ArrayList<String>(return_mav.responseMap.keySet());
				    
				    for(String key : keys){
				          request.setAttribute(key,return_mav.responseMap.get(key));
				    }
				    break;
			    }
		    }
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
			
	    request.getRequestDispatcher(uri+".jsp").forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
    }
}
