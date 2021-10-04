package co.com.acueducto.sish.models.configuracion;

import javax.persistence.*;

@Entity
@Table(name = "dominios")
public class DominioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idDominio;
    private String dominio;

    public Long getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(Long id) {
        this.idDominio = idDominio;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    
}