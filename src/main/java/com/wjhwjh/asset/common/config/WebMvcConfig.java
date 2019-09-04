package com.wjhwjh.asset.common.config;

import com.wjhwjh.asset.common.config.intercept.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author wjhwjh
 * spring mvc 配置文件
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final AuthenticationInterceptor interceptor;

//    /**
//     * 设置相响应编码为utf-8 但是没用😤
//     *
//     * @return
//     */
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(
//                Charset.forName("UTF-8"));
//        return converter;
//    }
//
//    @Override
//    protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false);
//    }
//
//    @Override
//    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        converters.add(responseBodyConverter());
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/").addResourceLocations("classpath:/static/**");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/api/**")
                .excludePathPatterns("/api/*", "/login", "/api/**", "/css/**", "/images/**", "/js/**", "/lib/**");
//        super.addInterceptors(registry);
    }


    @Autowired
    public WebMvcConfig(AuthenticationInterceptor interceptor) {
        this.interceptor = interceptor;
    }
}
