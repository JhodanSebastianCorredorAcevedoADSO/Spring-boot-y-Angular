package ProyectoEjecutable.ProyectoEjecutable.persistencia;

import ProyectoEjecutable.ProyectoEjecutable.model.TipoDocumento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepositorio extends CrudRepository<TipoDocumento, Integer> {

}
