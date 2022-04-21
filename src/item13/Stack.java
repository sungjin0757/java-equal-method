package item13;

public class Stack implements Cloneable{
    private int size;
    private Object[] elements;

    public Stack(int size, Object[] elements) {
        this.size = size;
        this.elements = elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    // 필드의 얕은 복사로 인해서 오류가 발생하거나 불변식의 조건을 못 맞춤
//    @Override
//    public Stack clone() {
//        try {
//            return (Stack) super.clone();
//        }catch(CloneNotSupportedException e){
//            throw new AssertionError();
//        }
//    }


    // 필드 또한 깊은 복사를 해야함.
    @Override
    public Stack clone() {
        try {
            Stack cloneStack = (Stack) super.clone();
            cloneStack.elements=elements.clone();
            return cloneStack;
        }catch(CloneNotSupportedException e){
            throw new AssertionError();
        }
    }

    public static void main(String[] args){
        Stack stack=new Stack(2,new Object[]{1,2,3});
        Stack cloneStack = stack.clone();

        // element 의 참조 또한 깊은 복사가 되어야 완벽한 복사가 되었음을 의미한다.
        System.out.println(stack.elements!=cloneStack.elements);
    }
}
