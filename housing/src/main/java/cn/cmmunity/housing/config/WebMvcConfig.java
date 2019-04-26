package cn.cmmunity.housing.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import cn.cmmunity.housing.config.DateConverter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/addhousing").setViewName("/addhousing.html");
        registry.addViewController("/note").setViewName("/note.html");
        registry.addViewController("/addcharge").setViewName("/addcharge.html");
        registry.addViewController("/login").setViewName("/login.html");
    }
}
