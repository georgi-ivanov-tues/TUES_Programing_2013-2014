package Day_7;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HttpServer {

	private static final String CLOSE_COMMAND = "CLOSE";
	private static final int PORT = 4444;

	public static void main(String[] args) throws IOException {

		boolean closing = false;
		// create socket
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Started server on port " + PORT);

			// repeatedly wait for connections, and process
			while (!closing) {

				// a "blocking" call which waits until a connection is requested
				try (Socket clientSocket = serverSocket.accept()) {
					System.out.println("Accepted connection from client: "
							+ clientSocket);

					// open up IO streams
					InputStream inStream = clientSocket.getInputStream();
					OutputStream outStream = clientSocket.getOutputStream();

					try (
							BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
							PrintWriter out = new PrintWriter(outStream, true);
							) {
						String s;
						String[] operations = null;
						List<String> allLines = new LinkedList<String>();
						while((s = in.readLine()) != null){
							allLines.add(s);
						}
						RequestParser rq = new RequestParser();
						Request r = rq.parse(allLines);
						if(r.getMethod().equals("GET") && r.getResource().equals("/index.html")){
							System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
							String path = "C:\\Users\\elsyser\\Desktop\\Programing\\TUES_Programing\\2014-2015\\Internet_Programing\\Internet_Programing\\src\\Day_7\\index.html";	
							Scanner sc = new Scanner(new File(path));
							String str = null;
							while(sc.hasNextLine()){
							    str = sc.nextLine();  
							    out.print(str);
							}
						}else{
							out.println("HTTP/1.0 404");
						}
					}
				}
			}
		}
	}
}