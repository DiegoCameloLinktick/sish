package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.repositories.configuracion.DominioValorRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.auditoria.IAuditoriaService;
import co.com.acueducto.sish.util.utilidades.UtilidadesJSON;
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
    @Mock
    AuditoriaService auditoriaService;
    IAuditoriaService iAuditoriaService;
    @Mock
    AuditoriaRepository auditoriaRepository;
    @Mock
    UtilidadesJSON utilidadesJSON;
    IDominioValorService idominioValorService;
    DominioValorService dominioValorService;
    DominioValoresModel valoresDominios;
    List<DominioValoresModel> valoresDominioList= new ArrayList<>();

    @BeforeEach
    public void setup()  {
        MockitoAnnotations.initMocks(this);
        idominioValorService = new DominioValorService();
        dominioValorService = new DominioValorService();
        iAuditoriaService = new AuditoriaService();
        auditoriaService = new AuditoriaService();
        valoresDominios = new DominioValoresModel();
        valoresDominios.setIdDominioValor(2);
        valoresDominios.setIdDominio(1);
        valoresDominios.setDominioValor("ajuste");
        valoresDominioList.add(valoresDominios);

        Mockito.when(dominioValorRepository.obtenerValoresPorIdDominio(1)).thenReturn(valoresDominioList);
        Mockito.when(dominioValorRepository.obtenerValoresActivosPorIdDominio(1)).thenReturn(valoresDominioList);
        Mockito.when(dominioValorRepository.save(valoresDominios)).thenReturn(valoresDominios);

        ReflectionTestUtils.setField(dominioValorService,"dominioValorRepository",dominioValorRepository);

    }

    @Test
    public void obtenerValoresPorIdDominio(){
            List<DominioValoresModel> valoresDominioList=dominioValorService.obtenerValoresPorIdDominio(1);
        Assertions.assertEquals(valoresDominioList,valoresDominioList);
    }

    @Test
    public void crear(){

        AuditoriaModel auditoriaModel = new AuditoriaModel();
        auditoriaModel.setIdAuditoria(Long.parseLong("1"));
        auditoriaModel.setId(2);
        auditoriaModel.setObjeto("dominiosModel");
        auditoriaModel.setNombreEntidad("ModelosModelo");
        auditoriaModel.setOperacion(2);
        Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);
        Mockito.when(utilidadesJSON.convertirObjetoJson(valoresDominios)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
        ReflectionTestUtils.setField(dominioValorService,"auditoriaService",auditoriaService);
        DominioValoresModel valorDominio=dominioValorService.crear(valoresDominios);
        Assertions.assertEquals(valorDominio,valoresDominios);

    }

    @Test
    public void actualizar(){
        AuditoriaModel auditoriaModel = new AuditoriaModel();
        auditoriaModel.setIdAuditoria(Long.parseLong("1"));
        auditoriaModel.setId(2);
        auditoriaModel.setObjeto("dominiosModel");
        auditoriaModel.setNombreEntidad("ModelosModelo");
        auditoriaModel.setOperacion(2);
        Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);
        Mockito.when(utilidadesJSON.convertirObjetoJson(valoresDominios)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
        ReflectionTestUtils.setField(dominioValorService,"auditoriaService",auditoriaService);
        DominioValoresModel valorDominio=dominioValorService.actualizar(valoresDominios);
        Assertions.assertEquals(valorDominio,valoresDominios);
    }

    @Test
    public void obtenerValoresActivosPorIdDominio(){
        List<DominioValoresModel> valoresDominioList=dominioValorService.obtenerValoresActivosPorIdDominio(1);
        Assertions.assertEquals(valoresDominioList,valoresDominioList);
    }

}
