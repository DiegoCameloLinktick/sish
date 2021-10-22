package co.com.acueducto.sish.controllers;


import co.com.acueducto.sish.controllers.configuracion.DominioController;
import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.repositories.configuracion.DominioRepository;
import co.com.acueducto.sish.services.configuracion.DominioService;
import co.com.acueducto.sish.services.configuracion.IDominioService;
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

@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class DominioControllerTest {

  @Mock
  DominioService dominioService;
  @Mock
  IDominioService idominioService;

  @Mock
  DominioController controller;
  @Mock
  DominioRepository dominioRepository;

  DominioModel dominios;

  ArrayList<DominioModel> response = new ArrayList<>();

  ArrayList<DominioModel> dominioModelList = new ArrayList<>();

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    idominioService = new DominioService();
    dominioService = new DominioService();
    dominios = new DominioModel();
    dominios.setDominio("test");
    dominios.setIdDominio(1);
    dominios.setDescripcion("ajuste");
    dominioModelList.add(dominios);

    response.add(dominios);

    Mockito.when(dominioService.obtenerPorId(1)).thenReturn(Optional.ofNullable(dominios));
    Mockito.when(dominioService.obtener()).thenReturn(dominioModelList);


    ReflectionTestUtils.setField(dominioService,"dominioRepository",dominioRepository);

  }

  @Test
  public void obtener()  {

    List<DominioModel> dominioList=controller.obtener();


    }

  @Test
  public void obtenerPorId()  {
    Optional<DominioModel> dominioList=controller.obtenerPorId(1);
  }


}
