package MicroServicio.consulta;

import MicroServicio.model.TipoDocumento;
import MicroServicio.servicio.ConsultaServicioTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/tipo-documento")
public class ControladorConsultaTipoDocumento {

    @Autowired
    private ConsultaServicioTipoDocumento consultaServicioTipoDocumento;

    @GetMapping
    public List<TipoDocumento> findAll(){
        return consultaServicioTipoDocumento.findAll();
    }
}
