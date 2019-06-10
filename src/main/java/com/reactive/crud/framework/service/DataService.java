package com.reactive.crud.framework.service;

import com.reactive.crud.framework.vo.BaseVo;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public interface DataService<V extends BaseVo<V>> {

    @NonNull
    Mono<V> create(V vo);

    @NonNull
    Mono<V> update(String uuid, V vo);

    @NonNull
    Flux<V> findAll();

    @NonNull
    Mono<V> findByUuid(String uuid);

    @NonNull
    Mono<Boolean> delete(String uuid);
}
