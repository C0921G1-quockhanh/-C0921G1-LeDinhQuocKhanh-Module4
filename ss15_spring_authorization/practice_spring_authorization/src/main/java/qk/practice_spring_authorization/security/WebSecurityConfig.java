package qk.practice_spring_authorization.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import qk.practice_spring_authorization.service.MyUserServiceDetailImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserServiceDetailImpl myUserServiceDetail;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //  cai dat cach lay thong tin user, co che encoding, ...
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserServiceDetail)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .formLogin()
//                .defaultSuccessUrl("/blog")
//                .and()
//                .authorizeRequests().anyRequest().authenticated();

        http.csrf().disable()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/blog")
                .and()
                    .authorizeRequests()
                    .antMatchers("/blog").hasRole("USER")
                    .antMatchers("/blog/**").hasRole("ADMIN")
                    .antMatchers("/home").permitAll();
//                    .antMatchers("/blog").hasAnyRole("USER","ADMIN")
//                    .antMatchers("/blog/create").hasRole("ADMIN");

        //cau hinh remember me
        http.authorizeRequests().and()
                .rememberMe().tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60*60*24);
    }

    //cau hinh noi luu thong tin login
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }

}
