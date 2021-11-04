package co.com.acueducto.sish.models.configuracion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/***
 *  Clase de definición de la tabla de los parametros por estacion
 */
@Entity
@Table(name = "PARAMETROS_X_ESTACION")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class ParametroXEstacionModel {

    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PARAMETRO_X_ESTACION", unique = true, nullable = false)
    @Getter
    @Setter
    private Integer idParametroXEstacion;

    /***
     *id del parametro relacionado
     */
    @Column(name = "ID_PARAMETRO", nullable = false)
    @NotNull(message = "El idParametro no puede ser nulo")
    @Getter @Setter
    private Integer idParametro;

    /***
     *id de la estacion relacionada
     */
    @Column(name = "ID_ESTACION", nullable = false)
    @NotNull(message = "El idEstacion no puede ser nulo")
    @Getter @Setter
    private Integer idEstacion;


}
