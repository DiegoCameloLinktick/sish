package co.com.acueducto.sish.models.configuracion;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/***
 *  Clase de definición de la tabla de los municipios
 */
@Entity
@Table(name = "MUNICIPIOS")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class MunicipioModel {

    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MUNICIPIO", unique = true, nullable = false)
    @Getter
    @Setter
    private Integer idMunicipio;

    /***
     *nombre del municipio
     */
    @NotNull(message = "El municipio no puede ser nulo")
    @Size(min = 2, message = "El municipio debe tener al menos dos caracteres")
    @Column(name = "MUNICIPIO", nullable = false)
    @Getter @Setter
    private String municipio;


    /***
     *id del departamento relacionado
     */
    @Column(name = "ID_DEPARTAMENTO", nullable = false)
    @NotNull(message = "El idDepartamento no puede ser nulo")
    @Getter @Setter
    private Integer idDepartamento;
}
