//package web.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Repository;
//import web.model.Person;
//
//import java.util.List;
//
//@Repository("register")
//public class RegisterDAO implements IRegisterDAO{
//    //Field
//
//    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
//    private static final Logger logger = LoggerFactory.getLogger(RegisterDAO.class);
//
//    //Constructor
//
//    //Function
//
//    @Override
//    public void addPerson(Person person) {
//        Session session = sessionFactory.openSession();
//
//        session.persist(person);
//        logger.info("Person successfully saved. Person id: " + person.getIdPerson());
//    }
//
//    @Override
//    public Person getPerson(int code) {
//        Session session = sessionFactory.openSession();
//        //Session session = this.sessionFactory.getCurrentSession();
//        Person person = session.load(Person.class, new Integer(code));
//        logger.info("Person get. Person id: " + person.getIdPerson());
//        return person;
//    }
//
//    @Override
//    public List<Person> getAllPerson() {
//        Session session = sessionFactory.openSession();
//        //Session session = this.sessionFactory.getCurrentSession();
//
//        List <Person> list = session.createQuery("from Person").list();
//        return list;
//    }
//
//    @Override
//    public void updatePerson(Person person) {
//        Session session = sessionFactory.openSession();
//
//        //Session session = this.sessionFactory.getCurrentSession();
//        session.update(person);
//        logger.info("Person successfully update. Person id: " + person.getIdPerson());
//    }
//
//    @Override
//    public void deletePerson(Person person) {
//        Session session = sessionFactory.openSession();
//        //Session session = this.sessionFactory.getCurrentSession();
//        session.delete(person);
//        logger.info("Person successfully removed. Person id: " + person.getIdPerson());
//    }
//
//
//    //Getter and Setter
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//}
