package ProyectoEjecutable.ProyectoEjecutable.servicio.persona.consulta;

import ProyectoEjecutable.ProyectoEjecutable.model.Persona;

public interface ConsultaServicioPersona {

    Iterable<Persona> findAll();
    Iterable<Persona> findByActivo(boolean activo);
    Iterable<Persona> findByNombre(String nombre);
    Persona findById(Integer idPerspna);
}
