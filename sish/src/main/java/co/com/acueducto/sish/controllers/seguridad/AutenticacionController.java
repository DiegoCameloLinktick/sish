package co.com.acueducto.sish.controllers.seguridad;

import co.com.acueducto.sish.dtos.UsuarioDTO;
import co.com.acueducto.sish.services.seguridad.AutenticacionService;
import co.com.acueducto.sish.util.jwt.JwtComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/***
 * Clase de definición del servicio REST de la autenticación
 */
@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {
    private static final Logger logger = LoggerFactory.getLogger(AutenticacionController.class);

    @Autowired
    AutenticacionService autenticacionService;

    @Autowired
    private JwtComponent jwtComponent;

    /***
     * Obtiene el usuario que esta autenticado en la sesión activa del servidor del EEAB
     * @return UsuarioDTO
     */
    @PostMapping(value = "/obtenerUsuarioAutenticado")
    public UsuarioDTO obtenerUsuarioAutenticado() {
        logger.debug("En obtenerUsuarioAutenticado");
        UsuarioDTO usuarioDTO =new UsuarioDTO();
        usuarioDTO.setIdUsuario(1L);
        usuarioDTO.setNombre("Jose Peréz");
        usuarioDTO.setCorreo("joreperez@corre.com");
        List<String> roles = new ArrayList<>();
        roles.add("General");
        usuarioDTO.setRoles(roles);
        return usuarioDTO;
    }

    /***
     * Determina si un usuario es valido y envia un token
     * @param usuario usuario a validar
     * @return toke si el usuario es valido
     */
    @PostMapping(value = "/validarUsuario")
    public String validarUsuario(UsuarioDTO usuario) {
        logger.debug("En validarToken");
        return autenticacionService.validarUsuario(usuario);
    }
    /***
     * Determina si un usuario es valido y envia un token
     * @param token token a validar
     * @return toke si el usuario es valido
     */
    @PostMapping(value = "/tokenValido")
    public boolean tokenValido(String token) {
        logger.debug("En validarToken");
        return autenticacionService.tokenValido(token);
    }
}
