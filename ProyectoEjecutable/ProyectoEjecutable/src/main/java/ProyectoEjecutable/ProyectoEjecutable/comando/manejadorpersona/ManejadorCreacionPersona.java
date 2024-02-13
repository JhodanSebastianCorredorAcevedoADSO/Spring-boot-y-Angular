package ProyectoEjecutable.ProyectoEjecutable.comando.manejadorpersona;

import ProyectoEjecutable.ProyectoEjecutable.aplicacion.ComandoRespuesta;
import ProyectoEjecutable.ProyectoEjecutable.aplicacion.Impl.ManejadorComandoRespuesta;
import ProyectoEjecutable.ProyectoEjecutable.comando.converterpersona.PersonaConverter;
import ProyectoEjecutable.ProyectoEjecutable.comando.dto.PersonaDTO;
import ProyectoEjecutable.ProyectoEjecutable.servicio.persona.creacion.CreacionServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCreacionPersona implements ManejadorComandoRespuesta<PersonaDTO, ComandoRespuesta<Integer>> {

    @Autowired
    private CreacionServicioPersona creacionServicioPersona;

    @Autowired
    private PersonaConverter personaConverter;

    // se encarga de estar pendiente de toda la transacion
    @Override
    public ComandoRespuesta<Integer> ejecutar(PersonaDTO personaDTO){
        return new ComandoRespuesta<Integer>(creacionServicioPersona.ejecutar(personaConverter.crear(personaDTO)));
    }
}