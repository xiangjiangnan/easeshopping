package com.netease.easeshopping;

import com.netease.easeshopping.configuration.resolver.JsonPathArgumentReslover;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.List;

import static freemarker.template.utility.Collections12.singletonList;

@SpringBootApplication
public class EaseShoppingApplication extends WebMvcConfigurationSupport {

	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new JsonPathArgumentReslover());
		super.addArgumentResolvers(argumentResolvers);
	}

	public EaseShoppingApplication(FreeMarkerConfigurer freeMarkerConfigurer) {
		freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(singletonList("/META-INF/security.tld"));
	}

	public static void main(String[] args) {
		SpringApplication.run(EaseShoppingApplication.class, args);
	}

}

