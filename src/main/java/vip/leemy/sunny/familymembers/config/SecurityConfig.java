package vip.leemy.sunny.familymembers.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: Leemy
 * @date: 2021/12/24-11:36
 * @description: 配置UserDetailsService实现类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
        http.exceptionHandling().accessDeniedPage("/403");
        http.formLogin().loginPage("/myLogin")
                .loginProcessingUrl("/loginController")
                .defaultSuccessUrl("/successIndex").permitAll()
                .and().authorizeRequests()
                .antMatchers("/**","/css/*","/images/*","/js/*").permitAll()
//                .antMatchers("/css/*","/images/*","/js/*").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
