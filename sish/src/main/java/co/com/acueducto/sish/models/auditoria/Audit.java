package co.com.acueducto.sish.models.auditoria;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
@Getter
@Setter
public class Audit {


    /***
     * Fecha en que fue creado
     */
    @Column(name = "fecha_creacion")
    @Getter @Setter
    private Timestamp fechaCreacion;

    /***
     * Fecha en que fue modificado
     */
    @Column(name = "fecha_modificacion")
    @Getter @Setter
    private Timestamp fechaModificacion;

    /***
     * Fecha cuando se cambia el valor que posee el campo activo
     */
    @Column(name = "fecha_estado")
    @Getter @Setter
    private Timestamp fechaEstado;

    /***
     * Usuario que realizó la creaciòn
     */
    @Column(name = "usuario_creacion")
    @Getter @Setter
    private String usuarioCreacion;

    /***
     * Usuario que realizó la modificación
     */
    @Column(name = "usuario_modificacion")
    @Getter @Setter
    private String usuarioModificacion;

    /***
     * Usuario que realizó la modificación del campo activo
     */
    @Column(name = "usuario_estado")
    @Getter @Setter
    private String usuarioEstado;
}