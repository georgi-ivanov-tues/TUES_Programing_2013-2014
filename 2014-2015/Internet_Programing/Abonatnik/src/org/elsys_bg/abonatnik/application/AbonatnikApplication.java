package org.elsys_bg.abonatnik.application;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("Abonatnik")
public class AbonatnikApplication extends ResourceConfig {
	
	public AbonatnikApplication(){
		packages("org.elsys_bg.abonatnik.rest");
	}
	
}
