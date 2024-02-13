package PruebasUnitarias.matematica;

import PruebasUnitarias.matematicas.Calculadora;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculadoraTest {
    // class para los escenarios de pruueba

    @Test
    public void sumarDosNumeros(){
        Calculadora calculadora = new Calculadora(5,4);
        double valorActual = calculadora.sumar();
        double valorEsperado = 9;
        Assert.assertEquals(valorEsperado, valorActual, 0);
    }

    @Test
    public void restarDosNumeros(){
        Calculadora calculadora = new Calculadora(10,4);
        double valorActual = calculadora.resta();
        double valorEsperado = 6;
        Assert.assertEquals(valorEsperado, valorActual, 0);
    }

    @Test
    public void multiplicarDosNumeros(){
        Calculadora calculadora = new Calculadora(80,40);
        double valorActual = calculadora.multiplicar();
        double valorEsperado = 3200;
        Assert.assertEquals(valorEsperado, valorActual, 0);
    }
}
