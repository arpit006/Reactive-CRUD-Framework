package com.reactive.crud.example.package1;

import com.reactive.crud.example.package2.AddressEntity;
import com.reactive.crud.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PersonEntity extends BaseEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private int age;

    @Column(name = "EMAIL_ID")
    private String email;

    @Column(name = "SALARY")
    private double salary;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ElementCollection(targetClass = Long.class)
    @Column(name = "MOBILE_NO")
    private List<Long> mobileNo;

    @OneToOne
//    @Column(name = "PERSON_ADDRESS")
    private AddressEntity address;
}
