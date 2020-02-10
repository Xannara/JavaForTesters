public class PointProgram {
    public static void main(String[] args) {

        Point p1 = new Point(4, 9);

        Point p2 = new Point(10, 15);

        System.out.println("Расстояние между двумя точками с координатами " + "(" + p1.x + ", " + p1.y + ")" + " и "
                + "(" + p2.x + ", " + p2.y + ")" +" = " + p1.distance(p2));
    }
}
