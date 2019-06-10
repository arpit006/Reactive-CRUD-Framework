package com.reactive.crud.example.package1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.reactive.crud.example.package2.AddressVo;
import com.reactive.crud.framework.vo.BaseVo;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Value
@Wither
@Builder(toBuilder = true)
@JsonDeserialize(builder = PersonVo.PersonVoBuilder.class)
public class PersonVo implements BaseVo<PersonVo> {

    private String uuid;

    private String firstName;

    private String lastName;

    private int age;

    private String email;

    private double salary;

    private List<Long> mobileNo;

    private AddressVo address;

}
