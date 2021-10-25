package co.com.acueducto.sish.services.auditoria;

import co.com.acueducto.sish.dtos.OperacionAuditoriaEnum;
import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.util.utilidades.UtilidadesJSON;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.util.ReflectionTestUtils;

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class AuditoriaServiceTest {

    @Mock
    AuditoriaRepository auditoriaRepository;

    IAuditoriaService iAuditoriaService;
    AuditoriaService auditoriaService;
    AuditoriaModel  auditoriaModel;
    @Mock
    UtilidadesJSON utilidadesJSON;

    @BeforeEach
    public void setup()  {
        MockitoAnnotations.initMocks(this);

        iAuditoriaService = new AuditoriaService();
        auditoriaService = new AuditoriaService();
        auditoriaModel = new AuditoriaModel();
        utilidadesJSON = new UtilidadesJSON();
        auditoriaModel.setIdAuditoria(Long.parseLong("1"));
        auditoriaModel.setId(2);
        auditoriaModel.setObjeto("dominiosModel");
        auditoriaModel.setNombreEntidad("ModelosModelo");
        auditoriaModel.setOperacion(2);

        Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);

        ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);

    }

    @Test
    public void test(){
        DominioModel dominios = new DominioModel();
        dominios.setDominio("test");
        dominios.setIdDominio(1);
        dominios.setDescripcion("ajuste");
        Mockito.when(utilidadesJSON.convertirObjetoJson(dominios)).thenReturn("");
        ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);

         auditoriaService.registrarAuditoria(dominios, OperacionAuditoriaEnum.ACTUALIZAR,DominioModel.class.toString()
            ,dominios.getIdDominio());
    }


}
