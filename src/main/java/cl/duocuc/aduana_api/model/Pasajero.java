package cl.duocuc.aduana_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pasajero")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Te recomiendo IDENTITY para bases de datos modernas
    @Column(name = "id_pasajero")
    private Long idPasajero;

    @Column(name = "rut", nullable = false, length = 12, unique = true) // Cuidado con el largo del RUT!
    private String rut;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNac;

    @Column(name = "correo", length = 100, unique = true)
    private String correo;

    // Un Pasajero tiene muchos documentos
    @OneToMany(mappedBy = "pasajero", cascade = CascadeType.ALL)
    private List<Documento> documentos = new ArrayList<>();

    // Un Pasajero tiene un turno
    @OneToOne(mappedBy = "pasajero", cascade = CascadeType.ALL)
    private Turno turno;

    // Un Pasajero tiene muchas declaraciones
    @OneToMany(mappedBy = "pasajero", cascade = CascadeType.ALL)
    private List<Declaracion> declaraciones = new ArrayList<>();
}