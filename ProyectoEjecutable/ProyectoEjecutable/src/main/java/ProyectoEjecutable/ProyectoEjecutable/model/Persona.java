package ProyectoEjecutable.ProyectoEjecutable.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
public class Persona {

    @Id
    // se utiliza para generar una secuencia en el sql
    @GeneratedValue
    @Column(name = "idpersona")
    private Integer idPersona;

    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @ManyToOne
    @JoinColumn(name = "idtipodocumento")
    private TipoDocumento tipoDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "activo")
    private boolean activo;

    // esto es un higger
    // leisi es perezoso
    public TipoDocumento getTipoDocumento(){
        if(tipoDocumento == null){
            tipoDocumento = new TipoDocumento();
        }
        return tipoDocumento;
    }
}
