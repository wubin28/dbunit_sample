package bootsimple.dao;

import bootsimple.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by twer on 2017/6/28.
 */
@Component
public class PersonDao implements IPersonDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int  update(Person person){

        final String sql = "update person set firstname=?, lastname=?,username=? where id=?";
        return jdbcTemplate.update(sql, person.getFirstname(), person.getLastname(), person.getUsername(), person.getId());
    }
}
