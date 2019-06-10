package com.reactive.crud.example.package1;

import com.reactive.crud.framework.service.BaseDataServiceJpa;
import org.springframework.stereotype.Service;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Service
public class PersonService extends BaseDataServiceJpa<PersonEntity, PersonVo> implements IPersonService{

    private PersonConverter personConverter;

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository, PersonConverter personConverter) {
        super(personRepository, personConverter);
        this.personConverter = personConverter;
        this.personRepository = personRepository;
    }
}
