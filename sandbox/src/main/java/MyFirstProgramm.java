public class MyFirstProgramm {

   public static void main(String[] args) {
       hello("world");
       hello("user");

       Square s = new Square(5);
   //    s.l = 5;
       System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

       Rectangle r = new Rectangle(4, 5);
      // r.a = 4;
      // r.b = 5;
       System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
   }

   public static void hello(String somebody) {
       System.out.println("Hello, " + somebody + "!");
   }
}