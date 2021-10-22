package co.com.acueducto.sish.controllers.seguridad;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class AutenticacionControllerTest {


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);


    }
}
