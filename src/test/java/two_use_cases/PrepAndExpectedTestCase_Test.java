package two_use_cases;

import org.dbunit.DefaultPrepAndExpectedTestCase;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PrepAndExpectedTestCaseSteps;
import org.dbunit.VerifyTableDefinition;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import util.Configuration;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by twer on 2017/6/24.
 * <p>
 * ends with : org.dbunit.DatabaseUnitRuntimeException: Could not find file named=/Users/twer/git/dbunit/target/test-classes/two_use_cases/preDataSet.xml
 * but I don't know why
 */
public class PrepAndExpectedTestCase_Test {

    private DefaultPrepAndExpectedTestCase prepAndExpectedTestCase;

    @Test()
    public void all_in_one() throws Exception {

        final VerifyTableDefinition personTable = new VerifyTableDefinition("person", new String[]{});
        VerifyTableDefinition[] verifyTables = new VerifyTableDefinition[]{personTable};

        final String[] setupDataSetFiles = {"/two_use_cases/preDataSet.xml"};
        final String[] expectedDataSetFiles = setupDataSetFiles;
        PrepAndExpectedTestCaseSteps testSteps = () -> {
            return "result";
        };

        final Object result = prepAndExpectedTestCase.runTest(verifyTables, setupDataSetFiles, expectedDataSetFiles, testSteps);

        assertThat(result,is("result"));

    }


    @Before
    public void setUp() throws Exception {
        prepAndExpectedTestCase = new DefaultPrepAndExpectedTestCase("no");

        prepAndExpectedTestCase.setDataFileLoader(new FlatXmlDataFileLoader());
        prepAndExpectedTestCase.setDatabaseTester(new JdbcDatabaseTester(Configuration.driver, Configuration.url, Configuration.username, Configuration.password));

    }




}
