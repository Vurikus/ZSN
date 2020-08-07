package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.TESTRegisterDAO;
import web.model.Person;

import java.util.List;

@Service
public class RegisterService implements IRegisterService{
    //Field
    @Autowired
    private TESTRegisterDAO registerDAO;

    //Constructor

    //Function

    @Override
    public void addPerson(Person person) {
        registerDAO.addPerson(person);
    }

    @Override
    public Person getPerson(int code) {
        return registerDAO.getPerson(code);
    }

    @Override
    public List<Person> getAllPerson() {
        return registerDAO.getAllPerson();
    }

    @Override
    public void updatePerson(Person person) {
        registerDAO.updatePerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        registerDAO.deletePerson(person);
    }
}
