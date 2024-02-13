package ProyectoEjecutable.ProyectoEjecutable.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter {

    // servidor de recursos

    @Override
    // Servidor de recursos
    // Urls que necesitemos publicas o privadas
    // listas blancas o negras --- descartas/control de seguridad

    public void configure(HttpSecurity http) throws Exception {
        // peticion para saber si esta autorizado o no y da concepcion a la url
        // proxy
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/health")
                .permitAll().anyRequest().authenticated();
    }
}
