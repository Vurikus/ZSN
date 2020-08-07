package web.service;

import web.model.Person;

import java.util.List;

public interface IRegisterService {
    void addPerson(Person person);
    Person getPerson(int code);
    List<Person> getAllPerson();
    void updatePerson(Person person);
    void deletePerson(Person person);
}
