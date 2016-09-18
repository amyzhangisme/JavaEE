import java.net.*;
import java.io.*;
 
public class MultiTCPServer extends Thread{
	static ServerSocket serverSocket=null;
	//���߳���صĿͻ��׽���
	Socket clientSocket=null;
	static int count=1;
	private int clientID;
	//���췽���������̣߳�
	private MultiTCPServer(Socket clientSoc){
		clientSocket=clientSoc;
		clientID=count++;
		start();
	}
	//ʹ���̴߳���ͻ�����
	public void run(){
		BufferedReader in;
		PrintWriter out;
		String inputLine;
		try{
			out=new PrintWriter(clientSocket.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while((inputLine=in.readLine())!=null){
				System.out.println("receive message[from client"+clientID+"]:"+inputLine);
				StringBuffer reverseStr=(new StringBuffer(inputLine)).reverse();
				out.println(reverseStr);
				//���ó��˽��յ��ͻ��˵�exit���˳��ÿͻ��ˣ���ο�ɾ
				if(reverseStr.equals("tixe"))
					break;
			}
			System.out.println("END:client"+clientID);
			out.close();
			in.close();
			clientSocket.close();
		}catch(IOException e){
			System.exit(1);
		}
		
	}
	public static void main(String[] args){
		System.out.println("Server started");
		try{
			serverSocket=new ServerSocket(3333);
			while(true){
				new MultiTCPServer(serverSocket.accept());
			
			}
		}catch(IOException e){
			System.out.println("server close!");
			//serverSocket.close();
			System.exit(1);
		}
	}
}