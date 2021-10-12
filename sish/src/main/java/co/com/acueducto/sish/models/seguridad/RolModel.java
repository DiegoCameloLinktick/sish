package co.com.acueducto.sish.models.seguridad;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/***
 *  Clase de definición de la tabla de los roles del sistema
 */
@Entity
@Table(name = "roles")
public class RolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", unique = true, nullable = false)
    @Getter @Setter
    private Long idRol;

    @Column(name = "rol", nullable = false)
    @Getter @Setter
    private String rol;

    @Column(name = "descripcion", nullable = false)
    @Getter @Setter
    private String descripcion;

    @Column(name = "activo", nullable = false)
    @Getter @Setter
    private String activo;
}
