package qk.spring_security.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //cấu hình xác thực bộ nhớ với thông tin đăng nhập và vai trò của người dùng
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}12345").roles("USER")
                .and()
                .withUser("admin").password("{noop}12345").roles("ADMIN");
    }

    // cấu hình bảo mật dựa trên web cho tất cả các yêu cầu HTTP
    //Theo mặc định, nó sẽ được áp dụng cho tất cả các yêu cầu, nhưng có thể bị hạn chế bằng cách sử dụng requestMatcher () hoặc các phương thức tương tự khác
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Url '/' không được bảo mật và có thể được truy cập bởi bất kỳ ai
        http.authorizeRequests().antMatchers("/").permitAll()
                .and()
                //Bất kỳ URL nào bắt đầu bằng '/user' đều được bảo mật và chỉ những người dùng nào có vai trò 'USER' mới có thể truy cập được
                .authorizeRequests().antMatchers("/user**").hasRole("USER")
                .and()
                //Bất kỳ URL nào bắt đầu bằng '/admin' đều được bảo mật và chỉ những người dùng nào có vai trò 'ADMIN' mới có thể truy cập được
                .authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

}
