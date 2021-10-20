package co.com.acueducto.sish.services.configuracion;


import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.repositories.configuracion.DominioRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class DominioServiceTest {

    @Mock
    RestTemplate restTemplate;
    @MockBean
    DominioRepository dominioRepository;
    @Autowired
    DominioService dominioService;

    @Before("")
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDominio(){
        DominioModel dominios = new DominioModel();
        dominios.setDominio("test");
        dominios.setIdDominio(1);
        dominios.setDescripcion("ajuste");

        ArrayList<DominioModel> response = new ArrayList<>();
        response.add(dominios);

        //Mockito.when(dominioRepository.findByOrderByDominioAsc()).thenReturn(response);

        //dominioService.obtener();

    }



}
