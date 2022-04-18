package item10;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        //getClass 방식. 리스코프 치환 원칙에서 오류 발생.
//        if(o==null || o.getClass()!=getClass()){
//            return false;
//        }

        if(!(o instanceof Point)){
            return false;
        }
        Point p=(Point) o;
        return p.x==this.x && p.y==this.y;
    }
}
