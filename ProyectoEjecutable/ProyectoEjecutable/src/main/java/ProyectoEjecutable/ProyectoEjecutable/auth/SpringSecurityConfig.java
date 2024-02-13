package ProyectoEjecutable.ProyectoEjecutable.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {

    // se configura el sprig security
    // aqui llegan los datos del usuario nombre y contraseña para generar el token

    @Autowired
    private UserDetailsService usuarioService;

    @Override
    @Autowired
    // aqui llegan
    // hace la peticion y se va al userDetailsService
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
        // aqui obtiene la contraseña que se envio
        auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws  Exception {
        return super.authenticationManager();
    }
}
