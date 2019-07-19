package config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

@Configurable

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends GlobalMethodSecurityConfiguration{
	
	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		// TODO Auto-generated method stub
		 return new OAuth2MethodSecurityExpressionHandler();
	}
	
}
