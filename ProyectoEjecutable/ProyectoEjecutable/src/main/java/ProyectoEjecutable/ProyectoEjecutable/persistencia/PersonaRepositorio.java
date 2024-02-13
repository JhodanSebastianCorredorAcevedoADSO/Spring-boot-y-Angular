package ProyectoEjecutable.ProyectoEjecutable.persistencia;

import ProyectoEjecutable.ProyectoEjecutable.model.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio  extends CrudRepository<Persona, Integer> {

    Iterable<Persona> findByActivo(boolean activo);

    @Query(value = "SELECT * FROM PERSONA  WHERE nombre LIKE %:nombre%", nativeQuery = true)
    Iterable<Persona> findByNombre(@Param("nombre") String nombre);

}
