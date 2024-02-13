package ProyectoEjecutable.ProyectoEjecutable.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tipodocumento")
@NoArgsConstructor
@AllArgsConstructor

public class TipoDocumento {

    @Id
    @Column(name = "idtipodocumento")
    private Integer idTipoDocumento;

    @Column( name = "nombredocumento")
    private String nombreDocumento;
}
