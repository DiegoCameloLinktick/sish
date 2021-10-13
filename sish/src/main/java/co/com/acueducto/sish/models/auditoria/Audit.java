package co.com.acueducto.sish.models.auditoria;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {


    /***
     * Fecha en que fue creado
     */
    @Column(name = "fecha_creacion", updatable = false)
    @Getter @Setter
    @CreatedDate
    private Timestamp fechaCreacion;

    /***
     * Fecha en que fue modificado
     */
    @Column(name = "fecha_modificacion", updatable = false)
    @Getter @Setter
    @LastModifiedDate
    private Timestamp fechaModificacion;

    /***
     * Fecha cuando se cambia el valor que posee el campo activo
     */
    @Column(name = "fecha_estado" , updatable = false)
    @Getter @Setter
    private Timestamp fechaEstado;

    /***
     * Usuario que realizó la creaciòn
     */
    @Column(name = "usuario_creacion", updatable = false)
    @Getter @Setter
    private String usuarioCreacion;

    /***
     * Usuario que realizó la modificación
     */
    @Column(name = "usuario_modificacion", updatable = false)
    @Getter @Setter
    private String usuarioModificacion;

    /***
     * Usuario que realizó la modificación del campo activo
     */
    @Column(name = "usuario_estado", updatable = false)
    @Getter @Setter
    private String usuarioEstado;
}