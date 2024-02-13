package MicroServicioPersona.repositorio;

import MicroServicioPersona.model.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonaRepositorio  extends CrudRepository<Persona, Integer> {

    List<Persona> findByActivo(boolean activo);

    @Query(value = "SELECT * FROM PERSONA  WHERE nombre LIKE %:nombre%", nativeQuery = true)
    List<Persona> findByNombre(@Param("nombre") String nombre);

}
