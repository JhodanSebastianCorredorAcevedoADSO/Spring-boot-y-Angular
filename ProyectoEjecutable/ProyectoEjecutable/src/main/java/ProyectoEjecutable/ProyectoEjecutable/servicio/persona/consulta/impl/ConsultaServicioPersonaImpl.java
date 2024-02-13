package ProyectoEjecutable.ProyectoEjecutable.servicio.persona.consulta.impl;

import ProyectoEjecutable.ProyectoEjecutable.model.Persona;
import ProyectoEjecutable.ProyectoEjecutable.persistencia.PersonaRepositorio;
import ProyectoEjecutable.ProyectoEjecutable.servicio.persona.consulta.ConsultaServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConsultaServicioPersonaImpl implements ConsultaServicioPersona {

    @Autowired
    private PersonaRepositorio repositorio;

    @Override
    public Iterable<Persona> findAll(){
        return  repositorio.findAll();
    }

    @Override
    public Iterable<Persona> findByActivo(boolean activo){
        return repositorio.findByActivo(activo);
    }

    @Override
    public  Iterable<Persona> findByNombre(String nombre){
        return  repositorio.findByNombre(nombre);
    }

    @Override
    public Persona findById(Integer idPersona){
        return repositorio.findById(idPersona).orElse(null);
    }
}
