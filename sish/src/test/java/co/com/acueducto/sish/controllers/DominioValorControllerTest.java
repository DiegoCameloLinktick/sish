package co.com.acueducto.sish.controllers;

import co.com.acueducto.sish.controllers.configuracion.DominioValorController;
import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.repositories.configuracion.DominioValorRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.auditoria.IAuditoriaService;
import co.com.acueducto.sish.services.configuracion.DominioValorService;
import co.com.acueducto.sish.services.configuracion.IDominioValorService;
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
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class DominioValorControllerTest {
    @Mock
    DominioValorService dominioValorService;
    @Mock
    IDominioValorService iDominioValorService;

    DominioValorController dominioValorController;
    @Mock
    DominioValorRepository dominioValorRepository;
    DominioValoresModel dominioValoresModel;
    @Mock
    AuditoriaService auditoriaService;
    IAuditoriaService iAuditoriaService;
    @Mock
    AuditoriaRepository auditoriaRepository;
    @Mock
    UtilidadesJSON utilidadesJSON;
    @Mock
    BindingResult mockBindingResult;

    ArrayList<DominioValoresModel> response = new ArrayList<>();

    ArrayList<DominioValoresModel> valoresList = new ArrayList<>();


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        iAuditoriaService = new AuditoriaService();
        auditoriaService = new AuditoriaService();
        iDominioValorService = new DominioValorService();
        dominioValorService = new DominioValorService();
        dominioValorController = new DominioValorController();
        dominioValoresModel = new DominioValoresModel();
        dominioValoresModel.setIdDominiosValores(2);
        dominioValoresModel.setIdDominio(1);
        dominioValoresModel.setNombre("ajuste");
        valoresList.add(dominioValoresModel);

        AuditoriaModel auditoriaModel = new AuditoriaModel();
        auditoriaModel.setIdAuditoria(Long.parseLong("1"));
        auditoriaModel.setId(2);
        auditoriaModel.setObjeto("dominioValoresModel");
        auditoriaModel.setNombreEntidad("ModelosModelo");
        auditoriaModel.setOperacion(2);
        Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);
        Mockito.when(utilidadesJSON.convertirObjetoJson(dominioValoresModel)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
        ReflectionTestUtils.setField(dominioValorService,"auditoriaService",auditoriaService);

        Mockito.when(dominioValorRepository.obtenerValoresPorIdDominio(1)).thenReturn(valoresList);
        Mockito.when(dominioValorRepository.save(dominioValoresModel)).thenReturn(dominioValoresModel);
        ReflectionTestUtils.setField(dominioValorService,"dominioValorRepository",dominioValorRepository);

        Mockito.when(dominioValorService.obtenerValoresPorIdDominio(1)).thenReturn(valoresList);
        Mockito.when(dominioValorService.actualizar(dominioValoresModel)).thenReturn(dominioValoresModel);
        Mockito.when(dominioValorService.crear(dominioValoresModel)).thenReturn(dominioValoresModel);
        ReflectionTestUtils.setField(dominioValorController,"dominioValorService",dominioValorService);

    }

    @Test
    public void obtenerPorId()  {

        List<DominioValoresModel> valoresDominioList=dominioValorController.obtenerPorId(1);
        Assertions.assertEquals(valoresDominioList,valoresList);
    }

    @Test
    public void actualizar(){
        Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
        DominioValoresModel dominioValor = dominioValorController.actualizar(dominioValoresModel,mockBindingResult);
        Assertions.assertEquals(dominioValor,dominioValoresModel);
    }
    @Test
    public void crear(){
        Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
        DominioValoresModel dominio = dominioValorController.crear(dominioValoresModel,mockBindingResult);
        Assertions.assertEquals(dominio,dominioValoresModel);
    }

}
