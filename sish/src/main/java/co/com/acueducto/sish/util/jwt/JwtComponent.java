package co.com.acueducto.sish.util.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Component
public class JwtComponent {
    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.issuer}")
    private String issuer;

    @Value("${security.jwt.ttlMillis}")
    private long ttlMillis;



    /**
     * Crear un nuevo token
     *
     * @param id Identificador del usuario
     * @param subject asunto del token
     * @return Cadena del token
     */
    public String crearToken(String id, String subject) {

        // El algoritmo de firma JWT utilizado para firmar el token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // Firma JWT con nuestra secreta ApiKey
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //  Establecer JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // Construye el JWT y lo serializa en una cadena compacta y segura para URL
        return builder.compact();
    }

    /**
     * Método para validar y leer el Subject del JWT
     *
     * @param token token
     * @return cadena con el subject
     */
    public String obtenerSubject(String token) {

        // Esta línea lanzará una excepción si no es un JWS firmado
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret))
                .parseClaimsJws(token).getBody();

        return claims.getSubject();
    }

    /**
     * Método para validar y leer el la id del JWT
     *
     * @param token token
     * @return cadena con el id
     */
    public String obtenerId(String token) {
        // Esta línea lanzará una excepción si no es un JWS firmado
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret))
                .parseClaimsJws(token).getBody();

        return claims.getId();
    }
}
