package item10;

import java.awt.*;

public class SizePoint extends Point{
    private final int size;

    public SizePoint(int x, int y, int size) {
        super(x, y);
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)){
            return false;
        }

        if(!(o instanceof SizePoint)){
            return o.equals(this);
        }
        return super.equals(o) && this.size==((SizePoint) o).size;
    }

    public static void main(String[] args){
        ColorPoint c=new ColorPoint(1,2, Color.BLACK);
        SizePoint s=new SizePoint(1,2,2);

        //무한 루프 발생. 서로의 equals 를 무한 호출하게 됨.
        System.out.println(s.equals(c));
    }
}
