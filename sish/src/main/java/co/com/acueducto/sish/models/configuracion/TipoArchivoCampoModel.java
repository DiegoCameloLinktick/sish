package co.com.acueducto.sish.models.configuracion;

import co.com.acueducto.sish.models.auditoria.Audit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/***
 *  Clase de definición de la tabla de los tipos de archivos configurados
 */
@Entity
@Table(name = "TIPOS_ARCHIVOS_CONFIGURADOS")
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

}
