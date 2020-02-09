import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {

        Point p = new Point(4, 6, 10, 15);
        Assert.assertEquals(p.distance(), 10.816653826391969);
    }
}
