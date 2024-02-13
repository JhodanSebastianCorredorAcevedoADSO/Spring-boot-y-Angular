package ProyectoEjecutable.ProyectoEjecutable.servicio.persona.creacion;

import ProyectoEjecutable.ProyectoEjecutable.model.Persona;

public interface CreacionServicioPersona {

    /**
     * Inserta una persona
     * @param persona
     * @return idPersona
     *
     */
    Integer ejecutar(Persona persona);
}
