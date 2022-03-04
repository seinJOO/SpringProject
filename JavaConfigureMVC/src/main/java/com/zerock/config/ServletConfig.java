package com.zerock.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//servlet config는 두 가지 방법으로 생성 가능(1.EnableWebMvc, 2.....?)
//기본 설정은 annotation-driven, resource 매핑, 컨트롤러 경로 렌더링(prefix/suffix)

@EnableWebMvc
@ComponentScan(basePackages = {"com.zerock.controller"}) // = <context:component-scan base-package="com.zerock.controller" />
public class ServletConfig implements WebMvcConfigurer {

	@Override 		//ctrl+space로 override해서 불러오기
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
/* 아래와 같음!
 * <beans:bean
 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 * <beans:property name="prefix" value="/WEB-INF/views/" /> <beans:property
 * name="suffix" value=".jsp" /> </beans:bean>
 */	
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
