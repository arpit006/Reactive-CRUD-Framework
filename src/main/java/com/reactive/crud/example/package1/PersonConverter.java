package com.reactive.crud.example.package1;

import com.reactive.crud.example.package2.AddressConverter;
import com.reactive.crud.framework.convertor.BuilderConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Component
public class PersonConverter extends BuilderConverter<PersonEntity, PersonVo, PersonVo.PersonVoBuilder> {

    private AddressConverter addressConverter;

    public PersonConverter(DozerBeanMapper mapper, AddressConverter addressConverter) {
        super(mapper, PersonEntity.class, PersonVo.class, PersonVo.PersonVoBuilder.class);
        this.addressConverter = addressConverter;
    }

    @Override
    public List<String> notMappingFields() {
        return Arrays.asList("address", "mobileNo");
    }

    @Override
    public PersonEntity mapVoToEntity(PersonEntity entity, PersonVo vo) {
        PersonEntity personEntity = super.mapVoToEntity(entity, vo);
        personEntity.setAddress(addressConverter.convertVoToEntity(vo.getAddress()));
        personEntity.setMobileNo(vo.getMobileNo());
        return personEntity;
    }

    @Override
    public PersonVo mapEntityToVo(PersonEntity entity, PersonVo vo) {
        return vo.withAddress(addressConverter.convertEntityToVo(entity.getAddress()))
                .withMobileNo(entity.getMobileNo());
    }
}
