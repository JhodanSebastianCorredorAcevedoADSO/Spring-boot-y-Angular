package ProyectoEjecutable.ProyectoEjecutable.consulta.tipodocumento;

import ProyectoEjecutable.ProyectoEjecutable.model.TipoDocumento;
import ProyectoEjecutable.ProyectoEjecutable.servicio.tipodocumento.ConsultaServicioTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/tipo-documento")
public class ControladorConsultaTipoDocumento {

    // interfaz que se instancia y se le hace
    // una inyeccion de dependencias
    @Autowired
    private ConsultaServicioTipoDocumento consultaServicioTipoDocumento;


    @Secured("{ROLE_ADMIN}")
    @GetMapping
    public Iterable<TipoDocumento> findAll(){

        return consultaServicioTipoDocumento.findAll();
    }
}
