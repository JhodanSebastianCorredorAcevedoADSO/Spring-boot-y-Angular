package ProyectoEjecutable.ProyectoEjecutable.converterpersona;

import ProyectoEjecutable.ProyectoEjecutable.baseprueba.BasePrueba;
import ProyectoEjecutable.ProyectoEjecutable.comando.converterpersona.PersonaConverter;
import ProyectoEjecutable.ProyectoEjecutable.comando.dto.PersonaDTO;
import ProyectoEjecutable.ProyectoEjecutable.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonaConverterTest {

    public static final Integer ID_DOCUMENTO_CEDULA = 1;
    private static final String EL_TIPO_DE_DOCUMENTO_ES_OBLIGATORIO = "El tipo de documento es Obligatorio";
    private static final String EL_NUMERO_DE_DOCUMENTO_ES_OBLIGATORIO = "El numero de documento es Obligatorio";
    private static final String EL_NOMBRE_ES_OBLIGATORIO = "El nombre es Obligatorio";
    public static final String NUMERO_DOCUMENTO = "123";

    @Autowired
    private PersonaConverter personaConverter;

    @Test
    public void crearFallaTipoDocumentoObligatorio(){
        PersonaDTO personaDTO = new PersonaDTO();
        BasePrueba.assertThrows(() -> personaConverter.crear(personaDTO), ExcepcionValorObligatorio.class, EL_TIPO_DE_DOCUMENTO_ES_OBLIGATORIO);
    }

    @Test
    public void crearFallaNumeroDocumentoObligatorio(){
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setIdTipoDocumento((ID_DOCUMENTO_CEDULA));
        BasePrueba.assertThrows(() -> personaConverter.crear(personaDTO), ExcepcionValorObligatorio.class, EL_NUMERO_DE_DOCUMENTO_ES_OBLIGATORIO);
    }

    @Test
    public void crearFallaNombreObligatorio(){
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setIdTipoDocumento((ID_DOCUMENTO_CEDULA));
        personaDTO.setNumeroDocumento(NUMERO_DOCUMENTO);
        BasePrueba.assertThrows(() -> personaConverter.crear(personaDTO), ExcepcionValorObligatorio.class, EL_NOMBRE_ES_OBLIGATORIO);
    }
}
