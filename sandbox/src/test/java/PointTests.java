import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {

        Point p = new Point(3, 5, 10, 15);
        Assert.assertEquals(p.distance(), 12.206555615733702);
    }
}
