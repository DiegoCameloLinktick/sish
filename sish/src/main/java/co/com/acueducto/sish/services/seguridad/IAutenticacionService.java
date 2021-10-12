package co.com.acueducto.sish.services.seguridad;

import co.com.acueducto.sish.dtos.UsuarioDTO;

public interface IAutenticacionService {
    /***
     * Determina si un usuario es valido y envia un token
     * @param usuario usuario a validar
     * @return toke si el usuario es valido
     */
    String validarUsuario(UsuarioDTO usuario);

    /***
     * Determina si un token es valido
     * @param token token
     * @return Verdadero si el token es valido
     */
    boolean tokenValido(String token);
}
