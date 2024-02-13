package MicroServicio.repositorio;

import MicroServicio.model.TipoDocumento;
import org.springframework.data.repository.CrudRepository;

public interface TipoDocumentoRepositorio  extends CrudRepository<TipoDocumento, Integer> {
}
