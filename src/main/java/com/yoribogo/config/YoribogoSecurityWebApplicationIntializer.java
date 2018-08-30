package com.yoribogo.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class YoribogoSecurityWebApplicationIntializer extends AbstractSecurityWebApplicationInitializer{
	
}

/*

시큐어리티 초기화 클래스

이부분을 입력함으로써 web.xml에서한
<filter>
<filter-name>springSecurityFilterChain</filter-name>
<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>
<filter-mapping>
<filter-name>springSecurityFilterChain</filter-name>
<url-pattern>//*</url-pattern>
</filter-mapping>
를 한 클래스로 끝낼수 있다.

*/