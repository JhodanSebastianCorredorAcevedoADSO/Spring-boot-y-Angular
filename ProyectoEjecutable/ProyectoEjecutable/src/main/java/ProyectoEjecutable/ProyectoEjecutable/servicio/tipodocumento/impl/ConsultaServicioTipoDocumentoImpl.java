package ProyectoEjecutable.ProyectoEjecutable.servicio.tipodocumento.impl;


import ProyectoEjecutable.ProyectoEjecutable.model.TipoDocumento;
import ProyectoEjecutable.ProyectoEjecutable.persistencia.TipoDocumentoRepositorio;
import ProyectoEjecutable.ProyectoEjecutable.servicio.tipodocumento.ConsultaServicioTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServicioTipoDocumentoImpl implements ConsultaServicioTipoDocumento {

    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;

    @Override
    public Iterable<TipoDocumento> findAll(){

        return tipoDocumentoRepositorio.findAll();
    }
}
