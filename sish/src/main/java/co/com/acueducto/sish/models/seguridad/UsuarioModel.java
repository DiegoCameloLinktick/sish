package co.com.acueducto.sish.models.seguridad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/***
 *  Clase de definición de la tabla de los usuarios del sistema
 */
@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario",unique = true, nullable = false)
    @Getter
    @Setter
    private Long idUsuario;

    @Column(name = "nombre", nullable = false)
    @Getter @Setter
    private String nombre;

    @Column(name = "correo", nullable = false)
    @Getter @Setter
    private String correo;
}
