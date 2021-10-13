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
     * Obtiene el id del token
     * @param token token
     * @return id del token
     */
    String obtenerId(String token);

    /***
     * Obtiene el subject del token
     * @param token token
     * @return subject del token
     */
    String obtenerSubject(String token);

    /***
     * Determina si el token enviado es valido
     * @param token Token a validar
     * @return Verdadero si el token es valido
     */
    Boolean esTokenValido(String token);
}
