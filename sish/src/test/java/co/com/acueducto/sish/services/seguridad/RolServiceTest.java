package co.com.acueducto.sish.services.seguridad;

import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.DominioValoresModel;
import co.com.acueducto.sish.models.seguridad.RolModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.repositories.seguridad.RolRepository;
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

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class RolServiceTest {


    @Mock
    RolRepository rolRepository;
    @Mock
    AuditoriaService auditoriaService;
    IAuditoriaService iAuditoriaService;
    @Mock
    AuditoriaRepository auditoriaRepository;
    @Mock
    UtilidadesJSON utilidadesJSON;

    IRolService iRolService;
    RolService rolService;
    RolModel rolModel;
    ArrayList<RolModel> responseList= new ArrayList<>();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        rolService = new RolService();
        iRolService = new RolService();
        iAuditoriaService = new AuditoriaService();
        auditoriaService = new AuditoriaService();
        rolModel = new RolModel();
        rolModel.setActivo("S");
        rolModel.setIdRol(1);
        rolModel.setDescripcion("test");
        responseList.add(rolModel);

        Mockito.when(rolRepository.findByOrderByRolAsc()).thenReturn(responseList);
        Mockito.when(rolRepository.existsRolModelByRol("")).thenReturn(true);
        Mockito.when(rolRepository.obtenerActivos()).thenReturn(responseList);
        Mockito.when(rolRepository.save(rolModel)).thenReturn(rolModel);
        Mockito.when(rolRepository.rolExistente(1,"")).thenReturn(true);
        Mockito.when(rolRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(rolModel));

        ReflectionTestUtils.setField(rolService,"rolRepository",rolRepository);
    }

    @Test
    public void obtener(){

        List<RolModel> rolList=rolService.obtener();
        Assertions.assertEquals(rolList,responseList);

    }

    @Test
    public void obtenerActivos(){

        List<RolModel> rolList=rolService.obtenerActivos();
        Assertions.assertEquals(rolList,responseList);

    }

    @Test
    public void obtenerPorIdRol(){

        Optional<RolModel> rolList=rolService.obtenerPorId(1);
        RolModel rol = rolList.get();
        Assertions.assertEquals(rol,rolModel);

    }

    @Test
    public void crear(){

        AuditoriaModel auditoriaModel = new AuditoriaModel();
        auditoriaModel.setIdAuditoria(Long.parseLong("1"));
        auditoriaModel.setId(2);
        auditoriaModel.setObjeto("rolModel");
        auditoriaModel.setNombreEntidad("ModelosModelo");
        auditoriaModel.setOperacion(2);
        Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);
        Mockito.when(utilidadesJSON.convertirObjetoJson(rolModel)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
        ReflectionTestUtils.setField(rolService,"auditoriaService",auditoriaService);

        RolModel rol=rolService.crear(rolModel);
        Assertions.assertEquals(rol,rolModel);

    }

    @Test
    public void actualizar(){

        AuditoriaModel auditoriaModel = new AuditoriaModel();
        auditoriaModel.setIdAuditoria(Long.parseLong("1"));
        auditoriaModel.setId(2);
        auditoriaModel.setObjeto("rolModel");
        auditoriaModel.setNombreEntidad("ModelosModelo");
        auditoriaModel.setOperacion(2);
        Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);
        Mockito.when(utilidadesJSON.convertirObjetoJson(rolModel)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
        ReflectionTestUtils.setField(rolService,"auditoriaService",auditoriaService);

        RolModel rol=rolService.actualizar(rolModel);
        Assertions.assertEquals(rol,rolModel);

    }


}
