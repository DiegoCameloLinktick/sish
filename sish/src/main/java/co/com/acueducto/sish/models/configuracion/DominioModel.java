package co.com.acueducto.sish.models.configuracion;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/***
 *  Clase de definición de la tabla de los dominios del sistema
 */
@Entity
@Table(name = "dominios")
public class DominioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter @Setter
    private Long idDominio;

    @Getter @Setter
    private String dominio;

    @Getter @Setter
    private String descripcion;

    
}