package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("UNEMPLOYED")
                .and()
                .withUser("admin").password("password").roles("ADMIN")
                .and()
                .withUser("worker1").password("123").roles("WORKER");;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/start").permitAll()
                    .antMatchers("/admin/**").hasAnyRole("ADMIN")
                    .antMatchers("/worker/**").hasAnyRole("WORKER")
                    .antMatchers("/unemployed/**").hasAnyRole("UNEMPLOYED")
                    .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
             .logout()
                .permitAll()
             .and()
                .rememberMe().key("myKey").tokenValiditySeconds(300);
    }



//        http.authorizeRequests()
//                .and()
//                .formLogin().loginPage("/login.html").permitAll().usernameParameter("j_username")
//                .passwordParameter("j_password").loginProcessingUrl("/j_spring_security_check").failureUrl("/login.html?error=true")
//                .and()
//                .httpBasic()
//                .and()
//                .authorizeRequests().antMatchers("/security/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasRole("USER")
//                .and()
//                .logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/")
//                .and()
//                .rememberMe().key("myKey").tokenValiditySeconds(300)
//                .and()
//                .csrf().disable();

}
