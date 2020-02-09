public class Point {

    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public Point (double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

   /* double distance(double x, double y) {
        double px = this.x - x;
        double py = this.y - y;
        return  Math.sqrt(px*px + py*py);
    }*/

    /* public static double distanceP(Point p1, Point p2) {
        return  Math.sqrt( Math.pow((p.x2 - p.x1), 2) + Math.pow((p.y2 - p.y1), 2));
    }

    public double distance(Point p) {
        return distanceP();
    }*/

    public double distance() {
        return  Math.sqrt(Math.pow((this.x2 - this.x1), 2) + Math.pow((this.y2 - this.y1), 2));
    }

}
