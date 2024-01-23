package com.nt.initializer;

import java.util.Set;

import com.nt.mrg.MarriageChecker;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class MyWebAppInitializer implements ServletContainerInitializer {
    static {
    	System.out.println("MyWebAppInitializer.Static Block()");
    }
    
	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitialize-Zero param Constructor");
	}
	
	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		MarriageChecker servlet=null;
		ServletRegistration.Dynamic dyna=null;
		System.out.println("MyWebAppInitializer.onStartup()");
		//Object Creation
		servlet=new MarriageChecker();
		//Register Servlet comp
		dyna=sc.addServlet("mc",servlet);
		dyna.addMapping("/mrgchk");
		dyna.setLoadOnStartup(1);
		
		
		
		
	}

}
