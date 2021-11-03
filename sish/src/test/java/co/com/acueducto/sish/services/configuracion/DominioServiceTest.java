package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.repositories.configuracion.DominioRepository;
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
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class DominioServiceTest {

    @Mock
    DominioRepository dominioRepository;

    IDominioService idominioService;
    @Mock
    AuditoriaService auditoriaService;

    IAuditoriaService iAuditoriaService;
    @Mock
    AuditoriaRepository auditoriaRepository;
    @Mock
    UtilidadesJSON utilidadesJSON;
    DominioService dominioService;
    DominioModel dominios;
    ArrayList<DominioModel> response = new ArrayList<>();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        idominioService = new DominioService();
        dominioService = new DominioService();
        iAuditoriaService = new AuditoriaService();
        auditoriaService = new AuditoriaService();
        dominios = new DominioModel();
        dominios.setDominio("test");
        dominios.setIdDominio(1);
        dominios.setDescripcion("ajuste");
        response.add(dominios);

        Mockito.when(dominioRepository.findByOrderByDominioAsc()).thenReturn(response);
        Mockito.when(dominioRepository.save(dominios)).thenReturn(dominios);
        Mockito.when(dominioRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(dominios));

        ReflectionTestUtils.setField(dominioService,"dominioRepository",dominioRepository);

    }

    @Test
    public void testObtenerDominio() {
        List<DominioModel> dominioList=dominioService.obtener();
        Assertions.assertEquals(dominioList,response);
    }

    @Test
    public void actualizarDominio()  {

        AuditoriaModel auditoriaModel = new AuditoriaModel();
        auditoriaModel.setIdAuditoria(Long.parseLong("1"));
        auditoriaModel.setId(2);
        auditoriaModel.setObjeto("dominiosModel");
        auditoriaModel.setNombreEntidad("ModelosModelo");
        auditoriaModel.setOperacion(2);
        Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);
        Mockito.when(utilidadesJSON.convertirObjetoJson(dominios)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
        ReflectionTestUtils.setField(dominioService,"auditoriaService",auditoriaService);
        DominioModel dominioList=dominioService.actualizar(dominios);
        Assertions.assertEquals(dominioList,dominios);
    }

    @Test
    public void obtenerPorId()  {
        Optional<DominioModel> dominioList=dominioService.obtenerPorId(anyInt());
        DominioModel dominio=dominioList.get();
        Assertions.assertEquals(dominio,dominios);
    }



}
