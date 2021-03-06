package Day_6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class HttpClient {
	private static final int PORT = 4444;
	private static final String HOST = "localhost";
//	private static final String TEXT = "asdasd\n";

	public static void main(String[] args) throws IOException {

		final String TEXT = "GET /index.html:4444 \\n Accept: applications/html \n";
		
		try (Socket echoSocket = new Socket(HOST, PORT);
				OutputStream outStream = echoSocket.getOutputStream();
				InputStream inStream = echoSocket.getInputStream();) {

			outStream.write(TEXT.getBytes());
			outStream.flush();

			byte[] buffer = new byte[TEXT.length()];
			inStream.read(buffer);
			// do something...
			System.out.println("echo: " + new String(buffer));
			System.out.println("echo: " + Arrays.toString(buffer));

		}
	}
}