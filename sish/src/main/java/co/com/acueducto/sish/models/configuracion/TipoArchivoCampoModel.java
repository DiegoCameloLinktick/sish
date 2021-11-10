package co.com.acueducto.sish.models.configuracion;

import co.com.acueducto.sish.models.auditoria.Audit;
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
@Table(name = "TIPOS_ARCHIVOS_CAMPOS")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class TipoArchivoCampoModel {

    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_ARCHIVO_CAMPO", unique = true, nullable = false)
    @Getter
    @Setter
    private Integer idTipoArchivoCampo;

    /***
     * id del tipo de archivo configurado
     */
    @NotNull(message = "el id del tipo de archivo configurado no puede ser nulo")
    @Column(name = "ID_TIPO_ARCHIVO_CONFIGURADO", nullable = false)
    @Getter @Setter
    private Integer idTipoArchivoConfigurado;
    /***
     * id del tipo de archivo columna
     */
    @NotNull(message = "el id detipo de archivo columna no puede ser nulo")
    @Column(name = "ID_TIPO_ARCHIVO_COLUMNA", nullable = false)
    @Getter @Setter
    private Integer idTipoArchivoColumna;
    /***
     * id de tipo de archivo columna con propiedades
     */
    @NotNull(message = "el id de tipo de archivo columna con propiedades no puede ser nulo")
    @Column(name = "ID_TIPO_ARCHIVO_COLUMNA_PROPIEDAD", nullable = false)
    @Getter @Setter
    private Integer idTipoArchivoColumnaPropiedad;

    /***
     *codigo propiedad
     */
    @NotNull(message = "El codigo propiedad no puede ser nulo")
    @Size(min = 2, message = "El codigo propiedad debe tener al menos dos caracteres")
    @Column(name = "CODIGO_PROPIEDAD", nullable = false)
    @Getter @Setter
    private String codigoPropiedad;

    /***
     * id del parametro
     */
    @NotNull(message = "el id parametro no puede ser nulo")
    @Column(name = "ID_PARAMETRO", nullable = false)
    @Getter @Setter
    private Integer idParametro;

    /***
     *ccampo relacionado
     */
    @NotNull(message = "El campo relacionado no puede ser nulo")
    @Size(min = 2, message = "El campo relacionado debe tener al menos dos caracteres")
    @Column(name = "CAMPO_RALACIONADO", nullable = false)
    @Getter @Setter
    private String campoRelacionado;


}
