package com.reactive.crud.framework.convertor;

import com.reactive.crud.framework.entity.BaseEntity;
import com.reactive.crud.framework.vo.BaseVo;
import lombok.NonNull;
import org.dozer.Mapper;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public abstract class AbstractConverter<T extends BaseEntity, V extends BaseVo<V>> implements Converter<T, V> {

    private Mapper mapper;

    private Class<T> tClazz;

    private Class<V> vClazz;

    public AbstractConverter(Mapper mapper, Class<T> tClazz, Class<V> vClazz) {
        this.mapper = mapper;
        this.tClazz = tClazz;
        this.vClazz = vClazz;
    }

    public T convert(V vo) {
        return mapper.map(vo, tClazz);
    }

    public V convert(T t) {
        return mapper.map(t, vClazz);
    }

    @Override
    @NonNull
    public T convertVoToEntity(V vo) {
        return mapVoToEntity(convert(vo), vo);
    }

    @Override
    @NonNull
    public V convertEntityToVo(T t) {
        return mapEntityToVo(t, convert(t)).withUuid(t.getUuid());
    }

    @Override
    @NonNull
    public T updateEntityFromVo(T t, V vo) {
        mapper.map(t, vo);
        return mapVoToEntity(t, vo);
    }

    public T mapVoToEntity(T t, V vo) {
        return t;
    }

    public V mapEntityToVo(T t, V vo) {
        return vo;
    }
}
