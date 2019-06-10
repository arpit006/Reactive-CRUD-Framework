package com.reactive.crud.example.package2;

import com.reactive.crud.framework.service.BaseDataServiceJpa;
import org.springframework.stereotype.Service;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Service
public class AddressService extends BaseDataServiceJpa<AddressEntity, AddressVo> implements IAddressService {

    private AddressRepository addressRepository;

    private AddressConverter addressConverter;

    public AddressService(AddressRepository addressRepository, AddressConverter addressConverter) {
        super(addressRepository, addressConverter);
        this.addressConverter = addressConverter;
        this.addressRepository = addressRepository;
    }
}
