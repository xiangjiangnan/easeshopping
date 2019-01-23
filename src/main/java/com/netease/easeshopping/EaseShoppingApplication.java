package com.netease.easeshopping;

import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import static freemarker.template.utility.Collections12.singletonList;

@SpringBootApplication
public class EaseShoppingApplication {

	public EaseShoppingApplication(FreeMarkerConfigurer freeMarkerConfigurer) {
		freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(singletonList("/META-INF/security.tld"));
	}

	public static void main(String[] args) {
		SpringApplication.run(EaseShoppingApplication.class, args);
	}

}

