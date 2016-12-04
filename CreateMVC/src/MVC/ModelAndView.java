package MVC;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private String ViewName;
    Map<String,String> requestMap = new HashMap<String,String>();  
    Map<String,String> responseMap = new HashMap<String,String>();
    
	public String getViewName() {
		return ViewName;
	}
	public void setViewName(String viewName) {
		ViewName = viewName;
	}
	public void putMap(String key,String value){
		requestMap.put(key, value);
	}
	public String getMap(String key){
		return requestMap.get(key);
	}
	public void addObject(String key,String value){
		responseMap.put(key, value);
	}
}
