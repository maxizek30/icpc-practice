import java.awt.Point;
import java.util.Scanner;
public class y {
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Point [] vertices = new Point [n];
        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            Point currPoint = new Point(x,y);
            vertices[i] = currPoint;
            System.out.println("x: " + x + "y: " + y);
        }
        //find target area
        double targetArea = calcArea(vertices) / 2.0;
        //find desired edge
        

        
    }
    public static double calcArea(Point[] points) {
        double totalArea = 0;
        for(int i = 0; i < points.length - 2; i++) {
        
            Point currPoint = points[i];
            double x1 = currPoint.x;
            double y1 = currPoint.y;
            
            Point nextPoint = points[i + 1];
            double x2 = nextPoint.x;
            double y2 = nextPoint.y;
            
            Point originPoint = points[0];
            double x3 = originPoint.x;
            double y3 = originPoint.y;
            
 
            double triangleArea = 0.5 * (((x2 -x1) * (y3 - y1)) - ((y2 - y1) * (x3 -x1)));
            totalArea = totalArea + triangleArea;
        }
        return totalArea;
    }
}
