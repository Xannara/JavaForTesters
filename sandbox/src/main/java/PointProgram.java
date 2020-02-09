public class PointProgram {
    public static void main(String[] args) {

        Point p1 = new Point(4, 6);
   //     p1.x = 3;
   //     p1.y = 5;

        Point p2 = new Point(10, 15);
   //     p2.x = 10;
   //     p2.y = 15;

        System.out.println("Расстояние между точками с координатами " + "(" + p1.x + ", " + p1.y + ")" + " и "
                + "(" + p2.x + ", " + p2.y + ")" +" = " + distance(p1, p2));
    }

    public static double distance(Point p1, Point p2) {
        return  Math.sqrt( Math.pow((p2.x - p1.x), 2)+Math.pow((p2.y - p1.y), 2));
    }
}
