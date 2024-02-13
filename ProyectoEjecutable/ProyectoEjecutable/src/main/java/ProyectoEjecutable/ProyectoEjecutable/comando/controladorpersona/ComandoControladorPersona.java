package ProyectoEjecutable.ProyectoEjecutable.comando.controladorpersona;

import ProyectoEjecutable.ProyectoEjecutable.aplicacion.ComandoRespuesta;
import ProyectoEjecutable.ProyectoEjecutable.comando.dto.PersonaDTO;
import ProyectoEjecutable.ProyectoEjecutable.comando.manejadorpersona.ManejadorActualizacionPersona;
import ProyectoEjecutable.ProyectoEjecutable.comando.manejadorpersona.ManejadorCreacionPersona;
import ProyectoEjecutable.ProyectoEjecutable.comando.manejadorpersona.ManejadorEiliminacionPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/persona")
public class ComandoControladorPersona {

    @Autowired
    private ManejadorCreacionPersona manejadorCreacionPersona;
    @Autowired
    private ManejadorActualizacionPersona manejadorActualizacionPersona;
    @Autowired
    private ManejadorEiliminacionPersona manejadorEiliminacionPersona;


    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody PersonaDTO persona){
        return manejadorCreacionPersona.ejecutar(persona);
    }

    @PutMapping("/{idPersona}")
    public ComandoRespuesta<Integer> actualizar(@PathVariable Integer idPersona, @RequestBody PersonaDTO persona){
        persona.setIdPersona((idPersona));
        return manejadorActualizacionPersona.ejecutar(persona);
    }

    @DeleteMapping("/{idPersona}")
    public ComandoRespuesta<Integer> eliminar(@PathVariable Integer idPersona){
        return manejadorEiliminacionPersona.ejecutar(idPersona);
    }

}
