package ProyectoEjecutable.ProyectoEjecutable.consulta.persona;

import ProyectoEjecutable.ProyectoEjecutable.model.Persona;
import ProyectoEjecutable.ProyectoEjecutable.servicio.persona.consulta.ConsultaServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/persona")
public class ControladorConsultaPersona {

    @Autowired
    private ConsultaServicioPersona consultaServicioPersona;

    @GetMapping
    Iterable<Persona> findAll(){
        return  consultaServicioPersona.findAll();
    }

    @GetMapping("/{idPersona}")
    Persona findById(@PathVariable Integer  idPersona){
        return  consultaServicioPersona.findById(idPersona);
    }

    @Secured("{ROLE_ADMIN}")

    @GetMapping("/segun-activo/{activo}")
    Iterable<Persona> findByActivo(@PathVariable boolean activo){
        return consultaServicioPersona.findByActivo(activo);
    }

    @Secured("{ROLE_ADMIN}")

    @GetMapping("/segun-activo/{nombre}")
    Iterable<Persona> findByNombre(@PathVariable String nombre){
        return consultaServicioPersona.findByNombre(nombre);
    }
}
