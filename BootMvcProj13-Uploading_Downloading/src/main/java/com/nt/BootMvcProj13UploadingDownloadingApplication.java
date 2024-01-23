package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootMvcProj13UploadingDownloadingApplication {
	
//	  @Bean(name="multiPartResolver")
//      public CommonsMultipartResolver createCMresolver() {
//		  CommonsMultipartResolver resolver=new CommonsMultipartResolver();
//    	  return null;
//      }

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj13UploadingDownloadingApplication.class, args);
	}

}
