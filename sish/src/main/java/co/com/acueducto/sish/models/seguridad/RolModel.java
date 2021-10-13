package co.com.acueducto.sish.models.seguridad;
import co.com.acueducto.sish.models.auditoria.Audit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/***
 *  Clase de definición de la tabla de los roles del sistema
 */
@Entity
@Table(name = "roles")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class RolModel  extends Audit{
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


}
