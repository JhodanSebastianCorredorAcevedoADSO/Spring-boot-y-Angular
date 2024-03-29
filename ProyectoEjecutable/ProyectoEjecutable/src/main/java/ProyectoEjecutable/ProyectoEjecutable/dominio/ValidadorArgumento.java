package ProyectoEjecutable.ProyectoEjecutable.dominio;


import ProyectoEjecutable.ProyectoEjecutable.dominio.excepcion.ExcepcionLongitudValor;
import ProyectoEjecutable.ProyectoEjecutable.dominio.excepcion.ExcepcionValorInvalido;
import ProyectoEjecutable.ProyectoEjecutable.dominio.excepcion.ExcepcionValorObligatorio;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidadorArgumento {

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }

    public static void validarLongitud(String valor, int longitud, String mensaje) {
        if (valor.length() < longitud) {
            throw new ExcepcionLongitudValor(mensaje);
        }
    }

    public static void validarLongitudMaxima(String valor, int longitud, String mensaje) {
        if (valor.length() > longitud) {
            throw new ExcepcionLongitudValor(mensaje);
        }
    }

    public static <T> void validarNoVacio(List<T> lista, String mensaje) {
        if (lista.isEmpty()) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }

    public static void validarPositivo(Double valor, String mensaje) {
        if (valor <= 0) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarPositivo(int valor, String mensaje) {
        if (valor <= 0) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarNegativo(int valor, String mensaje) {
        if (valor < 0) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarNegativo(double valor, String mensaje) {
        if (valor < 0) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarIgual(Double valor, Double valorEsperado, String mensaje) {
        if (!valor.equals(valorEsperado)) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarLongitudMinima(Object valor, int longitudMinima, String mensaje) {
        if (valor.toString().length() < longitudMinima) {
            throw new ExcepcionLongitudValor(mensaje);
        }
    }

    public static void validarMenor(LocalDateTime fechaInicial, LocalDateTime fechaFinal, String mensaje) {
        if (fechaInicial.toLocalDate().isAfter(fechaFinal.toLocalDate())) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarMenor(Long numeroInicial, Long numeroFinal, String mensaje) {
        if (numeroInicial > numeroFinal) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarMenor(float numeroInicial, float numeroFinal, String mensaje) {
        if (numeroInicial > numeroFinal) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarMenor(int numeroInicial, int numeroFinal, String mensaje) {
        if (numeroInicial > numeroFinal) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarMayor(int numeroInicial, int numeroFinal, String mensaje) {
        if (numeroInicial < numeroFinal) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarMayor(float numeroInicial, float numeroFinal, String mensaje) {
        if (numeroInicial < numeroFinal) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarMayor(double numeroInicial, double numeroFinal, String mensaje) {
        if (numeroInicial < numeroFinal) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarRegex(String correoElectronico, String regex, String mensaje) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correoElectronico);

        if (!matcher.matches()) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static <E extends Enum<E>> E validarValido(String valor, Class<E> enumAObtener, String mensaje) {
        E enumObtenido = null;
        if (null != valor) {
            Optional<E> resultadoOpcional = Arrays.stream(enumAObtener.getEnumConstants())
                    .filter(resultado -> resultado.toString().equals(valor)).findFirst();

            enumObtenido = resultadoOpcional.map(resultado -> resultado)
                    .orElseThrow(() -> new ExcepcionValorInvalido(mensaje));

        }
        return enumObtenido;
    }

    public static void validarNumerico(String valor, String mensaje) {
        try {
            Long.parseLong(valor);
        } catch (NumberFormatException numberFormatException) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
}
