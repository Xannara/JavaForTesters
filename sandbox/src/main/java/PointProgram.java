public class PointProgram {
    public static void main(String[] args) {

        Point p = new Point(4, 6, 10, 15);
        //Point p1 = new Point(3, 5);
   //     p1.x = 3;
   //     p1.y = 5;

      //  Point p2 = new Point(10, 15);
   //     p2.x = 10;
   //     p2.y = 15;

        System.out.println("Расстояние между двумя точками с координатами " + "(" + p.x1 + ", " + p.y1 + ")" + " и "
                + "(" + p.x2 + ", " + p.y2 + ")" +" = " + p.distance());
    }

   /*  System.out.println("Расстояние между двумя точками с координатами " + "(" + p1.x + ", " + p1.y + ")" + " и "
            + "(" + p2.x + ", " + p2.y + ")" +" = " + p1.distance(p2));*/

     /* public static double distanceP(Point p1, Point p2) {
        return  Math.sqrt( Math.pow((p.x2 - p.x1), 2) + Math.pow((p.y2 - p.y1), 2));
    }

   /*public static double distance(Point p) {
        return  Math.sqrt( Math.pow((p.x2 - p.x1), 2) + Math.pow((p.y2 - p.y1), 2));
    }*/
}
