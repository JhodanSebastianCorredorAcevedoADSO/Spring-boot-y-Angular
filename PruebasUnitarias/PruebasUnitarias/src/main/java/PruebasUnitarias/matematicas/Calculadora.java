package PruebasUnitarias.matematicas;

public class Calculadora {

    private double valor1;
    private double valor2;

    public Calculadora(double valor1, double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public double sumar() {
        return valor1 + valor2;
    }

    public double resta() {
        return valor1 - valor2;
    }

    public double multiplicar() {
        return valor1 * valor2;
    }
}
