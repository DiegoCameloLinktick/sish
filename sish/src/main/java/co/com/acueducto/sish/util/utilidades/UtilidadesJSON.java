package co.com.acueducto.sish.util.utilidades;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UtilidadesJSON {

    /***
     * Convierte un objeto a un JSON
     * @param objeto objeto a convertir a JSON
     * @return Cadena con el JSON
     * @throws JsonProcessingException Excpeción
     */
    /*
    public String convertirObjetoJson(Object objeto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(objeto);
    }*/
}
