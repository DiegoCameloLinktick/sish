package co.com.acueducto.sish.controllers;

import co.com.acueducto.sish.controllers.configuracion.ParametrosController;
import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.ParametrosModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.repositories.configuracion.ParametrosRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.auditoria.IAuditoriaService;
import co.com.acueducto.sish.services.configuracion.IParametrosService;
import co.com.acueducto.sish.services.configuracion.ParametrosService;
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
import java.util.Optional;

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class ParametrosControllerTest {
    @Mock
    ParametrosService parametrosService;
    @Mock
    IParametrosService iParametrosService;
    ParametrosController parametrosController;
    @Mock
    ParametrosRepository parametrosRepository;
    ParametrosModel parametrosModel;

    @Mock
    AuditoriaService auditoriaService;
    IAuditoriaService iAuditoriaService;
    @Mock
    AuditoriaRepository auditoriaRepository;
    @Mock
    UtilidadesJSON utilidadesJSON;
    @Mock
    BindingResult mockBindingResult;

    ArrayList<ParametrosModel> response = new ArrayList<>();
    ArrayList<ParametrosModel> valoresList = new ArrayList<>();


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        iAuditoriaService = new AuditoriaService();
        auditoriaService = new AuditoriaService();
        iParametrosService = new ParametrosService();
        parametrosService = new ParametrosService();
        parametrosController = new ParametrosController();
        parametrosModel = new ParametrosModel();

        parametrosModel.setParametro("Actuazacion prueba 1");
        parametrosModel.setIdParametro(1);
        parametrosModel.setCodigo("Parametro1");
        parametrosModel.setIdMetodo(40);
        parametrosModel.setIdUnidadMedida(21);
        parametrosModel.setIdTipoParametro(41);
        parametrosModel.setDescripcion("Actualizacion 1");
        valoresList.add(parametrosModel);

        AuditoriaModel auditoriaModel = new AuditoriaModel();
        auditoriaModel.setIdAuditoria(Long.parseLong("1"));
        auditoriaModel.setId(2);
        auditoriaModel.setObjeto("parametrosModel");
        auditoriaModel.setNombreEntidad("ModelosModelo");
        auditoriaModel.setOperacion(2);

        Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);
        Mockito.when(utilidadesJSON.convertirObjetoJson(parametrosModel)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
        ReflectionTestUtils.setField(parametrosService,"auditoriaService",auditoriaService);
      
        Mockito.when(parametrosRepository.findByOrderByParametrosAsc()).thenReturn(valoresList);
        Mockito.when(parametrosRepository.save(parametrosModel)).thenReturn(parametrosModel);
        ReflectionTestUtils.setField(parametrosService,"parametrosRepository",parametrosRepository);

        Mockito.when(parametrosService.obtener()).thenReturn(valoresList);
        Mockito.when(parametrosService.obtenerPorId(1)).thenReturn(Optional.ofNullable(parametrosModel));
        Mockito.when(parametrosService.actualizar(parametrosModel)).thenReturn(parametrosModel);
        Mockito.when(parametrosService.crear(parametrosModel)).thenReturn(parametrosModel);
        ReflectionTestUtils.setField(parametrosController,"parametrosService",parametrosService);
}


    @Test
    public void obtener()  {
        List<ParametrosModel> ParametrosList=parametrosController.obtener();
        Assertions.assertEquals(ParametrosList,valoresList);
    }

    @Test
    public void obtenerPorId()  {
        Optional<ParametrosModel> valoresParametosList = parametrosController.obtenerPorId(1);
        ParametrosModel parametros = valoresParametosList.get();
        Assertions.assertEquals(parametros,parametrosModel);
    }

    @Test
    public void actualizar(){
        Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
        ParametrosModel parametro = parametrosController.actualizar(parametrosModel,mockBindingResult);
        Assertions.assertEquals(parametro,parametrosModel);
    }
    @Test
    public void crear(){
        Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
        ParametrosModel parametro = parametrosController.crear(parametrosModel,mockBindingResult);
        Assertions.assertEquals(parametro,parametrosModel);
    }


}
