package co.com.acueducto.sish.util.utilidades;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

@Component
public class UtilidadesJSON {

    /***
     * Convierte un objeto a un JSON
     * @param objeto objeto a convertir a JSON
     * @return Cadena con el JSON
     * @throws JsonProcessingException Excpeción
     */
    /**
     * Metodo para mapear los objetos fuentes que llegan en un String
     *
     * @param fuente Objetos a mapear que estuvieron implicados en la operación
     *
     * @return fuente convertida a String
     */
    public String convertirObjetoJson(Object fuente) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        if (fuente != null){
            String mapeo = "{";
            Field[] atributos = fuente.getClass().getDeclaredFields();
            for (Field atributo : atributos) {
                if(!atributo.getName().equals("serialVersionUID") && !Collection.class.isAssignableFrom(atributo.getType())){
                    PropertyDescriptor pd;
                    pd = new PropertyDescriptor(atributo.getName(), fuente.getClass());
                    Object valor = pd.getReadMethod().invoke(fuente);
                    mapeo = mapeo.concat("\"");
                    mapeo = mapeo.concat(atributo.getName());
                    mapeo = mapeo.concat("\": ");
                    if (valor == null){
                        mapeo = mapeo.concat("null");
                    } else{
                        mapeo = mapeo.concat("\"");
                        mapeo = mapeo.concat(valor.toString());
                        mapeo = mapeo.concat("\"");
                    }
                    mapeo = mapeo.concat(",");
                }
            }
            if(mapeo.endsWith(",")){
                mapeo = mapeo.substring(0, mapeo.length() - 1);
            }
            mapeo = mapeo.concat("}");
            return mapeo;
        } else{
            return null;
        }
    }
}
