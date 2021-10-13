package co.com.acueducto.sish.models.seguridad;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/***
 *  Clase de definición de la tabla de los permisos realacionados a un rol del sistema
 */
@Entity
@Table(name = "permisos_x_rol")
@ToString
public class PermisoXRolModel {
    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso_x_rol", unique = true, nullable = false)
    @Getter
    @Setter
    private Long idPermisoXRol;

    /***
     * Identificador del rol
     */
    @ManyToOne
    @JoinColumn(name = "id_rol")
    @Getter @Setter
    private RolModel rol;

    /***
     * Identificador del permiso
     */
    @ManyToOne
    @JoinColumn(name = "id_permiso")
    @Getter @Setter
    private PermisoModel permiso;

    /***
     *Determina si el permiso en el rol esta activo S/N
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
