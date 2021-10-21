package co.com.acueducto.sish.services.configuracion;

import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.repositories.configuracion.DominioRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
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
public class DominioServiceTest {

    @Mock
    DominioRepository dominioRepository;

    IDominioService idominioService;
    AuditoriaService auditoriaService;
    DominioService dominioService;
    DominioModel dominios;
    ArrayList<DominioModel> response = new ArrayList<>();

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        idominioService = new DominioService();
        dominioService = new DominioService();
        auditoriaService= new AuditoriaService();
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
    public void testObtenerDominio() throws Exception  {
        ArrayList<DominioModel> dominioList=dominioService.obtener();
        Assertions.assertEquals(dominioList,response);
    }

    @Test
    public void actualizarDominio() throws Exception  {
        DominioModel dominioList=dominioService.actualizar(dominios);
        Assertions.assertEquals(dominioList,dominios);
    }

    @Test
    public void obtenerPorId() throws Exception  {
        Optional<DominioModel> dominioList=dominioService.obtenerPorId(anyInt());
        DominioModel dominio=dominioList.get();
        Assertions.assertEquals(dominioList,dominios);
    }




}
