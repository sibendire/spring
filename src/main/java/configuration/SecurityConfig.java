package configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityConfig {
public BCryptPasswordEncoder encoder(){
    return new BCryptPasswordEncoder();
}
}
