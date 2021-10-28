package co.com.acueducto.sish.controllers;

import co.com.acueducto.sish.controllers.configuracion.ParametrosController;
import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.ParametroModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.repositories.configuracion.ParametroRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.auditoria.IAuditoriaService;
import co.com.acueducto.sish.services.configuracion.IParametroService;
import co.com.acueducto.sish.services.configuracion.ParametroService;
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
    ParametroService parametrosService;
    @Mock
    IParametroService iParametroService;
    ParametrosController parametrosController;
    @Mock
    ParametroRepository parametroRepository;
    ParametroModel parametroModel;

    @Mock
    AuditoriaService auditoriaService;
    IAuditoriaService iAuditoriaService;
    @Mock
    AuditoriaRepository auditoriaRepository;
    @Mock
    UtilidadesJSON utilidadesJSON;
    @Mock
    BindingResult mockBindingResult;

    ArrayList<ParametroModel> response = new ArrayList<>();
    ArrayList<ParametroModel> valoresList = new ArrayList<>();


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        iAuditoriaService = new AuditoriaService();
        auditoriaService = new AuditoriaService();
        iParametroService = new ParametroService();
        parametrosService = new ParametroService();
        parametrosController = new ParametrosController();
        parametroModel = new ParametroModel();

        parametroModel.setParametro("Actuazacion prueba 1");
        parametroModel.setIdParametro(1);
        parametroModel.setCodigo("Parametro1");
        parametroModel.setIdMetodo(40);
        parametroModel.setIdUnidadMedida(21);
        parametroModel.setIdTipoParametro(41);
        parametroModel.setDescripcion("Actualizacion 1");
        valoresList.add(parametroModel);

        AuditoriaModel auditoriaModel = new AuditoriaModel();
        auditoriaModel.setIdAuditoria(Long.parseLong("1"));
        auditoriaModel.setId(2);
        auditoriaModel.setObjeto("parametrosModel");
        auditoriaModel.setNombreEntidad("ModelosModelo");
        auditoriaModel.setOperacion(2);

        Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);
        Mockito.when(utilidadesJSON.convertirObjetoJson(parametroModel)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
        ReflectionTestUtils.setField(parametrosService,"auditoriaService",auditoriaService);
      
        Mockito.when(parametroRepository.findByOrderByParametrosAsc()).thenReturn(valoresList);
        Mockito.when(parametroRepository.save(parametroModel)).thenReturn(parametroModel);
        ReflectionTestUtils.setField(parametrosService,"parametrosRepository", parametroRepository);

        Mockito.when(parametrosService.obtener()).thenReturn(valoresList);
        Mockito.when(parametrosService.obtenerPorId(1)).thenReturn(Optional.ofNullable(parametroModel));
        Mockito.when(parametrosService.actualizar(parametroModel)).thenReturn(parametroModel);
        Mockito.when(parametrosService.crear(parametroModel)).thenReturn(parametroModel);
        ReflectionTestUtils.setField(parametrosController,"parametrosService",parametrosService);
}


    @Test
    public void obtener()  {
        List<ParametroModel> ParametrosList=parametrosController.obtener();
        Assertions.assertEquals(ParametrosList,valoresList);
    }

    @Test
    public void obtenerPorId()  {
        Optional<ParametroModel> valoresParametosList = parametrosController.obtenerPorId(1);
        ParametroModel parametros = valoresParametosList.get();
        Assertions.assertEquals(parametros, parametroModel);
    }

    @Test
    public void actualizar(){
        Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
        ParametroModel parametro = parametrosController.actualizar(parametroModel,mockBindingResult);
        Assertions.assertEquals(parametro, parametroModel);
    }
    @Test
    public void crear(){
        Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
        ParametroModel parametro = parametrosController.crear(parametroModel,mockBindingResult);
        Assertions.assertEquals(parametro, parametroModel);
    }


}
