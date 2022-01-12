package vip.leemy.sunny.familymembers.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Carmine
 * @Date: 2021/12/24-15:05
 * @Description:
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/myLogin").setViewName("login");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/successIndex").setViewName("successIndex");
        registry.addViewController("/403").setViewName("error/403");
    }
}
