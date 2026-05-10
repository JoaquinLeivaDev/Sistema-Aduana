package cl.duocuc.aduana_api.repository;

import cl.duocuc.aduana_api.model.Declaracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclaracionRepository extends JpaRepository<Declaracion, Long> {
}