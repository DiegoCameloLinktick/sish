package co.com.acueducto.sish.models.auditoria;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.sql.Timestamp;

/***
 * Clase de definición de la tabla que contiene el log de auditoria de las operaciones realizadas en cada una de las tablas de la base de datos
 */
@Entity
@Table(name = "auditorias")
@Getter
@Setter
@ToString
public class AuditoriaModel {

    /***
     * Llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_auditoria", unique = true, nullable = false)
    private Long idAuditoria;
    /***
     * Fecha de la opercación
     */
    @Column(name="fecha_creacion",nullable = false)
    private Timestamp fechaCreacion;

    /***
     * Tipo de operacion, 1=Crear, 2=Modificar, 3=Eliminar
     */
    @Column(name="operacion", nullable = false)
    private Integer operacion;

    /***
     * Nombre de la entidad
     */
    @Column(name="nombre_entidad", nullable = false, length = 200)
    private String nombreEntidad;

    /***
     * Llave primaria del registro auditado
     */
    @Column(name="id", nullable = false)
    private Integer id;

    /***
     * Objeto despues de la operación
     */
    @Column(name="objeto",nullable = false)
    private String objeto;
    /***
     * Usuario que realizo la operación
     */
    @Column(name="usuario", nullable = false, length = 200)
    private String usuario;
}
