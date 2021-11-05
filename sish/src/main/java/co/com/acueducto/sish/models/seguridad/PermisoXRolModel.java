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
public class PermisoXRolModel  {
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
    @Column(name = "id_rol", nullable = false)
    @Getter @Setter
    private RolModel idRol;

    /***
     * Identificador del permiso
     */
    @ManyToOne
    @Column(name = "id_permiso",  nullable = false)
    @Getter @Setter
    private PermisoModel permiso;


}
