package cl.duocuc.aduana_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "control_migratorio")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ControlMigratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_control")
    private Long id;

    @Column(nullable = false, length = 20)
    private String estado; // Pendiente, Aprobado, Rechazado

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @OneToOne
    @JoinColumn(name = "id_pasajero", nullable = false)
    private Pasajero pasajero;
}