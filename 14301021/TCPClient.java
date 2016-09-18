import java.net.*;
import java.io.*;

public class TCPClient{
	public static void main(String[] args){
		Socket cSocket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		String userInput;
		try{
			//�����׽��֣����ӵ�������
			cSocket =new Socket("127.0.0.1",3333);
			out=new PrintWriter(cSocket.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
			BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
		//�Ӽ��̻�ȡ���룬���͵���������Ȼ���ȡ��������Ӧ��Ϣ
			while((userInput=stdIn.readLine())!=null){
				System.out.println("send message��"+userInput);
				out.println(userInput);
				System.out.println("receive message��"+in.readLine());
				//���ÿͻ��˷���exit���������˽��պ󣬸ÿͻ����˳�
				if(userInput.equals("exit"))
					break;
			}
			System.out.println("�����˳�");
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