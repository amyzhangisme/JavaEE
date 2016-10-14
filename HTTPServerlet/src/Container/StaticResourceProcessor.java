package Container;

import java.io.IOException;

public class StaticResourceProcessor {

	public void process(implementRequest request, implementResponse response) {
		// TODO Auto-generated method stub
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
