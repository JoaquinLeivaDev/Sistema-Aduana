package cl.duocuc.aduana_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

@Table(name = "documentos")


public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private Long idDocumento;

    /*
     * RUT del pasajero.
     * Se define como obligatorio, de largo 10 y único.
     */
    @Column(name = "tipo")
    private String tipo;

    /*
     * Nombres del pasajero.
     */
    @Column(name = "estadoValidacion")
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
