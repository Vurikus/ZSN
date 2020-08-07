package web.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import web.model.Person;

import java.util.ArrayList;
import java.util.List;

@Repository("TEST")
public class TESTRegisterDAO implements IRegisterDAO{
    //Field
    private List<Person> list = new ArrayList<>();

    //Constructor

    //Function
    @Override
    public void addPerson(Person person) {
        list.add(person);
    }

    @Override
    public Person getPerson(int code) {
        return list.get(code);
    }

    @Override
    public List<Person> getAllPerson() {
        return list;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {

    }


    //Getter and Setter
}
