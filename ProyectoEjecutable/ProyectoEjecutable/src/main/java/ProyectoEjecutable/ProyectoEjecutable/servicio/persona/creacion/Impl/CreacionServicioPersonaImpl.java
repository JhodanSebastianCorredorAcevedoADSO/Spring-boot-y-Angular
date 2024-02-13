package ProyectoEjecutable.ProyectoEjecutable.servicio.persona.creacion.Impl;

import ProyectoEjecutable.ProyectoEjecutable.dominio.excepcion.ExcepcionNoExisteRegistro;
import ProyectoEjecutable.ProyectoEjecutable.model.Persona;
import ProyectoEjecutable.ProyectoEjecutable.model.TipoDocumento;
import ProyectoEjecutable.ProyectoEjecutable.persistencia.PersonaRepositorio;
import ProyectoEjecutable.ProyectoEjecutable.persistencia.TipoDocumentoRepositorio;
import ProyectoEjecutable.ProyectoEjecutable.servicio.persona.creacion.CreacionServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreacionServicioPersonaImpl implements CreacionServicioPersona {

    public static final String NO_EXISTE_EL_DOCUMENTOP_DE_IDENTIDAD = "No existe el documentop de identidad";
    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;

    @Override
    public Integer ejecutar(Persona persona) {
        TipoDocumento tipoDocumento = buscarTipoDocumento(persona);
        persona.setTipoDocumento(tipoDocumento);
        personaRepositorio.save(persona);
        return persona.getIdPersona();
    }

    private TipoDocumento buscarTipoDocumento(Persona persona){
        TipoDocumento tipoDocumento = tipoDocumentoRepositorio.findById(persona.getTipoDocumento().getIdTipoDocumento()).orElse(null);
        // validacion cueando el documento no se encuentre y lanza una exepcion
        if(tipoDocumento == null){
            throw new ExcepcionNoExisteRegistro(NO_EXISTE_EL_DOCUMENTOP_DE_IDENTIDAD);
        }
        // deja pasar los datos si lo encuentra
        return tipoDocumento;
    }
}
