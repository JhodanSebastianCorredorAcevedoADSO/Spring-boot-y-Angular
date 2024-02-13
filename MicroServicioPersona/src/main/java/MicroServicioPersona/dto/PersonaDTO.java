package MicroServicioPersona.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDTO {

    private Integer idPersona;
    private String numeroDocumento;
    private TipoDocumentoDTO tipoDocumentoDTO;
    private String nombre;
    private String apellido;
    private boolean activo;

}