package co.com.acueducto.sish.models.auditoria;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // here more code
        return null;
    }
}
