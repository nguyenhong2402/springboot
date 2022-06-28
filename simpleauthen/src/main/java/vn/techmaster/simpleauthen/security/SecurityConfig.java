package vn.techmaster.simpleauthen.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
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
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // auth.inMemoryAuthentication().withUser("tom@gmail.com").password("abc")
    //     .authorities("read").and()
    //     .passwordEncoder(NoOpPasswordEncoder.getInstance());
    auth.userDetailsService(inMemoryUserDetailsManager());
        // .passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // http.httpBasic(); // Sử dụng cơ chế authentication http basic
    http.formLogin();
    http.authorizeRequests().anyRequest().authenticated(); //
  }
  
  @Bean
  public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

    Collection<UserDetails> users = new ArrayList<>();
    PasswordEncoder encoder = passwordEncoder();
    UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
    var tom = userBuilder.username("tom@gmail.com").password("123").roles("USER").build();
    var bob = userBuilder.username("bob@gmail.com").password("123").roles("USER").build();
    var alice = userBuilder.username("alice@gmail.com").password("123").roles("USER").build();

    System.out.println(alice.getPassword());

    users.add(tom);
    users.add(bob);
    users.add(alice);
    return new InMemoryUserDetailsManager(users);
  }
}