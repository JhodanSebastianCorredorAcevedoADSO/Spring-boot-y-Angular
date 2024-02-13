package Apirest.Proyecto.Calculadora;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/calculadora") // api de consultar
@RestController

// spring framework utilida
public class CalculadoraApi {

    @GetMapping("sumar/{valor1}/{valor2}")
    public int sumar(@PathVariable("valor1") Integer valor1, @PathVariable("valor2") Integer valor2){
        return valor1 + valor2;
    }

    @GetMapping("resta/{valor1}/{valor2}")
    public int resta(@PathVariable("valor1") Integer valor1, @PathVariable("valor2") Integer valor2){
        return valor1 - valor2;
    }
    @GetMapping("multiplicar/{valor1}/{valor2}")
    public int multiplicar(@PathVariable("valor1") Integer valor1, @PathVariable("valor2") Integer valor2){
        return valor1 * valor2;
    }

    @GetMapping("dividir/{valor1}/{valor2}")
    public int dividir(@PathVariable("valor1") Integer valor1, @PathVariable("valor2") Integer valor2){
        return valor1 / valor2;
    }

}
