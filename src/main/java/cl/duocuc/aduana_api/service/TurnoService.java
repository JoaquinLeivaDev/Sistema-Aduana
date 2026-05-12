package cl.duocuc.aduana_api.service;

import cl.duocuc.aduana_api.model.Turno;
import cl.duocuc.aduana_api.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repository;

    // Obtener todos los turnos
    public List<Turno> obtenerTodos() {
        return repository.findAll();
    }

    // Registrar/Asignar un nuevo turno
    public Turno asignarTurno(Turno turno) {
        // AQUÍ VA LA LÓGICA DE NEGOCIO (REGLA DE ORO DE LA RÚBRICA)
        // Ejemplo: Validar que el número de turno no esté duplicado
        // O asignar la ventanilla con menos carga actual.
        turno.setEstado("En espera"); // Estado inicial
        return repository.save(turno);
    }

    // Cambiar estado del turno (ej: de "En espera" a "Atendido")
    public Turno actualizarEstado(Long id, String nuevoEstado) {
        Turno turno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        turno.setEstado(nuevoEstado);
        return repository.save(turno);
    }
}