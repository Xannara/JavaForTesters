public class PointProgram {
    public static void main(String[] args) {

        Point p1 = new Point(3, 5);
        p1.x = 5;
        p1.y = 7;

        Point p2 = new Point(10, 15);
        p2.x = 15;
        p2.y = 21;

        System.out.println("Расстояние между двумя точками с координатами " + "(" + p1.x + ", " + p1.y + ")" + " и "
                + "(" + p2.x + ", " + p2.y + ")" +" = " + p1.distance(p2));
    }
}
