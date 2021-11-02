package co.com.acueducto.sish.models.configuracion;

import co.com.acueducto.sish.models.auditoria.Audit;
import co.com.acueducto.sish.models.seguridad.RolModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/***
 *  Clase de definición de la tabla de los Parametros del sistema
 */
@Entity
@Table(name = "PARAMETROS")
public class ParametroModel extends Audit {
    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PARAMETRO", unique = true, nullable = false)
    @Getter @Setter
    private Integer idParametro;

    /***
     * Nombre del parametro
     */
    @NotNull(message = "El Parametro  no puede ser nulo")
    @Size(min = 2, message = "El Nombre del Parametro del valor debe tener al menos dos caracteres")
    @Column(name = "PARAMETRO", nullable = false)
    @Getter @Setter
    private String parametro;

    /***
     *Codigo  del Parametro
     */
    @NotNull(message = "El Codigo del parametro  no puede ser nulo")
    @Column(name = "CODIGO", nullable = false)
    @Getter @Setter
    private String codigo;

    /***
     *Descripcion   del Parametro
     */
    @NotNull(message = "la Descripcion del parametro  no puede ser nulo")
    @Column(name = "DESCRIPCION", nullable = false)
    @Getter @Setter
    private String descripcion;

    /***
     *Unidad De medidad   del Parametro
     */
    @ManyToOne
    @JoinColumn(name = "ID_UNIDAD_MEDIDA")
    @Getter @Setter
    private DominioValoresModel UnidadMedida;

    /***
     *Unidad De medidad   del Parametro
     */
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PARAMETRO")
    @Getter @Setter
    private DominioValoresModel TipoParametro;

    /***
     *Unidad De medidad   del Parametro
     */
    @ManyToOne
    @JoinColumn(name = "ID_METODO")
    @Getter @Setter
    private DominioValoresModel Metodo;

}

