package co.com.acueducto.sish.models.seguridad;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

/***
 *  Clase de definición de la tabla de los roles del sistema
 */
@Entity
@Table(name = "roles")
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
    @Getter @Setter
    private String rol;

    /***
     *Descripción del rol
     */
    @Column(name = "descripcion", nullable = false)
    @Getter @Setter
    private String descripcion;

    /***
     *Determina si el rol esta activo S/N
     */
    @Column(name = "activo", nullable = false)
    @Getter @Setter
    private String activo;

    /***
     * Fecha en que fue creado el rol en BD.
     */
    @Column(name = "fecha_creacion", nullable = false)
    @Getter @Setter
    private Date fechaCreacion;

    /***
     * Fecha que asigna el sistema de forma automática cuando se cambia el valor que posee el campo activo
     */
    @Column(name = "fecha_estado", nullable = false)
    @Getter @Setter
    private Date fechaEstado;
}
