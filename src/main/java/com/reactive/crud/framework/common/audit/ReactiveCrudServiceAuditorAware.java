package com.reactive.crud.framework.common.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class ReactiveCrudServiceAuditorAware implements AuditorAware<String> {

    // TODO: Get username from security context
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Reactive Rest API");
    }
}