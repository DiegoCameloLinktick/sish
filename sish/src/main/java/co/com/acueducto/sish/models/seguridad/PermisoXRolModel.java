package co.com.acueducto.sish.models.seguridad;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private Integer idPermisoXRol;

    /***
     * Identificador del rol
     */
    @NotNull(message = "El rol no puede ser nulo")
    @Column(name = "id_rol", nullable = false)
    @Getter
    @Setter
    private Integer idRol;

    /***
     * Identificador del permiso
     */
    @NotNull(message = "El permiso del rol no puede ser nulo")
    @Column(name = "id_permiso", nullable = false)
    @Getter
    @Setter
    private Integer idPermiso;


}