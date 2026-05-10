package cl.duocuc.aduana_api.repository;

import cl.duocuc.aduana_api.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Spring Data JPA creará la consulta SQL automáticamente
    // SELECT * FROM vehiculo WHERE patente = ?
    Vehiculo findByPatente(String patente);
}