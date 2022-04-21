package item13;

public class B extends A {
    // 타입 캐스트 오류. 혹은 A 클래스의 객체만 만들어짐
//    @Override
//    protected B clone() throws CloneNotSupportedException {
//        return (B)super.clone();
//    }

    @Override
    public B clone() throws CloneNotSupportedException {
        try{
            return (B) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a=new A();
        B b=new B();

        System.out.println(a.clone().getClass());
        System.out.println(b.clone().getClass());

        System.out.println(b.getClass()==b.clone().getClass());
    }
}
