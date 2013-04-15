import org.fruit.alayer.Spline;
import org.fruit.alayer.Point;
import java.util.List;
import java.util.Random;

public class Test{
    static final int  SEED = 500,
                      POINTS = 3,
                      GRANULARITY = 100,
                      WIDTH = 50,
                      HEIGHT = 20;
    static final char buffer[] = new char[WIDTH * HEIGHT];

    public static void main(String[] args){
        Random rnd = new Random(SEED);
        Point points[] = new Point[POINTS];

        for(int i = 0; i < POINTS; i++)
            points[i] = Point.from(rnd.nextInt(WIDTH) , rnd.nextInt(HEIGHT));

        List<Point> interpolated = Spline.evaluate(points, GRANULARITY);


        clearBuffer();
        for(Point p : interpolated)
            printPoint(p.x(), p.y(), '.');
        for(int i = 0; i < POINTS; i++)
            printPoint(points[i].x(), points[i].y(), 'x');
        printBuffer();
    }

    static void printPoint(double x, double y, char sign){
        buffer[(int)y * WIDTH + (int) x] = sign;
    }

    static void clearBuffer(){
        for(int i = 0; i < WIDTH * HEIGHT; i++)
            buffer[i] = ' ';
    }

    static void printBuffer(){
        for(int i = 0; i < WIDTH + 2; i++)
            System.out.print('-');
        System.out.println();

        for(int i = 0; i < HEIGHT; i++){
            System.out.print('|');
            for(int j = 0; j < WIDTH; j++){
                System.out.print(buffer[i * WIDTH + j]);
            }
            System.out.println('|');
        }

        for(int i = 0; i < WIDTH + 2; i++)
            System.out.print('-');
        System.out.println();
    }
}
