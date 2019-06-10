package com.reactive.crud.example.package2;

import com.reactive.crud.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Entity
@Table(name = "person_address")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AddressEntity extends BaseEntity<AddressEntity> {

    @Column(name = "HOUSE_NO")
    private int houseNo;

    @Column(name = "STREET_NO")
    private int streetNo;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;
}
