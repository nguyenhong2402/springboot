package vn.techmaster.simpleauthen.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  // @Bean
  // public UserDetailsService userDetailsService() {    
  //   var tom = User.withUsername("tom@gmail.com").password("123").
  //   authorities("read").build();
  //   var bob = User.withUsername("bob@gmail.com").password("123").
  //   authorities("read").build();
    
  //   return new InMemoryUserDetailsManager(tom, bob);
  // }

   @Bean
   public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
   }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //http.httpBasic();  //Sử dụng cơ chế authentication http basic
    http.formLogin();
    http.authorizeRequests().antMatchers("/h2-console/**").permitAll().and().csrf().ignoringAntMatchers("/h2-console/**")
    .and().headers().frameOptions().sameOrigin();
    http.authorizeRequests().antMatchers("/api/**").authenticated();  //
    return http.build();
  }

  @Bean
  public UserDetailsManager users(DataSource dataSource) {
      JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        //   Collection<UserDetails> users = new ArrayList<>();
    PasswordEncoder encoder = passwordEncoder();
    UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
    var tom = userBuilder.username("tom@gmail.com").password("123").roles("USER").build();
    var bob = userBuilder.username("bob@gmail.com").password("123").roles("USER").build();
    var alice = userBuilder.username("alice@gmail.com").password("123").roles("USER").build();
    System.out.println("user: " + tom.getUsername() + "|" + tom.getPassword());

      users.createUser(tom);
      users.createUser(bob);
      users.createUser(alice);
      return users;
  }
}