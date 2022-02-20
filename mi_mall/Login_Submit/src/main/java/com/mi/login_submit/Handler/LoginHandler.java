package com.mi.login_submit.Handler;


import com.mi.login_submit.InterCeptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class LoginHandler implements WebMvcConfigurer {
    @Autowired
    InterCeptor interCeptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

   InterceptorRegistration registration=     registry.addInterceptor(interCeptor);
//   要拦截的路径
   registration.addPathPatterns("/check");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
