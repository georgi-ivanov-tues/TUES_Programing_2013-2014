package Day_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestParser {

	public Request parse(List<String> request) {
		String[] firstLineParsed = request.remove(0).split(" ");

		Map<String, String> headers = new HashMap<>();
		for (String header : request) {
			String[] secondLine = header.split(": ");
			headers.put(secondLine[0], secondLine[1]);
		}
		
		List<String> bodyList = new ArrayList<String>();

		for(String asd : request){
			boolean isBody = false;
			if(asd.equals("/r/n/r/n")){
				isBody = true;
				continue;
			}
			
			if(isBody){
				System.out.println("BODY = " + asd);
				bodyList.add(asd);
			}
		}
		
		Object body = bodyList;
		
		return new Request(firstLineParsed[0],
				firstLineParsed[1], firstLineParsed[2], body, headers);
	}
}