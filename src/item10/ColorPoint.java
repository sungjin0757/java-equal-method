package item10;

import java.awt.*;

public class ColorPoint extends Point{
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        //대칭성을 지켜주기 위한 코드
        if(!(o instanceof Point)){
            return false;
        }

        //o가 일반 Point 면 색상을 무시하고 비교. 대칭성을 주기 위해
        if(!(o instanceof ColorPoint)){
            return o.equals(this);
//            return false;
        }
        return super.equals(o) && this.color==((ColorPoint) o).color;
    }

    public static void main(String[] args){
        Point p=new Point(1,2);
        ColorPoint c=new ColorPoint(1,2,Color.RED);

        // 대칭성 오류. null 이 아닌 x,y에 대해서 x.equals(x) 가 성립되면 y.equals(x) 도 성립되어야 한다. 추가 코드를 줌으로서, 성립
        System.out.println("Point Equals : "+p.equals(c));
        System.out.println("ColorPoint Equals : "+c.equals(p));

        ColorPoint c2=new ColorPoint(1,2,Color.BLACK);

        // but, 추이성이 깨짐. null 이 아닌 x,y,z에 대해서 x.equals(y), y.equals(z) 가 성립되면 x.equals(z)가 성립되어야 함.
        System.out.println("Point p , ColorPoint c1 Equals : "+p.equals(c));
        System.out.println("Point p , ColorPoint c2 Equals : "+p.equals(c2));
        System.out.println("ColorPoint c1 , ColorPoint c2 Equals : "+c.equals(c2));
    }
}

