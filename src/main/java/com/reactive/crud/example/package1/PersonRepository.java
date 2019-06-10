package com.reactive.crud.example.package1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {
}
