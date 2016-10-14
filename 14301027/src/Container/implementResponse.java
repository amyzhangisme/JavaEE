package Container;

import java.io.BufferedOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;



public class implementResponse implements ServletResponse{


	
    OutputStream output;
	private PrintWriter outputWriter;
	private boolean called = false;
	Socket s;
    public implementResponse(Socket s) throws IOException {
    	this.s=s;
    	this.output = s.getOutputStream();
		outputWriter = new PrintWriter(new BufferedOutputStream(this.output));
    }

    

    //将web文件写入到OutputStream字节流中
    public void sendStaticResource() throws IOException {
        
    		
            String errorMessage = "HTTP/1.1 200 File zha Found\r\n"
                    + "Content-Type: text/html\r\n" + "Content-Length: 23\r\n"
                    + "\r\n" + "<h1>hjgjkhjliky</h1>";
            output.write(errorMessage.getBytes());
     
    }
	
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		outputWriter.flush();
	}

	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (called)
			throw new IllegalStateException();
		called = true;
		return outputWriter;
	}

	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentType(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
