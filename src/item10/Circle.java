package item10;

import java.awt.*;
import java.util.Set;

//리스코프 치환 원칙의 예.
public class Circle {
    private static final Set<Point> unitCircle=Set.of(new Point(1,0),
            new Point(0,1),new Point(-1,0),new Point(0,-1));

    public static boolean onUnitCircle(Point p){
        return unitCircle.contains(p);
    }

    public static void main(String[] args){
        ColorPoint colorPoint = new ColorPoint(1, 0, Color.BLACK);
        System.out.println("onUnitCircle : "+onUnitCircle(colorPoint));
    }
}
