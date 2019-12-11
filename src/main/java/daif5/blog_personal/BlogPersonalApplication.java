package daif5.blog_personal;

import daif5.blog_personal.security.services.UserDetailsServiceImpl;
import daif5.blog_personal.service.UserService;
import daif5.blog_personal.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class BlogPersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogPersonalApplication.class, args);
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
