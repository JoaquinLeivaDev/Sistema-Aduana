package cl.duocuc.aduana_api.service;

import cl.duocuc.aduana_api.model.Documento;
import cl.duocuc.aduana_api.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService {
    @Autowired private DocumentoRepository repository;

    public Documento registrarDocumento(Documento documento) {
        // Lógica de negocio: Validar que sea un PDF o imagen válida
        return repository.save(documento);
    }
}