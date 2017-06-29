package two_use_cases;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Configuration;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by twer on 2017/6/23.
 */
public class IDatabaseTesterTest {

    private JdbcDatabaseTester tester;
    private IDataSet dataSetInFile;

    @Test
    public void use_Tester_setup_teardown_and_Assertion_to_verify() throws Exception {


        // call tested code here

        final IDataSet dataSetInDB = tester.getConnection().createDataSet(new String[]{"person"});
        Assertion.assertEquals(dataSetInFile,dataSetInDB);
    }

    @Before
    public void setUp() throws Exception {

        tester = new JdbcDatabaseTester(Configuration.driver, Configuration.url, Configuration.username, Configuration.password);

        dataSetInFile = new XlsDataSet(this.getClass().getResourceAsStream("dataset.xlsx"));
        tester.setDataSet(dataSetInFile);
        tester.onSetup();
    }

    @After
    public void tearDown() throws Exception {

        tester.onTearDown();// call default teardown operation, so if do nothing if you not specify one
    }
}