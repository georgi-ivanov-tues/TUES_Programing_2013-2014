package org.elsysbg.courses.ip.sockets.crud.server;

import java.io.PrintWriter;

public class ReadAction implements Action {

	@Override
	public void execute(PrintWriter out) {
		out.println("Reading");
	}

}
