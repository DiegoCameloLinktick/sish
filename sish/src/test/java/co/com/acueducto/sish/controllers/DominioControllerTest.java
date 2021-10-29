package co.com.acueducto.sish.controllers;


import co.com.acueducto.sish.controllers.configuracion.DominioController;
import co.com.acueducto.sish.models.auditoria.AuditoriaModel;
import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.repositories.auditoria.AuditoriaRepository;
import co.com.acueducto.sish.repositories.configuracion.DominioRepository;
import co.com.acueducto.sish.services.auditoria.AuditoriaService;
import co.com.acueducto.sish.services.auditoria.IAuditoriaService;
import co.com.acueducto.sish.services.configuracion.DominioService;
import co.com.acueducto.sish.services.configuracion.IDominioService;
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
public class DominioControllerTest {

  @Mock
  DominioService dominioService;
  @Mock
  IDominioService idominioService;

  DominioController dominioController;
  @Mock
  DominioRepository dominioRepository;
  DominioModel dominios;
  @Mock
  AuditoriaService auditoriaService;
  IAuditoriaService iAuditoriaService;
  @Mock
  AuditoriaRepository auditoriaRepository;
  @Mock
  UtilidadesJSON utilidadesJSON;
  @Mock
   BindingResult mockBindingResult;

  ArrayList<DominioModel> response = new ArrayList<>();

  ArrayList<DominioModel> dominioModelList = new ArrayList<>();

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    idominioService = new DominioService();
    dominioService = new DominioService();
    iAuditoriaService = new AuditoriaService();
    auditoriaService = new AuditoriaService();
    dominioController = new DominioController();
    dominios = new DominioModel();
    dominios.setDominio("test");
    dominios.setIdDominio(1);
    dominios.setDescripcion("ajuste");
    dominioModelList.add(dominios);

    response.add(dominios);

    AuditoriaModel auditoriaModel = new AuditoriaModel();
    auditoriaModel.setIdAuditoria(Long.parseLong("1"));
    auditoriaModel.setId(2);
    auditoriaModel.setObjeto("dominiosModel");
    auditoriaModel.setNombreEntidad("ModelosModelo");
    auditoriaModel.setOperacion(2);
    Mockito.when(auditoriaRepository.save(auditoriaModel)).thenReturn(auditoriaModel);
    Mockito.when(utilidadesJSON.convertirObjetoJson(dominios)).thenReturn("");
    ReflectionTestUtils.setField(auditoriaService,"utilidadesJSON",utilidadesJSON);
    ReflectionTestUtils.setField(auditoriaService,"auditoriaRepository",auditoriaRepository);
    ReflectionTestUtils.setField(dominioService,"auditoriaService",auditoriaService);

    Mockito.when(dominioRepository.findByOrderByDominioAsc()).thenReturn(dominioModelList);
    Mockito.when(dominioRepository.findAll()).thenReturn(dominioModelList);
    Mockito.when(dominioRepository.save(dominios)).thenReturn(dominios);
    ReflectionTestUtils.setField(dominioService,"dominioRepository",dominioRepository);
    Mockito.when(dominioService.obtenerPorId(1)).thenReturn(Optional.ofNullable(dominios));
    Mockito.when(dominioService.actualizar(dominios)).thenReturn(dominios);
    Mockito.when(dominioService.obtener()).thenReturn(dominioModelList);

    ReflectionTestUtils.setField(dominioController,"dominioService",dominioService);

  }

  @Test
  public void obtener()  {


    List<DominioModel> dominioList=dominioController.obtener();
    Assertions.assertEquals(dominioList,dominioModelList);
    }

  @Test
  public void obtenerPorId()  {

    Optional<DominioModel> dominioList=dominioController.obtenerPorId(1);
    DominioModel dominio=dominioList.get();
    Assertions.assertEquals(dominio,dominios);
  }

  @Test
  public void actualizar(){
    Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
    DominioModel dominio = dominioController.actualizar(dominios,mockBindingResult);
    Assertions.assertEquals(dominio,dominios);
  }



}
