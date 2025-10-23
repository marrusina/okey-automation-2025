import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert;

public class MainClassTest extends MainClass{

    @Test
    public void Test()
    {
        int b = this.getLocalNumber();
        if (b != 14)
        {
            Assert.fail("Num is not 14");
        }
    }
    @Test
    public void testGetClassNumber()
    {
        int c = this.getClassNumber();
        if (c < 45)
        {
            Assert.fail("Number is less then 45");
        }
    }

    @Test
    public void testGetClassString()
    {
        String a = this.getClassString();
        //boolean contains = a.contains("Hello");
        Assert.assertTrue("a.contains(\"Hello\")", a.contains("ty"));

    }

}
