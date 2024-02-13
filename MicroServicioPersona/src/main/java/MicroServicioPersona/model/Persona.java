package MicroServicioPersona.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue
    @Column(name = "idpersona")
    private Integer idPersona;
    @Column(name = "numerodocumento")
    private String numeroDocumento;
    @Column(name = "idtipodocumento")
    private Integer idTipoDocumento;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "activo")
    private boolean activo;

}
