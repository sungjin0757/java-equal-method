package item10;

import java.awt.*;
import java.util.Objects;

//구체 클래스를 확장해 새로운 값을 추가하면서, equals를 만족시킬 방법이 없다면 컴포지션으로 우회 하여보자.
public class ColorPoint2 {
    private final Point p;
    private final Color color;

    public ColorPoint2(int x, int y, Color color) {
        this.p = new Point(x,y);
        this.color = Objects.requireNonNull(color);
    }

    public Point asPoint() {
        return p;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPoint)){
            return false;
        }
        ColorPoint2 temp=(ColorPoint2) o;
        return temp.color==this.color && temp.p.equals(this.p);
    }
}
