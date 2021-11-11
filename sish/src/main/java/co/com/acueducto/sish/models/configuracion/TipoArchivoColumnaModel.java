package co.com.acueducto.sish.models.configuracion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/***
 *  Clase de definición de la tabla de los tipos de archivos configurados
 */
@Entity
@Table(name = "TIPOS_ARCHIVOS_COLUMNAS")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class TipoArchivoColumnaModel {

    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_ARCHIVO_COLUMNA", unique = true, nullable = false)
    @Getter
    @Setter
    private Integer idTipoArchivoColumna;

    /***
     *tipo de archivo columna
     */
    @NotNull(message = "El tipo de archivo columna no puede ser nulo")
    @Size(min = 2, message = "El tipo de archivo columna debe tener al menos dos caracteres")
    @Column(name = "TIPO_ARCHIVOS_COLUMNA", nullable = false)
    @Getter @Setter
    private String tipoArchivosColumna;

    /***
     * id tipo archivo configurado
     */
    @NotNull(message = "el id tipo archivo configurado no puede ser nulo")
    @Column(name = "ID_TIPO_ARCHIVO_CONFIGURADO", nullable = false)
    @Getter @Setter
    private Integer idTipoArchivoConfigurado;

    /***
     * numero columna
     */
    @NotNull(message = "el numero columna no puede ser nulo")
    @Column(name = "NUMERO_COLUMNA", nullable = false)
    @Getter @Setter
    private Integer numeroColumna;

    /***
     * id tipo dato
     */
    @NotNull(message = "el id tipo dato  no puede ser nulo")
    @Column(name = "ID_TIPO_DATO", nullable = false)
    @Getter @Setter
    private Integer idTipoDato;

    /***
     *formato origen
     */
    @NotNull(message = "El formato origen  no puede ser nulo")
    @Size(min = 2, message = "El formato origen debe tener al menos dos caracteres")
    @Column(name = "FORMATO_ORIGEN", nullable = false)
    @Getter @Setter
    private String formatoOrigen;

    /***
     * formato destino
     */
    @NotNull(message = "El formato destino no puede ser nulo")
    @Size(min = 2, message = "El formato destino debe tener al menos dos caracteres")
    @Column(name = "FORMATO_DESTINO", nullable = false)
    @Getter @Setter
    private String formatoDestino;




    /***
     * posicion inicial
     */
    @NotNull(message = "la posicion inicial no puede ser nulo")
    @Column(name = "POSICION_INICAL", nullable = false)
    @Getter @Setter
    private Integer posicionInicial;

    /***
     * posicion final
     */
    @NotNull(message = "el posicion final no puede ser nulo")
    @Column(name = "POSICION_FINAL", nullable = false)
    @Getter @Setter
    private Integer posicionFinal;

    /***
     * id tipo contenido
     */
    @NotNull(message = "el id tipo contenido no puede ser nulo")
    @Column(name = "ID_TIPO_CONTENIDO", nullable = false)
    @Getter @Setter
    private Integer idTipoContenido;
}
