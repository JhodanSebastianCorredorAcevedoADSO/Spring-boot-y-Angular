package ProyectoEjecutable.ProyectoEjecutable.servicio.persona.eliminar.Impl;

import ProyectoEjecutable.ProyectoEjecutable.model.Persona;
import ProyectoEjecutable.ProyectoEjecutable.persistencia.PersonaRepositorio;
import ProyectoEjecutable.ProyectoEjecutable.servicio.persona.eliminar.EliminacionServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EliminacionServicioPersonaImpl implements EliminacionServicioPersona {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Override
    public Integer ejecutar(Persona persona){
        personaRepositorio.delete(persona);
        return persona.getIdPersona();
    }
}
