package co.com.acueducto.sish.models.seguridad;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/***
 *  Clase de definición de la tabla de los roles del sistema
 */
@Entity
@Table(name = "roles")
@ToString
public class RolModel {
    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", unique = true, nullable = false)
    @Getter @Setter
    private Integer idRol;

    /***
     * Nombre del rol
     */
    @Column(name = "rol", nullable = false)
    @NotNull(message = "El nombre del rol no puede ser nulo")
    @Size(min = 2, message = "El nombre del rol debe tener al menos dos caracteres")
    @Getter @Setter
    private String rol;

    /***
     *Descripción del rol
     */
    @Column(name = "descripcion", nullable = false)
    @NotNull(message = "La descripción del rol no puede ser nula")
    @Getter @Setter
    private String descripcion;

    /***
     *Determina si el rol esta activo S/N
     */
    @Column(name = "activo", nullable = false)
    @NotNull(message = "Activo no puede ser nulo")
    @Size(max = 1, message = "Activo debe tener maxímo un caracter")
    @Getter @Setter
    private String activo;

    /***
     * Fecha en que fue creado el rol en BD.
     */
    @Column(name = "fecha_creacion", nullable = false)
    @NotNull(message = "La fecha de creación no puede ser nula")
    @Getter @Setter
    private Timestamp fechaCreacion;

    /***
     * Fecha que asigna el sistema de forma automática cuando se cambia el valor que posee el campo activo
     */
    @Column(name = "fecha_estado", nullable = false)
    @NotNull(message = "La fecha de estado no puede ser nula")
    @Getter @Setter
    private Timestamp fechaEstado;
}
