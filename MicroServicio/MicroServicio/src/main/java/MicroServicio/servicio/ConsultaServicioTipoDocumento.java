package MicroServicio.servicio;

import MicroServicio.model.TipoDocumento;

import java.util.List;

public interface ConsultaServicioTipoDocumento {

    List<TipoDocumento> findAll();
}
