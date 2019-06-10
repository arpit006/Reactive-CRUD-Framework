package com.reactive.crud.framework.controller;

import com.reactive.crud.framework.service.DataService;
import com.reactive.crud.framework.vo.BaseVo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public abstract class BaseController<V extends BaseVo<V>> {

    private DataService<V> dataService;

    public BaseController(DataService<V> dataService) {
        this.dataService = dataService;
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public Mono<V> create(V vo) {
        return dataService.create(vo);
    }

    @GetMapping(value = "", consumes = "application/json", produces = "application/json")
    public Flux<V> findAll() {
        return dataService.findAll();
    }

    @PutMapping(value = "/{uuid}", consumes = "application/json", produces = "application/json")
    public Mono<V> update(@PathVariable String uuid, @RequestBody V vo) {
        return dataService.update(uuid, vo);
    }

    @GetMapping(value = "/{uuid}", consumes = "application/json", produces = "application/json")
    public Mono<V> findByUuid(@PathVariable String uuid) {
        return dataService.findByUuid(uuid);
    }

    @DeleteMapping(value = "/{uuid}", consumes = "application/json", produces = "application/json")
    public Mono<Boolean> deleteByUuid(@PathVariable String uuid) {
        return dataService.delete(uuid);
    }
}
