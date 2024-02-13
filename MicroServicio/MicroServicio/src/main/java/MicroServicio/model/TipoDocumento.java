package MicroServicio.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tipodocumento")
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumento {

    @Id
    @Column(name = "idtipodocumento")
    private Integer idTipoDocumento;

    @Column(name = "nombredocumento")
    private String nombreDocumento;

    // trasciende no lo pone en la base de datos
    @Transient
    private Integer port;


}
