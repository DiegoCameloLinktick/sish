package co.com.acueducto.sish.models.configuracion;


import co.com.acueducto.sish.models.auditoria.Audit;
import co.com.acueducto.sish.models.auditoria.AuditBasico;
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
@Table(name = "TIPOS_ARCHIVOS_CONFIGURADOS")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class TipoArchivoConfiguradoModel extends Audit {


    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_ARCHIVO_CONFIGURADO", unique = true, nullable = false)
    @Getter
    @Setter
    private Integer idTipoArchivoConfigurado;

    /***
     * tipo de archivo configurado
     */
    @NotNull(message = "El valor no puede ser nulo")
    @Size(min = 2, message = "El valor debe tener al menos dos caracteres")
    @Column(name = "TIPO_ARCHIVO_CONFIGURADO", nullable = false)
    @Getter @Setter
    private String tipoArchivoConfigurado;

    /***
     * id del tipo de categoria
     */
    @NotNull(message = "el tipo de categoria no puede ser nulo")
    @Column(name = "ID_TIPO_ARCHIVO", nullable = false)
    @Getter @Setter
    private Integer idTipoCategoria;


    /***
     * id del tipo de fraccionamiento
     */
    @NotNull(message = "el tipo de fraccionamiento no puede ser nulo")
    @Column(name = "ID_TIPO_FRACCIONAMIENTO", nullable = false)
    @Getter @Setter
    private Integer idTipoFraccionamiento;


    /***
     * id de la ubicacion de datos
     */
    @NotNull(message = "el id de la ubicacion de datos no puede ser nulo")
    @Column(name = "ID_UBICACION_DATOS", nullable = false)
    @Getter @Setter
    private Integer idUbicacionDatos;


    /***
     * separador
     */
    @NotNull(message = "El valor no puede ser nulo")
    @Size(min = 2, message = "El valor debe tener al menos dos caracteres")
    @Column(name = "SEPARADOR", nullable = false)
    @Getter @Setter
    private String separador;

    /***
     * calificacion del texto
     */
    @NotNull(message = "El valor no puede ser nulo")
    @Size(min = 2, message = "El valor debe tener al menos dos caracteres")
    @Column(name = "CALIFICADOR_TEXTO", nullable = false)
    @Getter @Setter
    private String calificacionTexto;


    /***
     * si contiene encabezado el archivo
     */
    @NotNull(message = "El valor no puede ser nulo")
    @Size(min = 2, message = "El valor debe tener al menos dos caracteres")
    @Column(name = "CONTIENE_ENCABEZADO", nullable = false)
    @Getter @Setter
    private String contieneEncabezado;


    /***
     * sie el archivo contiene resumen
     */
    @NotNull(message = "El valor no puede ser nulo")
    @Size(min = 2, message = "El valor debe tener al menos dos caracteres")
    @Column(name = "CONTIENE_RESUMEN", nullable = false)
    @Getter @Setter
    private String contieneResumen;


    /***
     * si contiene separador decimal
     */
    @NotNull(message = "El valor no puede ser nulo")
    @Size(min = 2, message = "El valor debe tener al menos dos caracteres")
    @Column(name = "SEPARADOR_DECIMAL", nullable = false)
    @Getter @Setter
    private String separadorDecimal;

    /***
     * id de la frecuencia Temporal
     */
    @NotNull(message = "el id de la ubicacion de datos no puede ser nulo")
    @Column(name = "ID_FRECUENCIA_TEMPORAL", nullable = false)
    @Getter @Setter
    private Integer idFrecuenciaTemporal;
    /***
     * intervalo de la frecuencia temporal
     */
    @NotNull(message = "el id de la ubicacion de datos no puede ser nulo")
    @Column(name = "INTERVALO_FRECUENCIA_TEMPORAL", nullable = false)
    @Getter @Setter
    private Integer intervaloFrecuenciaTemporal;
    /***
     * id dtipo de codificacion
     */
    @NotNull(message = "el id de la ubicacion de datos no puede ser nulo")
    @Column(name = "ID_TIPO_CODIFICACION", nullable = false)
    @Getter @Setter
    private Integer idTipoCodificacion;

}
