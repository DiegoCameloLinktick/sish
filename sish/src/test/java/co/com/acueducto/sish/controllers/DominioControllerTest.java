package co.com.acueducto.sish.controllers;


import co.com.acueducto.sish.controllers.configuracion.DominioController;
import co.com.acueducto.sish.models.configuracion.DominioModel;
import co.com.acueducto.sish.services.configuracion.DominioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.client.ResponseCreator;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes= Application.class)
@ComponentScan(basePackages="co.com.acueducto.sish")
@PropertySource("classpath:application-test.properties")
public class DominioControllerTest {

  @InjectMocks
  DominioService dominioService;

  @Mock
  DominioController controller;
  @Mock
  RestTemplate restTemplate;

  MockRestServiceServer mockServer;

  private WebApplicationContext wac;

  private MockMvc mockMvc;

  private static final ObjectMapper mapper = new ObjectMapper();

  @Before("")
  public void setup() {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void testDominio() throws Exception {
    DominioModel response= mock(DominioModel.class);
    response.setDominio("ejemplo");
    response.setIdDominio(1);
    response.setDescripcion("ajuste");

    mockServer.expect(requestTo("/dominio/actualizar")).andExpect(method(HttpMethod.POST))
            .andExpect((RequestMatcher) response)
            .andRespond((ResponseCreator) response);


    }
}
