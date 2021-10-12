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
    @Column(name = "id_dominio", unique = true, nullable = false)
    @Getter @Setter
    private Integer idDominio;

    @Column(name = "dominio", nullable = false)
    @Getter @Setter
    private String dominio;

    @Column(name = "descripcion", nullable = false)
    @Getter @Setter
    private String descripcion;

    
}