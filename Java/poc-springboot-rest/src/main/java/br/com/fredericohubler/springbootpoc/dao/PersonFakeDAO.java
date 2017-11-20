package br.com.fredericohubler.springbootpoc.dao;

import br.com.fredericohubler.springbootpoc.exceptions.PersonNotFoundException;
import br.com.fredericohubler.springbootpoc.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PersonFakeDAO {
    private ArrayList<Person> peopleList = new ArrayList<>();
    private final AtomicInteger autoID = new AtomicInteger();

    public boolean createPerson(Person person){
        if(person == null){
            return false;
        }

        person.setId(autoID.incrementAndGet());
        peopleList.add(person);
        return true;
    }

    public List<Person> listPersons(){
        return peopleList;
    }

    public Person getPersonById(Integer id) throws PersonNotFoundException {
        for (int i = 0; i < peopleList.size(); i++) {
            if(peopleList.get(i).getId().equals(id)){
                return peopleList.get(i);
            }
        }

        throw new PersonNotFoundException("Person don't exist");
    }

    public Person updatePerson(Integer id, Person personNew) throws PersonNotFoundException {

        Person personOld = getPersonById(id);
        personNew.setId(personOld.getId());
        peopleList.set(id-1,personNew);
        return personNew;
        /*for (int i = 0; i < peopleList.size(); i++) {
            if(peopleList.get(i).getId().equals(id)){
               peopleList.set(i,person);
               return person;
            }
        }
        */

        //throw new PersonNotFoundException("Person don't exist");
    }

    public Person deletePerson (Integer id){
        Person personDeleted = peopleList.get(id-1);
        peopleList.remove(id-1);
        return personDeleted;
    }
}
