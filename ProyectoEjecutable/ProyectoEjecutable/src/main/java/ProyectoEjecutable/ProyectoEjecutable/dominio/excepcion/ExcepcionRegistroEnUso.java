package ProyectoEjecutable.ProyectoEjecutable.dominio.excepcion;

public class ExcepcionRegistroEnUso extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionRegistroEnUso(String message) {
		super(message);
	}

}
