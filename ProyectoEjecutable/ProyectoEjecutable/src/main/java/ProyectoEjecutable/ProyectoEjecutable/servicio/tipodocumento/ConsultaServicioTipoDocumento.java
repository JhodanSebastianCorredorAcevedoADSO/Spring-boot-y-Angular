package ProyectoEjecutable.ProyectoEjecutable.servicio.tipodocumento;

import ProyectoEjecutable.ProyectoEjecutable.model.TipoDocumento;

public interface ConsultaServicioTipoDocumento {

    Iterable<TipoDocumento> findAll();

}
