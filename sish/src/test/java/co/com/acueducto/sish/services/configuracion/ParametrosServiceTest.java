package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.ParametroModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.repositories.configuracion.ParametroRepository;
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
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class ParametrosServiceTest {

    @Mock
    ParametroRepository parametroRepository;
    IParametroService iParametroService;
    @Mock
    AuditoriaService auditoriaService;
    IAuditoriaService iAuditoriaService;
    @Mock
    AuditoriaRepository auditoriaRepository;
    @Mock
    UtilidadesJSON utilidadesJSON;
    ParametroService parametrosService;
    ParametroModel parametroModel;

    ArrayList<ParametroModel> response = new ArrayList<>();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        iParametroService = new ParametroService();
        parametrosService = new ParametroService();

        iAuditoriaService = new AuditoriaService();
        auditoriaService = new AuditoriaService();

        parametroModel = new ParametroModel();
//parametros para el  modelo
        parametroModel.setParametro("PRUEBAS");
        parametroModel.setIdParametro(1);
        parametroModel.setCodigo("Pruebas UNI 1");
        parametroModel.setIdMetodo(1);
        parametroModel.setIdUnidadMedida(1);
        parametroModel.setIdTipoParametro(1);
        parametroModel.setDescripcion("pruebas unitarias");

        response.add(parametroModel);

        Mockito.when(parametroRepository.findByOrderByParametrosAsc()).thenReturn(response);
        Mockito.when(parametroRepository.save(parametroModel)).thenReturn(parametroModel);
        Mockito.when(parametroRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(parametroModel));

        ReflectionTestUtils.setField(parametrosService,"parametrosRepository", parametroRepository);

    }
    @Test
    public void testObtenerParametros() {
        ArrayList<ParametroModel> parametroList=parametrosService.obtener();
        Assertions.assertEquals(parametroList,response);
    }
    @Test
    public void actualizarParametros()  {

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
        ParametroModel parametrosList=parametrosService.actualizar(parametroModel);
        Assertions.assertEquals(parametrosList, parametroModel);
    }

    @Test
    public void obtenerPorId()  {
        Optional<ParametroModel> parametroList=parametrosService.obtenerPorId(anyInt());
        ParametroModel parametro = parametroList.get();
        Assertions.assertEquals(parametro, parametroModel);
    }
    @Test
    public void crearParametro()  {

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
        ParametroModel parametroList = parametrosService.crear(parametroModel);
        Assertions.assertEquals(parametroList, parametroModel);
    }

}
