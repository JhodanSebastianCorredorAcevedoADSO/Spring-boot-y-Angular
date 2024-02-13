package ProyectoEjecutable.ProyectoEjecutable.aplicacion.Impl;


import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComando<C> {

    @Transactional
    void ejecutar(C comando);
}
