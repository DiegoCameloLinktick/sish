package co.com.acueducto.sish.models.seguridad;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/***
 *  Clase de definición de la tabla de los permisos del sistema
 */
@Entity
@Table(name = "permisos")
@ToString
public class PermisoModel {
    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso", unique = true, nullable = false)
    @Getter
    @Setter
    private Long idPermiso;

    /***
     * Nombre del permiso
     */
    @Column(name = "permiso", nullable = false)
    @Getter @Setter
    private String permiso;

    /***
     *Descripción del permiso
     */
    @Column(name = "descripcion", nullable = false)
    @Getter @Setter
    private String descripcion;

    /***
     *Determina si el permiso esta activo S/N
     */
    @Column(name = "activo", nullable = false)
    @Getter @Setter
    private String activo;

    /***
     * Fecha cuando se cambia el valor que posee el campo activo
     */
    @Column(name = "fecha_estado")
    @Getter @Setter
    private Timestamp fechaEstado;

    /***
     * Usuario que realizó la modificación del campo activo
     */
    @Column(name = "usuario_estado")
    @Getter @Setter
    private String usuarioEstado;
}
