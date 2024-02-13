package ProyectoEjecutable.ProyectoEjecutable.comando.manejadorpersona;

import ProyectoEjecutable.ProyectoEjecutable.aplicacion.ComandoRespuesta;
import ProyectoEjecutable.ProyectoEjecutable.aplicacion.Impl.ManejadorComandoRespuesta;
import ProyectoEjecutable.ProyectoEjecutable.comando.converterpersona.PersonaConverter;
import ProyectoEjecutable.ProyectoEjecutable.comando.dto.PersonaDTO;
import ProyectoEjecutable.ProyectoEjecutable.servicio.persona.actualizar.ActualizacionServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizacionPersona implements ManejadorComandoRespuesta<PersonaDTO, ComandoRespuesta<Integer>> {

    @Autowired
    private ActualizacionServicioPersona actualizacionServicioPersona;

    @Autowired
    private PersonaConverter personaConverter;

    @Override
    public ComandoRespuesta<Integer> ejecutar(PersonaDTO personaDTO) {
        return new ComandoRespuesta<Integer>(actualizacionServicioPersona.ejecutar(personaConverter.actualizar(personaDTO)));
    }
}