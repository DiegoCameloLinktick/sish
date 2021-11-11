package co.com.acueducto.sish.models.configuracion;

import co.com.acueducto.sish.models.auditoria.Audit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/***
 *  Clase de definición de la tabla de los metodos por tipo parametro
 */
@Entity
@Table(name = "METODOS_X_TIPO_PARAMETRO")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class MetodoXTipoParametroModel extends Audit {

    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_METODO_X_TIPO_PARAMETRO", unique = true, nullable = false)
    @Getter
    @Setter
    private Integer idMetodoXTipoParametro;

    /***
     *id de tipo del parámetro
     */
    @NotNull(message = "el id tipo parametro  no puede ser nulo")
    @Column(name = "ID_TIPO_PARAMETRO", nullable = false)
    @Getter @Setter
    private Integer idTipoParametro;

    /***
     *id del metodo
     */
    @NotNull(message = "el id metodo  no puede ser nulo")
    @Column(name = "ID_METODO", nullable = false)
    @Getter @Setter
    private Integer idMetodo;

}
