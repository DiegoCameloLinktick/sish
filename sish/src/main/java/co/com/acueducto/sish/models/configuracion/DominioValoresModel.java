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
import java.math.BigDecimal;

/***
 *  Clase de definición de la tabla de los valores de los dominios
 */
@Entity
@Table(name = "DOMINIOS_VALORES")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class DominioValoresModel extends Audit {

    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOMINIOS_VALORES", unique = true, nullable = false)
    @Getter
    @Setter
    private Integer idDominiosValores;

    /***
     *id del dominio relacionado
     */
    @Column(name = "ID_DOMINIO", nullable = false)
    @NotNull(message = "El idDominio no puede ser nulo")
    @Getter @Setter
    private Integer idDominio;

    /***
     *nombre de los valores del dominio
     */
    @NotNull(message = "El nombre del valor no puede ser nulo")
    @Size(min = 2, message = "El nombre del valor debe tener al menos dos caracteres")
    @Column(name = "NOMBRE", nullable = false)
    @Getter @Setter
    private String nombre;




}
