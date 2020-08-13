package web.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Person;

import java.util.List;

@Repository
@Transactional
public class ORMRepository implements IRegisterDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getAllPerson() {

        String query = "from Person";
        TypedQuery<Person> typedQuery = entityManager.createQuery(query, Person.class);
        return typedQuery.getResultList();
    }

    @Override
    public Person getPerson (int id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void updatePerson(Person person) {
        String query= "update Person set name=?, surname=?, patronymic=?, age=? where id_person = ?";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter(1, person.getName());
        nativeQuery.setParameter(2, person.getSurname());
        nativeQuery.setParameter(3, person.getPatronymic());
        nativeQuery.setParameter(4, person.getAge());
        nativeQuery.setParameter(5, person.getIdPerson());
        int result = nativeQuery.executeUpdate();
    }

    @Override
    public void addPerson(Person person) {

        String qlString = "insert into person (name, surname, patronymic, age) values (?,?,?,?)";
        Query query = entityManager.createNativeQuery(qlString);
        query.setParameter(1, person.getName());
        query.setParameter(2, person.getSurname());
        query.setParameter(3, person.getPatronymic());
        query.setParameter(4, person.getAge());
        int result = query.executeUpdate();
    }

    @Override
    public void deletePerson(Person person) {

        String delete = "delete from person where id_person=?";
        Query query = entityManager.createNativeQuery(delete);
        query.setParameter(1, person.getIdPerson());
        int result = query.executeUpdate();
    }
}