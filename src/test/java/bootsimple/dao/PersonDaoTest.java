package bootsimple.dao;

import bootsimple.dao.PersonDao;
import bootsimple.entity.Person;
import org.dbunit.Assertion;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by twer on 2017/6/28.
 * For DBUnit training, on HSBC
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PersonDaoTest {

    @Autowired
    PersonDao personDao;

    @Autowired
    DataSource dataSource;
    private DataSourceDatabaseTester tester;


    @Test
    public void data_should_be_updated_() throws Exception {
        final Person person = new Person(1, "John", "Xu", "GD", "JohnX");
        final int updated = personDao.update(person);

        assertThat(updated,is(1));

        final IDataSet dataSetInDB = tester.getConnection().createDataSet(new String[]{"person"});
        final XlsDataSet postDataSet = new XlsDataSet(this.getClass().getResourceAsStream("postDataSet.xlsx"));

        Assertion.assertEquals(postDataSet,dataSetInDB);

    }

    @Before
    public void setUp() throws Exception {
        tester = new DataSourceDatabaseTester(dataSource);
        final XlsDataSet xlsDataSet = new XlsDataSet(this.getClass().getResourceAsStream("preDataSet.xlsx"));
        tester.setDataSet(xlsDataSet);
        tester.onSetup();
    }

    @After
    public void tearDown() throws Exception {
        tester.onTearDown();// call default teardown operation, so if do nothing if you not specify one
    }
}