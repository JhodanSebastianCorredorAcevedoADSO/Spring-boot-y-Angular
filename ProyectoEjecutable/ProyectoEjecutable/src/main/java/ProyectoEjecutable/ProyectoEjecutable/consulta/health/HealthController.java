package ProyectoEjecutable.ProyectoEjecutable.consulta.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/health")
@RestController
public class HealthController {

    @GetMapping
    public String showStatus(){
        return  "It works!";
    }

}
