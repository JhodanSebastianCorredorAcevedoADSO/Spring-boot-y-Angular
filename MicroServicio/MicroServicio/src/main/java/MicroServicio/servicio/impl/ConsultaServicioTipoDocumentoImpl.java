package MicroServicio.servicio.impl;

import MicroServicio.model.TipoDocumento;
import MicroServicio.repositorio.TipoDocumentoRepositorio;
import MicroServicio.servicio.ConsultaServicioTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaServicioTipoDocumentoImpl implements ConsultaServicioTipoDocumento {


    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;

    @Value("${server.port}")
    private Integer port;

    @Override
    public List<TipoDocumento> findAll() {
        List<TipoDocumento>  listaTipoDocumento = (List<TipoDocumento>)tipoDocumentoRepositorio.findAll();
        return listaTipoDocumento.stream().map(p -> {
            p.setPort(port);
            return p;
        }).collect(Collectors.toList());
    }

}
