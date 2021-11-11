package co.com.acueducto.sish.models.configuracion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/***
 *  Clase de definición de la tabla de los departamentos
 */
@Entity
@Table(name = "DEPARTAMENTOS")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class DepartamentoModel {

    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEPARTAMENTO", unique = true, nullable = false)
    @Getter
    @Setter
    private Integer idDepartamento;

    /***
     *nombre del departamento
     */
    @NotNull(message = "El departamento no puede ser nulo")
    @Size(min = 2, message = "El departamento debe tener al menos dos caracteres")
    @Column(name = "DEPARTAMENTO", nullable = false)
    @Getter @Setter
    private String departamento;
}
