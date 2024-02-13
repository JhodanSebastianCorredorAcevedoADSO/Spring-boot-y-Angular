package MicroServicioPersona.servicio.impl;

import MicroServicioPersona.converter.PersonaConverter;
import MicroServicioPersona.dto.PersonaDTO;
import MicroServicioPersona.dto.TipoDocumentoDTO;
import MicroServicioPersona.model.Persona;
import MicroServicioPersona.repositorio.PersonaRepositorio;
import MicroServicioPersona.repositorio.TipoDocumentoRepositorioRemoto;
import MicroServicioPersona.servicio.ConsultaServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ConsultaServicioPersonaImpl implements ConsultaServicioPersona {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Autowired
    private TipoDocumentoRepositorioRemoto tipoDocumentoRepositorioRemoto;

    @Autowired
    private PersonaConverter personaConverter;

    @Override
    public List<PersonaDTO> findAll() {

        List<Persona> personas = (List<Persona>) personaRepositorio.findAll();
        List<TipoDocumentoDTO> listaTipoDocumentos = tipoDocumentoRepositorioRemoto.findAll();
        return personaConverter.toDTO(personas,listaTipoDocumentos);
    }

    @Override
    public List<PersonaDTO> findByActivo(boolean activo) {
        List<Persona> personas =  (List<Persona>) personaRepositorio.findByActivo(activo);
        List<TipoDocumentoDTO> listaTipoDocumentos = tipoDocumentoRepositorioRemoto.findAll();
        return personaConverter.toDTO(personas,listaTipoDocumentos);
    }

    @Override
    public List<PersonaDTO> findByNombre(String nombre) {
        List<Persona> personas = (List<Persona>) personaRepositorio.findByNombre(nombre);
        List<TipoDocumentoDTO> listaTipoDocumentos = tipoDocumentoRepositorioRemoto.findAll();
        return personaConverter.toDTO(personas,listaTipoDocumentos);
    }

}