package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.ParametrosModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.repositories.configuracion.ParametrosRepository;
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
    ParametrosRepository parametrosRepository;
    IParametrosService iParametrosService;
    @Mock
    AuditoriaService auditoriaService;
    IAuditoriaService iAuditoriaService;
    @Mock
    AuditoriaRepository auditoriaRepository;
    @Mock
    UtilidadesJSON utilidadesJSON;
    ParametrosService parametrosService;
    ParametrosModel parametrosModel;

    ArrayList<ParametrosModel> response = new ArrayList<>();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        iParametrosService = new ParametrosService();
        parametrosService = new ParametrosService();

        iAuditoriaService = new AuditoriaService();
        auditoriaService = new AuditoriaService();

        parametrosModel = new ParametrosModel();
//parametros para el  modelo
        parametrosModel.setParametro("PRUEBAS");
        parametrosModel.setIdParametro(1);
        parametrosModel.setCodigo("Pruebas UNI 1");
        parametrosModel.setIdMetodo(1);
        parametrosModel.setIdUnidadMedida(1);
        parametrosModel.setIdTipoParametro(1);
        parametrosModel.setDescripcion("pruebas unitarias");

        response.add(parametrosModel);

        Mockito.when(parametrosRepository.findByOrderByParametrosAsc()).thenReturn(response);
        Mockito.when(parametrosRepository.save(parametrosModel)).thenReturn(parametrosModel);
        Mockito.when(parametrosRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(parametrosModel));

        ReflectionTestUtils.setField(parametrosService,"parametrosRepository",parametrosRepository);

    }
    @Test
    public void testObtenerParametros() {
        ArrayList<ParametrosModel> parametroList=parametrosService.obtener();
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
        Mockito.when(utilidadesJSON.convertirObjetoJson(parametrosModel)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);

        ReflectionTestUtils.setField(parametrosService,"auditoriaService",auditoriaService);
        ParametrosModel parametrosList=parametrosService.actualizar(parametrosModel);
        Assertions.assertEquals(parametrosList,parametrosModel);
    }

    @Test
    public void obtenerPorId()  {
        Optional<ParametrosModel> parametroList=parametrosService.obtenerPorId(anyInt());
        ParametrosModel parametro = parametroList.get();
        Assertions.assertEquals(parametro,parametrosModel);
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
        Mockito.when(utilidadesJSON.convertirObjetoJson(parametrosModel)).thenReturn("");

        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
        ReflectionTestUtils.setField(parametrosService,"auditoriaService",auditoriaService);
        ParametrosModel parametroList = parametrosService.crear(parametrosModel);
        Assertions.assertEquals(parametroList,parametrosModel);
    }

}
