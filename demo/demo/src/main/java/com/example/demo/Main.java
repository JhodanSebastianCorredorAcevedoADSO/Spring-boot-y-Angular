package com.example.demo;

public class Main {

    public  static void main(String[] args){
        personaDTO PersonaDTO = personaDTO.builder()
                .nombrePersona("Corredor")
                .apellidoPersona("Jhodan")
                .build();

        System.out.println(PersonaDTO.getNombrePersona() +"\n"+ PersonaDTO.getApellidoPersona());
    }

}
