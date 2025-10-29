import org.junit.Test;

public class MainTest {
    MathHelper Math = new MathHelper();
    @Test
    public void MyFirstTest() {
       // int a = Math.multiply(6);
       int b = Math.calc(5,0, '/');
        //System.out.println(a);
        System.out.println(b);
    }
}
