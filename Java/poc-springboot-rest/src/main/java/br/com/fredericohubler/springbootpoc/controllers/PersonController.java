package br.com.fredericohubler.springbootpoc.controllers;

import br.com.fredericohubler.springbootpoc.exceptions.FailToCreatePersonException;
import br.com.fredericohubler.springbootpoc.exceptions.PersonNotFoundException;
import br.com.fredericohubler.springbootpoc.model.Person;
import br.com.fredericohubler.springbootpoc.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService = new PersonService();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody Person person) throws FailToCreatePersonException {
        return personService.createPerson(person);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> listPersons(){
        return personService.listPersons();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonById(@PathVariable(value = "id") Integer id) throws PersonNotFoundException {
        return personService.getPersonById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}",
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person updatePerson(@PathVariable(value = "id") Integer id, @RequestBody Person person) throws PersonNotFoundException {
        return personService.updatePerson(id,person);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}",
                    method = RequestMethod.DELETE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person deletePerson(@PathVariable(value = "id") Integer id){
        return personService.deletePerson(id);
    }

}
