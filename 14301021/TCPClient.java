import java.net.*;
import java.io.*;

public class TCPClient{
	public static void main(String[] args){
		Socket cSocket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		String userInput;
		try{
			//创建套接字，连接到服务器
			cSocket =new Socket("127.0.0.1",3333);
			out=new PrintWriter(cSocket.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
			BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
		//从键盘获取输入，发送到服务器，然后读取服务器响应信息
			while((userInput=stdIn.readLine())!=null){
				System.out.println("send message："+userInput);
				out.println(userInput);
				System.out.println("receive message："+in.readLine());
				//设置客户端发出exit，服务器端接收后，该客户端退出
				if(userInput.equals("exit"))
					break;
			}
			System.out.println("程序退出");
			out.close();
			in.close();
			stdIn.close();
			cSocket.close();
		}catch(IOException e)
		{
			System.exit(1);
		}
	}
}