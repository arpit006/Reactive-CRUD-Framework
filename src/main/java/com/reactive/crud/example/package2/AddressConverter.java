package com.reactive.crud.example.package2;

import com.reactive.crud.framework.convertor.BuilderConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Component
public class AddressConverter extends BuilderConverter<AddressEntity, AddressVo, AddressVo.AddressVoBuilder> {

    public AddressConverter(DozerBeanMapper mapper) {
        super(mapper, AddressEntity.class, AddressVo.class, AddressVo.AddressVoBuilder.class);
    }

    @Override
    public List<String> notMappingFields() {
        return Collections.emptyList();
    }
}
