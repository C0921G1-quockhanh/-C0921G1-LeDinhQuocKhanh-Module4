package qk.furama_resort.security;

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

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //  cai dat cach lay thong tin user, co che encoding, ...
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
//                .loginPage("/login")
                .defaultSuccessUrl("/").permitAll()
                .and()
                .authorizeRequests()
                    .antMatchers("/employee").hasAnyRole("EMPLOYEE","MANAGER","DIRECTOR")
                    .antMatchers("/employee/**").hasAnyRole("MANAGER","DIRECTOR")
                    .anyRequest().authenticated()
                .and()
                    .logout().logoutSuccessUrl("/");

        //cau hinh remember me
        http.authorizeRequests().and()
                .rememberMe().tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60*60*24);
    }

    //cau hinh luu thong tin login cua user
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }
}
