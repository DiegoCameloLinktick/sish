package co.com.acueducto.sish.models.seguridad;

import co.com.acueducto.sish.models.auditoria.Audit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/***
 *  Clase de definición de la tabla de los permisos realacionados a un rol del sistema
 */
@Entity
@Table(name = "permisos_x_rol")
@ToString
public class PermisoXRolModel extends Audit {
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


}
