package co.com.acueducto.sish.models.configuracion;

import co.com.acueducto.sish.models.auditoria.AuditBasico;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/***
 *  Clase de definición de la tabla de estaciones
 */
@Entity
@Table(name = "ESTACIONES")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class EstacionModel extends AuditBasico {


    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTACION", unique = true, nullable = false)
    @Getter
    @Setter
    private Integer idEstacion;

        /***
         *nombre de la estacion
         */
        @NotNull(message = "El valor no puede ser nulo")
        @Size(min = 2, message = "El valor debe tener al menos dos caracteres")
        @Column(name = "ESTACION", nullable = false)
        @Getter @Setter
        private String estacion;

    /***
     *codigoEstacionEaab
     */
    @Column(name = "CODIGO_ESTACION_EAAB", nullable = false)
    @Getter @Setter
    private String codigoEstacionEaab;

    /***
     *codigoEstacionIdeam
     */
    @Column(name = "CODIGO_ESTACION_IDEAM", nullable = false)
    @Getter @Setter
    private String codigoEstacionIdeam;

    /***
     * id de la categoria
     */
    @NotNull(message = "la categoria de la estacion no puede ser nulo")
    @Column(name = "ID_CATEGORIA", nullable = false)
    @Getter @Setter
    private Integer idCategoria;

    /***
     * id de la tecnologia
     */
    @NotNull(message = "la tecnologia de la estacion no puede ser nulo")
    @Column(name = "ID_TECNOLOGIA", nullable = false)
    @Getter @Setter
    private Integer idTecnologia;

    /***
     * id del tipo de estacion
     */
    @NotNull(message = "el tipo de estacion no puede ser nulo")
    @Column(name = "ID_TIPO_ESTACION", nullable = false)
    @Getter @Setter
    private Integer idTipoEstacion;

    /***
     * id de la entidad
     */
    @NotNull(message = "la entidad no puede ser nulo")
    @Column(name = "ID_ENTIDAD", nullable = false)
    @Getter @Setter
    private Integer idEntidad;

    /***
     * id del estado
     */
    @NotNull(message = "el estado no puede ser nulo")
    @Column(name = "ID_ESTADO", nullable = false)
    @Getter @Setter
    private Integer idEstado;

    /***
     * Fecha en que fue instalada
     */
    @Column(name = "FECHA_INSTALACION", updatable = false)
    @Getter @Setter
    @CreatedDate
    private Date fechaInstalacion;

    /***
     * altitud
     */
    @Column(name = "ALTITUD", nullable = false)
    @Getter @Setter
    private Integer altitud;

    /***
     *corriente
     */
    @Column(name = "CORRIENTE", nullable = false)
    @Getter @Setter
    private String corriente;

    /***
     *ZONA_OPERATIVA_EAAB
     */
    @Column(name = "ZONA_OPERATIVA_EAAB", nullable = false)
    @Getter @Setter
    private String zonaOperativaEaab;

    /***
     * id del municipio
     */
    @NotNull(message = "el id del municipio no puede ser nulo")
    @Column(name = "ID_MUNICIPIO", nullable = false)
    @Getter @Setter
    private Integer idMunicipio;

    /***
     * area hidrografica
     */
    @NotNull(message = "El area hidrografica no puede ser nulo")
    @Column(name = "AREA_HIDROGRAFICA", nullable = false)
    @Getter @Setter
    private String areaHidrografica;

    /***
     *zona hidrografica
     */
    @NotNull(message = "la zona hidrografica no puede ser nulo")
    @Column(name = "ZONA_HIDROGRAFICA", nullable = false)
    @Getter @Setter
    private String zonaHidrografica;

    /***
     * sub zona hidrografica
     */
    @NotNull(message = "la sub zona hidrografica no puede ser nulo")
    @Column(name = "SUBZONA_HIDROGRAFICA", nullable = false)
    @Getter @Setter
    private String subZonaHidrografica;

    /***
     * nivel subsiguiente
     */
    @Column(name = "NIVEL_SUBSIGUIENTE", nullable = false)
    @Getter @Setter
    private String nivelSubSiguiente;

    /***
     * cuenca
     */
    @Column(name = "CUENCA", nullable = false)
    @Getter @Setter
    private String cuenca;

    /***
     * microcuenca
     */
    @Column(name = "MICROCUENCA", nullable = false)
    @Getter @Setter
    private String microCuenca;

    /***
     * id tipo de coordenada
     */
    @NotNull(message = "el id del tipo de coordenada no puede ser nulo")
    @Column(name = "ID_TIPO_COORDENADAS", nullable = false)
    @Getter @Setter
    private Integer idTipoCoordenadas;

    /***
     * latitud
     */
    @Column(name = "LATITUD", nullable = false)
    @Getter @Setter
    private Integer latitud;

    /***
     * norte
     */
    @Column(name = "NORTE", nullable = false)
    @Getter @Setter
    private Integer norte;

    /***
     * este
     */
    @Column(name = "ESTE", nullable = false)
    @Getter @Setter
    private Integer este;

}
