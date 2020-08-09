package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import web.model.Person;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JDBCRepository implements IRegisterDAO {

    @Autowired
    DriverManagerDataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getAllPerson() {
        final String QUERY_SQL = "SELECT * FROM person;";
        List<Person> personList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<Person>() {
            public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Person person = new Person();
                person.setIdPerson(resultSet.getInt("id_person"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setPatronymic(resultSet.getString("patronymic"));
                person.setAge(resultSet.getInt("age"));
                return person;
            }
        });
        return personList;
    }

    @Override
    public void addPerson(Person person) {
        final String INSERT = "INSERT INTO person (name, surname, patronymic, age) VALUES (?,?,?,?);";
        this.jdbcTemplate.update(INSERT, person.getName(), person.getSurname(), person.getPatronymic(), person.getAge());
    }

    @Override
    public Person getPerson(int code) {
        final String SELECT = "SELECT * FROM person WHERE id_person=?";
        Person person = this.jdbcTemplate.queryForObject(SELECT, new Object[]{code}, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int i) throws SQLException {
                return new Person(rs.getInt("id_person"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("patronymic"), rs.getInt("age"));
            }
        });
        return person;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {

    }
}