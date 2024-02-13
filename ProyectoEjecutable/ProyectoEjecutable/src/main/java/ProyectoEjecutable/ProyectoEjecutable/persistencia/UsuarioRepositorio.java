package ProyectoEjecutable.ProyectoEjecutable.persistencia;

import ProyectoEjecutable.ProyectoEjecutable.model.seguridad.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer >{

    Usuario findByNombreUsuario(String username);
}
