package co.com.acueducto.sish.models.seguridad;

import co.com.acueducto.sish.models.auditoria.Audit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/***
 *  Clase de definición de la tabla de los permisos del sistema
 */
@Entity
@Table(name = "permisos")
@ToString
public class PermisoModel extends Audit {
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


}
