package com.reactive.crud.framework.convertor;

import com.reactive.crud.framework.entity.BaseEntity;
import com.reactive.crud.framework.vo.BaseVo;
import lombok.NonNull;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public interface Converter<T extends BaseEntity, V extends BaseVo<V>> {

    @NonNull
    T convertVoToEntity(V vo);

    @NonNull
    V convertEntityToVo(T t);

    @NonNull
    T updateEntityFromVo(T t, V vo);
}
