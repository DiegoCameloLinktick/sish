package co.com.acueducto.sish.models.configuracion;

import co.com.acueducto.sish.models.auditoria.AuditBasico;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


/***
 *  Clase de definición de la tabla de los dominios del sistema
 */
@Entity
@Table(name = "dominios")
public class DominioModel extends AuditBasico {

    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dominio", unique = true, nullable = false)
    @Getter @Setter
    private Integer idDominio;

    /***
     * Nombre del dominio
     */
    @Column(name = "dominio", nullable = false)
    @Getter @Setter
    private String dominio;

    /***
     *Descripción del dominio
     */
    @Column(name = "descripcion", nullable = false)
    @Getter @Setter
    private String descripcion;


}