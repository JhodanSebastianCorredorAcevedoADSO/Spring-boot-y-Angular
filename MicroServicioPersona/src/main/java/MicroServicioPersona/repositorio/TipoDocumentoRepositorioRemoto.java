package MicroServicioPersona.repositorio;

import MicroServicioPersona.dto.TipoDocumentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name="servicio-tipo-documento")
public interface TipoDocumentoRepositorioRemoto {

    @GetMapping("/v1/tipo-documento")
    public List<TipoDocumentoDTO> findAll();
}
