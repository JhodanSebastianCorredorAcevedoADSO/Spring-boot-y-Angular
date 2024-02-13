package ProyectoEjecutable.ProyectoEjecutable.servicio.persona.actualizar.Impl;

import ProyectoEjecutable.ProyectoEjecutable.model.Persona;
import ProyectoEjecutable.ProyectoEjecutable.persistencia.PersonaRepositorio;
import ProyectoEjecutable.ProyectoEjecutable.servicio.persona.actualizar.ActualizacionServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActualizacionServicioPersonaImpl implements ActualizacionServicioPersona {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Override
    public Integer ejecutar(Persona persona) {
        personaRepositorio.save(persona);
        return persona.getIdPersona();
    }

}
