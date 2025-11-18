package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.FirstTest;

@RunWith(Suite.class)

@Suite.SuiteClasses(
        {
                FirstTest.class
        }
)

public class TestSuite {}
