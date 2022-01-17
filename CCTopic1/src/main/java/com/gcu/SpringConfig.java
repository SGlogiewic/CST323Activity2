package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.FiveValidLogins;
import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityServiceInterface;

@Configuration 
public class SpringConfig {
	@Bean (name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	
	public OrdersBusinessServiceInterface getOrdersBusiness() 
	{
		//OrderBusinessService was for adventure travel experiences
		//AnotherOrdersBusinessService gives you junk food.
		
		return new OrdersBusinessService();
	}
	
	@Bean(name="securityService")
	public SecurityServiceInterface getSecurityService() 
	{
		return new FiveValidLogins();
	}
}
