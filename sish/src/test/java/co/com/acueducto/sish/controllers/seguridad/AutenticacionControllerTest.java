package co.com.acueducto.sish.controllers.seguridad;

import co.com.acueducto.sish.dtos.UsuarioDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class AutenticacionControllerTest {

    AutenticacionController autenticacionController;
    UsuarioDTO usuario;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        autenticacionController = new AutenticacionController();
        usuario =new UsuarioDTO();
        usuario.setUsuario("test");
        usuario.setCorreo("test");
        usuario.setNombre("test");
        usuario.setToken("123456789");

    }

    @Test
    public void test(){
        UsuarioDTO usuario= autenticacionController.obtenerUsuarioAutenticado();
        Assertions.assertEquals(usuario,usuario);

    }
}
