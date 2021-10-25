package co.com.acueducto.sish.services.seguridad;

import co.com.acueducto.sish.dtos.UsuarioDTO;
import co.com.acueducto.sish.models.seguridad.RolModel;
import co.com.acueducto.sish.repositories.seguridad.RolRepository;
import co.com.acueducto.sish.util.jwt.JwtComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class AutenticacionServiceTest {

    @Mock
    RolRepository rolRepository;
    @Mock
    JwtComponent jwtComponent;

    IAutenticacionService iAutenticacionService;
    AutenticacionService autenticacionService;
    RolModel rol;
    UsuarioDTO usuario;
    List<RolModel> roles= new ArrayList<>();

    @BeforeEach
    public void setup()  {
        MockitoAnnotations.initMocks(this);
        iAutenticacionService = new AutenticacionService();
        autenticacionService = new AutenticacionService();
        rol = new RolModel();
        rol.setRol("ajsute");
        rol.setIdRol(1);
        rol.setDescripcion("ajuste de pruebas");
        rol.setActivo("S");
        roles.add(rol);

        Mockito.when(rolRepository.existsRolModelByRol("ajuste")).thenReturn(true);

        Mockito.when(rolRepository.findByOrderByRolAsc()).thenReturn(roles);

        ReflectionTestUtils.setField(autenticacionService,"rolRepository",rolRepository);
    }

    @Test
    public void validarUsuario(){
        usuario =new UsuarioDTO();
        usuario.setUsuario("test");
        usuario.setCorreo("test");
        usuario.setNombre("test");
        usuario.setToken("123456789");

        Mockito.when(jwtComponent.crearToken(String.valueOf(usuario.getUsuario()), usuario.getCorreo())).thenReturn("");
        ReflectionTestUtils.setField(autenticacionService,"jwtComponent",jwtComponent);

        String test = autenticacionService.validarUsuario(usuario);
        Assertions.assertEquals(test,null);

    }

    @Test
    public void obtenerId(){

        String tester="123456";

        Mockito.when(jwtComponent.obtenerId(tester)).thenReturn("");
        ReflectionTestUtils.setField(autenticacionService,"jwtComponent",jwtComponent);

        String test = autenticacionService.obtenerId(tester);
        Assertions.assertEquals(test,"");

    }

    @Test
    public void obtenerSubject(){

        String tester="123456";

        Mockito.when(jwtComponent.obtenerSubject(tester)).thenReturn("");
        ReflectionTestUtils.setField(autenticacionService,"jwtComponent",jwtComponent);

        String test = autenticacionService.obtenerSubject(tester);
        Assertions.assertEquals(test,"");

    }

    @Test
    public void esTokenValido(){

        String tester="123456";

        Boolean test = autenticacionService.esTokenValido(tester);
        Assertions.assertEquals(test,true);

    }


}
