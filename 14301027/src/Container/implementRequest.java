package Container;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class implementRequest implements ServletRequest{
	public static String SERVER_STRING = "Server: jdbhttpd/0.1.0\r\n";
	private String localAddr;
	private int localPort;
	private String localName;
	private String remoteAddr;
	private int remotePort;
	private String remoteHost;
	private Map<String, Object> attributes = new HashMap<String, Object>();
	private Map<String, String[]> parameters = new HashMap<String, String[]>();
	private Reader reader = null;
	private long contentLength = -1;
	private String characterEncoding = null;
	private String contentType = null;
	private String protocol = null;
	@SuppressWarnings("unused")
	private String characterEncode = null;
	private String requestPath = null;
	private boolean isCalledGetInput = false;
	private boolean isAsync = false;

	Map<String, String> map = new HashMap<String, String>();
	Map<String, Serializable> get_environ = new HashMap<String, Serializable>();
	private InputStream input;
    Socket s;
    public implementRequest(Socket s) throws IOException {
    	this.s=s;
        this.input = s.getInputStream();
    }

    public String getUri() {
        return requestPath;
    }
    public String getPath() {
        return requestPath;
    }
    
    
   


	public void startParse() throws IOException{
		InetAddress local = s.getLocalAddress();
		InetAddress remote = s.getInetAddress();

		localAddr = local.getHostAddress();
		localPort = s.getLocalPort();
		localName = local.getHostName();

		remoteAddr = remote.getHostAddress();
		remotePort = s.getPort();
		remoteHost = remote.getHostName();
		InputStreamReader input = new InputStreamReader(new BufferedInputStream(s.getInputStream()));
		char[] buffer = new char[2048];
		int cnt = input.read(buffer, 0, 2048);
		char[] data = new char[Math.max(cnt, 0)];
		System.arraycopy(buffer, 0, data, 0, cnt);
		String dataToStr = new String(data);
		System.out.println(dataToStr);
		String[] splits = dataToStr.toString().split("\r\n\r\n");

		String[] requestHead = splits[0].split("\r\n")[0].split(" ");
		String[] paths = requestHead[1].split("\\?");

		requestPath = paths[0];

		String body = (splits.length > 1 ? splits[1] : "") + (splits.length > 1 && paths.length > 1 ? "&" : "")
				+ (paths.length > 1 ? paths[1] : "");
		// System.out.println(body);
		String[] params = body.split("&");
		Map<String, ArrayList<String>> tmpMap = new HashMap<String, ArrayList<String>>();
		for (String s : params) {
			String[] param = s.split("=");
			if (!tmpMap.containsKey(param[0]))
				tmpMap.put(param[0], new ArrayList<String>());
			tmpMap.get(param[0]).add(param.length > 1 ? param[1] : "");
		}
		Set<Map.Entry<String, ArrayList<String>>> entrySet = tmpMap.entrySet();
		for (Map.Entry<String, ArrayList<String>> entry : entrySet) {
			parameters.put(entry.getKey(), entry.getValue().toArray(new String[0]));
		}
		reader = new StringReader(splits.length > 1 ? splits[1] : "");
	}

    /**
     * 
     * requestString形式如下：
     * GET /index.html HTTP/1.1
     * Host: localhost:8080
     * Connection: keep-alive
     * Cache-Control: max-age=0
     * ...
     * 该函数目的就是为了获取/index.html字符串
     */
    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2);
        }
        return null;
    }
    
    //从InputStream中读取request信息，并从request中获取uri值
    public void parse() {
        // Read a set of characters from the socket
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            request.append((char) buffer[j]);
        }
        System.out.print(request.toString());
        parseUri(request.toString());
    }


	@Override
	public AsyncContext getAsyncContext() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DispatcherType getDispatcherType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<Locale> getLocales() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getParameter(String arg0) {
		String[] paras = parameters.get(arg0);
		return paras == null ? null : paras[0];
	}


	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String[] getParameterValues(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRealPath(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAsyncStarted() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAsyncSupported() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public AsyncContext startAsync() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
