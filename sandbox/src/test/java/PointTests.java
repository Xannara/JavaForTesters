import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {

        Point p1 = new Point(4, 9);
        Point p2 = new Point(10, 15);
        Assert.assertEquals(p1.distance(p2), 8.48528137423857);
    }
}
