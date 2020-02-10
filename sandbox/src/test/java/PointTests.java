import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {

        Point p1 = new Point(1.5, 5.9);
        Point p2 = new Point(9.1, 11.7);
        Assert.assertEquals(p1.distance(p2), 9.560334722173694);
    }
}
