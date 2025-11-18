package tests;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;

import lib.CoreTestCase;
import org.junit.Test;
import org.sikuli.script.FindFailed;

public class WelcomeTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = MainPageObjectFactory.get(driver);
    }

}
