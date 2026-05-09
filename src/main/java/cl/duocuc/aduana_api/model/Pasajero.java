package cl.duocuc.aduana_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

/*
 * @Entity indica que esta clase será una entidad JPA
 * y se mapeará a una tabla de la base de datos.
 */
@Entity

/*
 * @Table define el nombre exacto de la tabla en la BD.
 */
@Table(name = "pasajero")

/*
 * Lombok:
 * @Getter/@Setter generan los métodos de acceso.
 * @NoArgsConstructor genera constructor vacío.
 * @AllArgsConstructor genera constructor con todos los atributos.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pasajero {

    /*
     * Clave primaria de la entidad.
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     * permite que la BD genere el "id" automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pasajero")
    private Long idPasajero;

    /*
     * RUT del pasajero.
     * Se define como obligatorio, de largo 10 y único.
     */
    @Column(name = "rut", nullable = false, length = 10, unique = true)
    private String rut;

    /*
     * Nombres del pasajero.
     */
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    /*
     * Apellidos del pasajero.
     */
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    /*
     * Fecha de nacimiento del pasajero.
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    /*
     * Correo electrónico del pasajero.
     */
    @Column(name = "correo", length = 100, unique = true)
    private String correo;
}