package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class personaDTO {

    Integer idPersona;
    String nombrePersona;
    String apellidoPersona;

}
