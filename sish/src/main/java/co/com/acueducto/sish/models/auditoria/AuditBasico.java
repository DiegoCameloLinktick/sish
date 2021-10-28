package co.com.acueducto.sish.models.auditoria;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditBasico {



    /***
     * Fecha en que fue creado
     */
    @Column(name = "fecha_creacion", updatable = false)
    @Getter @Setter
    @CreatedDate
    private Date fechaCreacion;

    /***
     * Fecha en que fue modificado
     */
    @Column(name = "fecha_modificacion")
    @Getter @Setter
    @LastModifiedDate
    private Date fechaModificacion;


    /***
     * Usuario que realizó la creaciòn
     */
    @Column(name = "usuario_creacion", updatable = false)
    @Getter @Setter
    private String usuarioCreacion;

    /***
     * Usuario que realizó la modificación
     */
    @Column(name = "usuario_modificacion")
    @Getter @Setter
    private String usuarioModificacion;


}