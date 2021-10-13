package co.com.acueducto.sish.controllers.seguridad;

import co.com.acueducto.sish.dtos.UsuarioDTO;
import co.com.acueducto.sish.services.seguridad.AutenticacionService;
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


    /***
     * Obtiene el usuario que esta autenticado en la sesión activa del servidor del EEAB
     * @return UsuarioDTO
     */
    @PostMapping(value = "/obtenerUsuarioAutenticado")
    public UsuarioDTO obtenerUsuarioAutenticado() {
        logger.debug("En obtenerUsuarioAutenticado");
        UsuarioDTO usuarioDTO =new UsuarioDTO();
        usuarioDTO.setUsuario("juanperez");
        usuarioDTO.setNombre("Juan Peréz");
        usuarioDTO.setCorreo("juanperez@corre.com");
        usuarioDTO.setToken("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNjM0MDkwOTU5LCJzdWIiOiJkZCIsImlzcyI6Ik1haW4iLCJleHAiOjE2MzQ2OTU3NTl9.3TG_m9vZgWQZUi0P9_5v1jH9YcoJht9scGAxt7stV70");
        List<String> roles = new ArrayList<>();
        roles.add("General");
        usuarioDTO.setRoles(roles);
        return usuarioDTO;
    }

}
