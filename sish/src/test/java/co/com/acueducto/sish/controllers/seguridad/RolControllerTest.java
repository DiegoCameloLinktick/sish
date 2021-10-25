package co.com.acueducto.sish.controllers.seguridad;


import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.models.seguridad.RolModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.repositories.seguridad.RolRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.auditoria.IAuditoriaService;
import co.com.acueducto.sish.services.seguridad.IRolService;
import co.com.acueducto.sish.services.seguridad.RolService;
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

import static org.mockito.ArgumentMatchers.anyInt;

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class RolControllerTest {


    @Mock
    AuditoriaService auditoriaService;
    IAuditoriaService iAuditoriaService;
    @Mock
    AuditoriaRepository auditoriaRepository;
    @Mock
    UtilidadesJSON utilidadesJSON;
    @Mock
    BindingResult mockBindingResult;
    @Mock
    IRolService iRolService;
    @Mock
    RolService rolService;
    @Mock
    RolRepository rolRepository;
    RolController rolController;
    RolModel rolModel;
    List<RolModel> rolList = new ArrayList<>();
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        rolController = new RolController();
        iAuditoriaService = new AuditoriaService();
        auditoriaService = new AuditoriaService();
        rolService = new RolService();
        iRolService= new RolService();
        rolModel = new RolModel();
        rolModel.setIdRol(1);
        rolModel.setRol("test");
        rolModel.setDescripcion("test");
        rolModel.setActivo("S");
        rolList.add(rolModel);

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

        Mockito.when(rolRepository.findByOrderByRolAsc()).thenReturn(rolList);
        Mockito.when(rolRepository.existsRolModelByRol("")).thenReturn(true);
        Mockito.when(rolRepository.obtenerActivos()).thenReturn(rolList);
        Mockito.when(rolRepository.save(rolModel)).thenReturn(rolModel);
        Mockito.when(rolRepository.rolExistente(1,"")).thenReturn(true);
        Mockito.when(rolRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(rolModel));
        ReflectionTestUtils.setField(rolService,"rolRepository",rolRepository);

        Mockito.when(rolService.actualizar(rolModel)).thenReturn(rolModel);
        Mockito.when(rolService.crear(rolModel)).thenReturn(rolModel);
        Mockito.when(rolService.obtener()).thenReturn((ArrayList<RolModel>) rolList);
        Mockito.when(rolService.obtenerActivos()).thenReturn((ArrayList<RolModel>) rolList);
        Mockito.when(rolService.obtenerPorId(1)).thenReturn(java.util.Optional.ofNullable(rolModel));
        ReflectionTestUtils.setField(rolController,"rolService",rolService);

    }

    @Test
    public void actualizar(){
        Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
        RolModel rol = rolController.actualizar(rolModel,mockBindingResult);
        Assertions.assertEquals(rol,rolModel);
    }

    @Test
    public void crear(){
        Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
        RolModel rol = rolController.crear(rolModel,mockBindingResult);
        Assertions.assertEquals(rol,rolModel);
    }

    @Test
    public void obtener(){
        List<RolModel> rolLista= rolController.obtener();
        Assertions.assertEquals(rolLista,rolList);

    }

    @Test
    public void obtenerPorId(){
        Optional<RolModel> rol=rolController.obtenerPorId(1);
        RolModel rolM=rol.get();
        Assertions.assertEquals(rolM,rolModel);
    }

    @Test
    public void obtenerActivos(){
        List<RolModel> listRol= rolController.obtenerActivos();
        Assertions.assertEquals(listRol,rolList);
    }


}
