package ProyectoEjecutable.ProyectoEjecutable.model.seguridad;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Data
public class Rol {

    @Id
    private int idRol;

    @Column(unique = true, length = 20)
    private String nombreRol;
}
