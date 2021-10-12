package co.com.acueducto.sish.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/***
 * DTO con la definicion de un usuario
 */
public class UsuarioDTO {

    @Getter @Setter
    private Long idUsuario;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String correo;

    @Getter @Setter
    private List<String> roles;

}
