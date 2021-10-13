package co.com.acueducto.sish.dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * Clase para el manejo de las excepciones en el sistema
 */
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    /***
     * Esatodo del response
     */
    @Getter @Setter
    private int status;
    /***
     * Mensaje del response
     */
    @Getter @Setter
    private String message;
    /***
     * Fecha y hora del response
     */
    @Getter @Setter
    private Date timestamp;
    /***
     * Colección de errores
     */
    @Getter @Setter
    List<String> errors;

    /***
     * Constructor
     * @param message Mensaje personalizado de la excepción
     */
    ErrorResponse(String message) {
        this.message = message;
    }

}