package co.com.acueducto.sish.controllers;

import co.com.acueducto.sish.controllers.configuracion.ParametroController;
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
public class ParametroControllerTest {
    @Mock
    ParametroService parametroService;
    @Mock
    IParametroService iParametroService;
    ParametroController parametrosController;
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
        parametroService = new ParametroService();
        parametrosController = new ParametroController();
        parametroModel = new ParametroModel();

        parametroModel.setIdParametro(1);
        parametroModel.setCodigo(1);
        parametroModel.setDescripcion("Actualizacion 1");
        valoresList.add(parametroModel);

        AuditoriaModel auditoriaModel = new AuditoriaModel();
        auditoriaModel.setIdAuditoria(Long.parseLong("1"));
        auditoriaModel.setId(2);
        auditoriaModel.setObjeto("parametroModel");
        auditoriaModel.setNombreEntidad("ModelosModelo");
        auditoriaModel.setOperacion(2);

        Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);
        Mockito.when(utilidadesJSON.convertirObjetoJson(parametroModel)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
        ReflectionTestUtils.setField(parametroService,"auditoriaService",auditoriaService);
      
        Mockito.when(parametroRepository.findByOrderByParametrosAsc()).thenReturn(valoresList);
        Mockito.when(parametroRepository.save(parametroModel)).thenReturn(parametroModel);
        ReflectionTestUtils.setField(parametroService,"parametroRepository", parametroRepository);

        Mockito.when(parametroService.obtener()).thenReturn(valoresList);
        Mockito.when(parametroService.obtenerPorId(1)).thenReturn(Optional.ofNullable(parametroModel));
        Mockito.when(parametroService.actualizar(parametroModel)).thenReturn(parametroModel);
        Mockito.when(parametroService.crear(parametroModel)).thenReturn(parametroModel);
        ReflectionTestUtils.setField(parametrosController,"parametroService",parametroService);
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
