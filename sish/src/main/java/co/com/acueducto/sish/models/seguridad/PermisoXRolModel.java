package co.com.acueducto.sish.models.seguridad;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/***
 *  Clase de definición de la tabla de los permisos del sistema
 */
@Entity
@Table(name = "permisos_x_rol")
@ToString
public class PermisoXRolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso_x_rol", unique = true, nullable = false)
    @Getter
    @Setter
    private Long idPermisoXRol;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    @Getter @Setter
    private RolModel rol;

    @ManyToOne
    @JoinColumn(name = "id_permiso")
    @Getter @Setter
    private PermisoModel permiso;


}
