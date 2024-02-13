package ProyectoEjecutable.ProyectoEjecutable.comando.manejadorpersona;

import ProyectoEjecutable.ProyectoEjecutable.aplicacion.ComandoRespuesta;
import ProyectoEjecutable.ProyectoEjecutable.aplicacion.Impl.ManejadorComandoRespuesta;
import ProyectoEjecutable.ProyectoEjecutable.comando.converterpersona.PersonaConverter;
import ProyectoEjecutable.ProyectoEjecutable.servicio.persona.eliminar.EliminacionServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEiliminacionPersona implements ManejadorComandoRespuesta<Integer, ComandoRespuesta<Integer>> {

    @Autowired
    private EliminacionServicioPersona eliminarServicioPersona;

    @Autowired
    private PersonaConverter personaConverter;

    @Override
    public ComandoRespuesta<Integer> ejecutar(Integer idPersona){
        return new ComandoRespuesta<Integer>(eliminarServicioPersona.ejecutar(personaConverter.eliminar(idPersona)));
    }

}
