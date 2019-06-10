package com.reactive.crud.example.package2;

import com.reactive.crud.framework.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<AddressVo> {

    private IAddressService addressService;

    public AddressController(IAddressService addressService) {
        super(addressService);
        this.addressService = addressService;
    }
}
