package com.nt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TilesConfiguration {

	
	@Bean
	public  TilesConfigurer  createTilesConfigurer() {
		System.out.println("BootMvcProj19TilesIntegrationApplication.createTilesConfigurer()");
		TilesConfigurer  configurer=new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/tiles.xml");
		return configurer;
	}
	
	@Bean
	public  TilesViewResolver  createTVResolver() {
		System.out.println("BootMvcProj19TilesIntegrationApplication.createTilesConfigurer()");
		   TilesViewResolver resolver=new TilesViewResolver();
		   return resolver;
	}
}
