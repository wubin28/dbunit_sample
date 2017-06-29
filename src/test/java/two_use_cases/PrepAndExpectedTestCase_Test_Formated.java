package two_use_cases;

import org.dbunit.DefaultPrepAndExpectedTestCase;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.VerifyTableDefinition;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;
import util.Configuration;

/**
 * Created by twer on 2017/6/24.
 *
 * ends with : org.dbunit.DatabaseUnitRuntimeException: Could not find file named=/Users/twer/git/dbunit/target/test-classes/two_use_cases/preDataSet.xml
 * but I don't know why
 *
 */
public class PrepAndExpectedTestCase_Test_Formated {

    private DefaultPrepAndExpectedTestCase prepAndExpectedTestCase;

    @Test
    public void setup_teardown_verify_but_not_include_call_test() throws Exception {
        final VerifyTableDefinition personTable = new VerifyTableDefinition("person", null);
        VerifyTableDefinition[] verifyTables = new VerifyTableDefinition[]{personTable};
        String[] prepDataFiles =  {"/two_use_cases/preDataSet.xml"};
        String[] expectedDataFiles = prepDataFiles;

        prepAndExpectedTestCase.preTest(verifyTables,prepDataFiles,expectedDataFiles);

        // call test here

        //call verify and clean, this clean call super.teardown() which should be override.
        prepAndExpectedTestCase.postTest();

    }


    @Before
    public void setUp() throws Exception {
        prepAndExpectedTestCase = new DefaultPrepAndExpectedTestCase("no");
        prepAndExpectedTestCase.setDataFileLoader(new FlatXmlDataFileLoader());
        prepAndExpectedTestCase.setDatabaseTester(new JdbcDatabaseTester(Configuration.driver, Configuration.url, Configuration.username, Configuration.password));

    }
}
