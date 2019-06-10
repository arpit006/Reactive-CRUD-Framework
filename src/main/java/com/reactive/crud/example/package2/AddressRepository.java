package com.reactive.crud.example.package2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, String> {
}
