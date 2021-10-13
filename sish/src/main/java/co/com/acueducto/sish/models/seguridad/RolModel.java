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
     * Fecha en que fue creado
     */
    @Column(name = "fecha_creacion")
    @Getter @Setter
    private Timestamp fechaCreacion;

    /***
     * Fecha en que fue modificado
     */
    @Column(name = "fecha_modificacion")
    @Getter @Setter
    private Timestamp fechaModificacion;

    /***
     * Fecha cuando se cambia el valor que posee el campo activo
     */
    @Column(name = "fecha_estado")
    @Getter @Setter
    private Timestamp fechaEstado;

    /***
     * Usuario que realizó la creaciòn
     */
    @Column(name = "usuario_creacion")
    @Getter @Setter
    private String usuarioCreacion;

    /***
     * Usuario que realizó la modificación
     */
    @Column(name = "usuario_modificacion")
    @Getter @Setter
    private String usuarioModificacion;

    /***
     * Usuario que realizó la modificación del campo activo
     */
    @Column(name = "usuario_estado")
    @Getter @Setter
    private String usuarioEstado;
}
