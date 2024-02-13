package MicroServicioPersona.servicio;

import MicroServicioPersona.dto.PersonaDTO;
import java.util.List;

public interface ConsultaServicioPersona {

    List<PersonaDTO> findAll();
    List<PersonaDTO> findByActivo(boolean activo);
    List<PersonaDTO> findByNombre(String nombre);
}
