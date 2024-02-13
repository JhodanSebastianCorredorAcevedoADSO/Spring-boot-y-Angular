package Apirest.Proyecto.HelloWorlds;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/documento-identidad") // api para consultar el documento de identidad

@RestController
public class HelloApi {

    // Api
    @GetMapping("/status")
    public String showHealth(){
        //Muestra de pantalla
        return "it works!!!";

    }
}