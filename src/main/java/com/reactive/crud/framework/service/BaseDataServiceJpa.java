package com.reactive.crud.framework.service;

import com.reactive.crud.framework.convertor.AbstractConverter;
import com.reactive.crud.framework.entity.BaseEntity;
import com.reactive.crud.framework.exception.NotFoundException;
import com.reactive.crud.framework.vo.BaseVo;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class BaseDataServiceJpa<T extends BaseEntity<T>, V extends BaseVo<V>> implements DataService<V> {

    JpaRepository<T, String> repository;

    AbstractConverter<T, V> converter;

    public BaseDataServiceJpa(JpaRepository<T, String> repository, AbstractConverter<T, V> abstractConverter) {
        this.repository = repository;
        this.converter = abstractConverter;
    }

    public Mono<T> convertVoToEntity(V vo) {
        return Mono.just(converter.convertVoToEntity(vo));
    }

    public Mono<V> convertEntityToVo(T t) {
        return Mono.just(converter.convertEntityToVo(t));
    }

    public Mono<T> updateEntityFromVo(T t, V v) {
        return Mono.just(converter.updateEntityFromVo(t, v));
    }

    @Override
    @NonNull
    public Mono<V> create(V vo) {
        return Mono.just(vo)
                .flatMap(this::convertVoToEntity)
                .flatMap(this::save);
    }

    @Override
    @NonNull
    public Mono<V> update(String uuid, V vo) {
        return updateRecord(() -> repository.findById(uuid), vo, String.format("UUID %s not found.", uuid));
    }

    private Mono<V> updateRecord(Supplier<Optional<T>> queryFunction, V vo, String notFoundMessage) {
        return Mono.fromSupplier(queryFunction)
                .map(o -> o.orElseThrow(() -> new NotFoundException(notFoundMessage)))
                .flatMap(e -> this.updateEntityFromVo(e, vo))
                .flatMap(this::save);
    }

    @Override
    @NonNull
    public Flux<V> findAll() {
        return findListRecords(repository::findAll);
    }

    @Override
    @NonNull
    public Mono<V> findByUuid(String uuid) {
        return findUniqueRecord(() -> repository.findById(uuid));
    }

    @Override
    @NonNull
    public Mono<Boolean> delete(String uuid) {
        return Mono.fromSupplier(() -> {
            repository.deleteById(uuid);
            return true;
        });
    }

    public Mono<V> save(T t) {
        return Mono.fromSupplier(() -> repository.save(t)).flatMap(this::convertEntityToVo);
    }

    public Flux<V> findListRecords(Supplier<Iterable<T>> queryFunction) {
        return Mono.fromSupplier(queryFunction)
                .flatMapIterable(Function.identity())
                .flatMap(this::convertEntityToVo);
    }

    public Mono<V> findUniqueRecord(Supplier<Optional<T>> queryFunction) {
        return Mono.fromSupplier(queryFunction)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .flatMap(this::convertEntityToVo);
    }

}
