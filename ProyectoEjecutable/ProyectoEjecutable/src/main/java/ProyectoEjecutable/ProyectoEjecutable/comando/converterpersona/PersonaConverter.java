package ProyectoEjecutable.ProyectoEjecutable.comando.converterpersona;

import ProyectoEjecutable.ProyectoEjecutable.comando.dto.PersonaDTO;
import ProyectoEjecutable.ProyectoEjecutable.dominio.ValidadorArgumento;
import ProyectoEjecutable.ProyectoEjecutable.model.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaConverter {

    private static final String EL_TIPO_DE_DOCUMENTO_ES_OBLIGATORIO = "El tipo de documento es Obligatorio";
    private static final String EL_NUMERO_DE_DOCUMENTO_ES_OBLIGATORIO = "El numero de documento es Obligatorio";
    private static final String EL_NOMBRE_ES_OBLIGATORIO = "El nombre es Obligatorio";
    private static final String EL_APELLIDO_ES_OBLIGATORIO = "El apellido es Obligatorio";
    private static final String EL_ID_NO_ES_VALIDO = "El id no es valido";
    private static final String EL_TIPO_DE_DOCUMENTO_NO_ES_VALIDO = "El tipo de documento no es válido";


    public Persona crear(PersonaDTO personaDTO){

        ValidadorArgumento.validarObligatorio(personaDTO.getIdTipoDocumento(),EL_TIPO_DE_DOCUMENTO_ES_OBLIGATORIO);
        ValidadorArgumento.validarPositivo(personaDTO.getIdTipoDocumento(),EL_TIPO_DE_DOCUMENTO_NO_ES_VALIDO);
        ValidadorArgumento.validarObligatorio(personaDTO.getNumeroDocumento(),EL_NUMERO_DE_DOCUMENTO_ES_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(personaDTO.getNombre(),EL_NOMBRE_ES_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(personaDTO.getApellido(),EL_APELLIDO_ES_OBLIGATORIO);
        Persona persona = new Persona();

        // atributos de persona
        persona.getTipoDocumento().setIdTipoDocumento(personaDTO.getIdTipoDocumento());
        persona.setNumeroDocumento(personaDTO.getNumeroDocumento());
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setActivo(true);

        return persona;
    }

    public Persona actualizar(PersonaDTO personaDTO){
        ValidadorArgumento.validarPositivo(personaDTO.getIdPersona(), EL_ID_NO_ES_VALIDO);
        ValidadorArgumento.validarObligatorio(personaDTO.getIdTipoDocumento(),EL_TIPO_DE_DOCUMENTO_ES_OBLIGATORIO);
        ValidadorArgumento.validarPositivo(personaDTO.getIdTipoDocumento(),EL_NUMERO_DE_DOCUMENTO_ES_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(personaDTO.getNombre(),EL_NOMBRE_ES_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(personaDTO.getApellido(),EL_APELLIDO_ES_OBLIGATORIO);
        Persona persona = new Persona();

        // atributos de persona
        persona.setIdPersona(personaDTO.getIdPersona());
        persona.getTipoDocumento().setIdTipoDocumento(personaDTO.getIdTipoDocumento());
        persona.setNumeroDocumento(personaDTO.getNumeroDocumento());
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setActivo(personaDTO.isActivo());

        return persona;
    }

    public Persona eliminar (Integer idPersona){
        ValidadorArgumento.validarPositivo(idPersona, EL_ID_NO_ES_VALIDO);
        Persona persona = new Persona();
        persona.setIdPersona(idPersona);
        return persona;
    }

}
