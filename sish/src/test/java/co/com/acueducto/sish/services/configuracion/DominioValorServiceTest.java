package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.repositories.configuracion.DominioValorRepository;
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
public class DominioValorServiceTest {


    @Mock
    DominioValorRepository dominioValorRepository;

    IDominioValorService idominioValorService;
    DominioValorService dominioValorService;
    DominioValoresModel valoresDominios;
    List<DominioValoresModel> valoresDominioList= new ArrayList<>();

    @BeforeEach
    public void setup()  {
        MockitoAnnotations.initMocks(this);
        idominioValorService = new DominioValorService();
        dominioValorService = new DominioValorService();
        valoresDominios = new DominioValoresModel();
        valoresDominios.setIdDominiosValores(2);
        valoresDominios.setIdDominio(1);
        valoresDominios.setNombre("ajuste");
        valoresDominioList.add(valoresDominios);

        Mockito.when(dominioValorRepository.obtenerValoresPorIdDominio(1)).thenReturn(valoresDominioList);


        ReflectionTestUtils.setField(dominioValorService,"dominioValorRepository",dominioValorRepository);

    }

    @Test
    public void obtenerValoresPorIdDominio(){
            List<DominioValoresModel> valoresDominioList=dominioValorService.obtenerValoresPorIdDominio(1);
        Assertions.assertEquals(valoresDominioList,valoresDominioList);
    }
}
