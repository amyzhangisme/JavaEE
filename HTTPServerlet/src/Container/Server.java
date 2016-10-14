package Container;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Servlet;
import javax.xml.stream.XMLStreamException;






public class Server {
	public static String SERVER_STRING = "Server: jdbhttpd/0.1.0\r\n";
	public static final int SERVERPORT=3324;
	static Socket socket = null;


	public static  void startup(){
		ServerSocket s=null;
		try {
			s = new ServerSocket(SERVERPORT,1,InetAddress.getByName("127.0.0.1"));
			System.out.println("started"+s);
			while(true){
				socket = s.accept();
				Thread t = new thread1(socket);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class thread1 extends Thread implements Runnable{
		Map<String, String> map = new HashMap<String, String>();
		Map<String, Serializable> get_environ = new HashMap<String, Serializable>();
		private Socket s;
		public thread1(Socket socket){
			s=socket;
		}
		public void run(){
			try {

				System.out.println("Hello!");
				System.out.println(s.getOutputStream());
				implementRequest request = new implementRequest(s);
				request.startParse();
				implementResponse response = new implementResponse(s);
				ParseXml px = new ParseXml();

				try {
					px.parseWebXML("./web.xml");
				} catch (XMLStreamException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(request.getPath());
				if (ParseXml.servletMap.containsKey(request.getPath())) {
					System.out.println(request.getPath());
					System.out.println(ParseXml.servletMap.get(request.getPath()));
					ParseXml.ServletClass servlet = ParseXml.servletMap.get(request.getPath());
					System.out.println(servlet.name);
					if (servlet.servlet == null) {
						servlet.servlet = (Servlet) Class.forName(servlet.name).newInstance();
						servlet.servlet.init(null);

					}
					servlet.servlet.service(request, response);
					response.flushBuffer();

				} 
				else if (request.getUri().equals("/"))  {
					//静态资源请求
					BufferedInputStream input = null;
					BufferedOutputStream output = new BufferedOutputStream(s.getOutputStream());
					input = new BufferedInputStream(new FileInputStream("./www/index.html"));

					byte[] buffered = new byte[1024];
					int cnt = 0;
					while ((cnt = input.read(buffered, 0, 1024)) != -1) {
						output.write(buffered, 0, cnt);
					}
					input.close();
					output.flush();
				}
				else if (request.getUri().equals("/favicon.ico"))  {
					//静态资源请求
					System.out.println("static");	
					response.getWriter().println("404 NOT FOUND");
					response.flushBuffer();
				}
				else if (request.getUri().split(".")[1].equals("html"))
				{
					BufferedInputStream input = null;
					BufferedOutputStream output = new BufferedOutputStream(s.getOutputStream());
					input = new BufferedInputStream(new FileInputStream(request.getUri()));

					byte[] buffered = new byte[1024];
					int cnt = 0;
					while ((cnt = input.read(buffered, 0, 1024)) != -1) {
						output.write(buffered, 0, cnt);
					}
					input.close();
					output.flush();
				}

				// 关闭 socket
				//socket.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally
			{
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		startup();
	}

}
