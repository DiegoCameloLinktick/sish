package co.com.acueducto.sish.models.auditoria;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit extends AuditBasico{

    /***
     *Determina si esta activo S/N
     */
    @Column(name = "activo", nullable = false)
    @NotNull(message = "Activo no puede ser nulo")
    @Size(max = 1, message = "Activo debe tener maxímo un caracter")
    @Pattern(regexp = "^[SN]$", message = "Activo solo puede tenter S o N")
    @Getter
    @Setter
    private String activo;



    /***
     * Fecha cuando se cambia el valor que posee el campo activo
     */
    @Column(name = "fecha_estado" )
    @Getter @Setter
    private Timestamp fechaEstado;


    /***
     * Usuario que realizó la modificación del campo activo
     */
    @Column(name = "usuario_estado")
    @Getter @Setter
    private String usuarioEstado;

}
