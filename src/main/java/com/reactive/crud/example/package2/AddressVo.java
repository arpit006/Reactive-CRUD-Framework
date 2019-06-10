package com.reactive.crud.example.package2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.reactive.crud.framework.vo.BaseVo;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Value
@Wither
@Builder(toBuilder = true)
@JsonDeserialize(builder = AddressVo.AddressVoBuilder.class)
public class AddressVo implements BaseVo<AddressVo> {

    private String uuid;

    private int houseNo;

    private int streetNo;

    private String city;

    private String country;
}
