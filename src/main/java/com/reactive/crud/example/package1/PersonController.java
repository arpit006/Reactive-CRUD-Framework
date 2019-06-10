package com.reactive.crud.example.package1;

import com.reactive.crud.framework.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@RestController
@RequestMapping("/person")
public class PersonController  extends BaseController<PersonVo> {

    private IPersonService personService;

    public PersonController(IPersonService personService) {
        super(personService);
        this.personService = personService;
    }
}
