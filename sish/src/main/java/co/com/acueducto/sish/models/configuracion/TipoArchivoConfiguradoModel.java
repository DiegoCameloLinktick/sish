package co.com.acueducto.sish.models.configuracion;


import co.com.acueducto.sish.models.auditoria.AuditBasico;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/***
 *  Clase de definición de la tabla de los valores de los dominios
 */
@Entity
@Table(name = "TIPOS_ARCHIVOS_CONFIGURADOS")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class TipoArchivoConfiguradoModel extends AuditBasico {


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



}
