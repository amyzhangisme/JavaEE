package Container;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.Servlet;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;






public class ParseXml {
	public class ServletClass {
		public String name = "";
		public Servlet servlet = null;

		public ServletClass(String name) {
			this.name = name;
		}
	}

	public static Map<String, ServletClass> servletMap = Collections.synchronizedMap(new HashMap<String, ServletClass>());
	public static Set<String> welcomeSet = new HashSet<String>();
	public void parseWebXML(String path) throws XMLStreamException, IOException {
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		XMLInputFactory factory = XMLInputFactory.newFactory();
		XMLStreamReader reader = factory.createXMLStreamReader(new BufferedInputStream(new FileInputStream(path)));
		String value1 = "";
		String value2 = "";
		while (reader.hasNext()) {
			int event = reader.next();
			if (event == XMLStreamConstants.START_ELEMENT) {
				String tag = reader.getLocalName();
				if (tag.equals("servlet-name")) {
					value1 = reader.getElementText();
				} else if (tag.equals("servlet-class") || tag.equals("url-pattern")) {
					value2 = reader.getElementText();
				} else if (tag.equals("welcome-file")) {
					welcomeSet.add(reader.getElementText());
				}
			} else if (event == XMLStreamConstants.END_ELEMENT) {
				String tag = reader.getLocalName();
				if (tag.equals("servlet")) {
					 System.out.println(value1 + ", " + value2);
					map1.put(value1, value2);
				} else if (tag.equals("servlet-mapping")) {
					 System.out.println(value2 + ", " + value1);
					map2.put(value2, value1);
				}
			}
			for (Map.Entry<String, String> entry : map2.entrySet()) {
				servletMap.put(entry.getKey(), new ServletClass(map1.get(entry.getValue())));
			}
		}
		reader.close();
	}
	
}
