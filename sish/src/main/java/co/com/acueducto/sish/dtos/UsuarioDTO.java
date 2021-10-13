package co.com.acueducto.sish.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/***
 * DTO con la definicion de un usuario
 */
public class UsuarioDTO {

    /***
     * Usuario en el LDAP
     */
    @Getter @Setter
    private String usuario;

    /***
     * Nombre del usuario
     */
    @Getter @Setter
    private String nombre;

    /***
     * Correo del usuario
     */
    @Getter @Setter
    private String correo;

    /***
     * Arreglo con los roles activos
     */
    @Getter @Setter
    private List<String> roles;

    /***
     * TOken actual
     */
    @Getter @Setter
    private String token;

}
