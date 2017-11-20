package br.com.fredericohubler.springbootpoc.services;

import br.com.fredericohubler.springbootpoc.dao.PersonFakeDAO;
import br.com.fredericohubler.springbootpoc.exceptions.FailToCreatePersonException;
import br.com.fredericohubler.springbootpoc.exceptions.PersonNotFoundException;
import br.com.fredericohubler.springbootpoc.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    PersonFakeDAO personFakeDAO = new PersonFakeDAO();

    public Person createPerson(Person person) throws FailToCreatePersonException {
        if(personFakeDAO.createPerson(person)){
            return person;
        }

        throw new FailToCreatePersonException("Person not created");
    }

    public List<Person> listPersons(){
        return personFakeDAO.listPersons();
    }

    public Person updatePerson(Integer id, Person person) throws PersonNotFoundException {
        return personFakeDAO.updatePerson(id,person);
    }

    public Person deletePerson(Integer id){
        return personFakeDAO.deletePerson(id);
    }

    public Person getPersonById(Integer id) throws PersonNotFoundException {
        return personFakeDAO.getPersonById(id);
    }


}
