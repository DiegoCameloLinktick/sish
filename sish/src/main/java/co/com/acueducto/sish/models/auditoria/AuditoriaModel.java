package co.com.acueducto.sish.models.auditoria;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "auditorias")
@Getter
@Setter
@ToString
public class AuditoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_auditoria", unique = true, nullable = false)
    private Long idAuditoria;

    @Column(name="fecha",nullable = false)
    private Timestamp fecha;

    @Column(name="operacion", nullable = false)
    private Integer operacion;

    @Column(name="nombre_entidad", nullable = false, length = 200)
    private String nombreEntidad;

    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="objeto",nullable = false)
    private String objeto;

    @Column(name="usuario", nullable = false, length = 200)
    private String usuario;
}
