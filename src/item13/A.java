package item13;

public class A implements Cloneable{

    // 잘못된 클래스로의 변환
//    @Override
//    protected A clone() throws CloneNotSupportedException {
//        return new A();
//    }

    @Override
    public A clone() throws CloneNotSupportedException {
        try {
            return (A)super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
