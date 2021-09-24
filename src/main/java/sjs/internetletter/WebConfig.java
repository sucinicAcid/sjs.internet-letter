package sjs.internetletter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sjs.internetletter.web.interceptor.HomeInterceptor;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HomeInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/letters","/letters/add","/letters/complete",
                        "/admin/letters", "/admin/letters/*","/admin/letters/*/delete");
    }
}
