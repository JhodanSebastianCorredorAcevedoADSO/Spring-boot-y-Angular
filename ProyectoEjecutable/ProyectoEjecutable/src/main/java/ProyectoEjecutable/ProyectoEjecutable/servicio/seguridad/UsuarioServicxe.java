package ProyectoEjecutable.ProyectoEjecutable.servicio.seguridad;

import ProyectoEjecutable.ProyectoEjecutable.model.seguridad.Usuario;
import ProyectoEjecutable.ProyectoEjecutable.persistencia.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicxe implements UserDetailsService {

    // consultar el usuario
    // consultar los servicios que tenga el usuario

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    // y aqui llega al usuario
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // del usuario obtiene la contraseña
        Usuario usuario = usuarioRepositorio.findByNombreUsuario(username);
        List<GrantedAuthority> authorities = usuario.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getNombreRol())).collect(Collectors.toList());
        // user se le inyecta poropio del frame la iunformacion
        return new User(username, usuario.getPassword(), usuario.isEnabled(), true, true, true, authorities );
    }
}
