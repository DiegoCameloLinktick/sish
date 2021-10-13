package co.com.acueducto.sish.services.seguridad;

import co.com.acueducto.sish.dtos.UsuarioDTO;
import co.com.acueducto.sish.models.seguridad.RolModel;
import co.com.acueducto.sish.repositories.seguridad.RolRepository;
import co.com.acueducto.sish.util.jwt.JwtComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutenticacionService implements IAutenticacionService {
    @Autowired
    RolRepository rolRepository;

    @Autowired
    private JwtComponent jwtComponent;

    private static final Logger logger = LoggerFactory.getLogger(AutenticacionService.class);

    /***
     * Determina si un usuario es valido y envia un token
     * @param usuario usuario a validar
     * @return toke si el usuario es valido
     */
    @Override
    public String validarUsuario(UsuarioDTO usuario) {
        logger.debug("En validarUsuario");
        List<RolModel> roles =  rolRepository.obtenerPorListaRoles(usuario.getRoles());
        if (!roles.isEmpty()){
            return jwtComponent.crearToken(String.valueOf(usuario.getUsuario()), usuario.getCorreo());
        }
        return null;
    }
    /***
     * Obtiene el id del token
     * @param token token
     * @return id del token
     */
    @Override
    public String obtenerId(String token) {
        return jwtComponent.obtenerId(token);
    }

    /***
     * Obtiene el subject del token
     * @param token token
     * @return subject del token
     */
    @Override
    public String obtenerSubject(String token) {
        return jwtComponent.obtenerSubject(token);
    }
}
