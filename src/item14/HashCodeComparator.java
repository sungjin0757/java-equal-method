package item14;

import java.util.Comparator;

public class HashCodeComparator {
    static Comparator<Object> hashCodeOrderV1=new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            // 이와 같은 방식은 부동 소수점의 문제 혹은 오버플로우가 나타날수 있다.
            return o1.hashCode()-o2.hashCode();
        }
    };

    // 밑에와 같은 방법으로 사용하는 것을 권장
    static Comparator<Object> hashCodeOrderV2=new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            // 이와 같은 방식은 부동 소수점의 문제 혹은 오버플로우가 나타날수 있다.
            return Integer.compare(o1.hashCode(),o2.hashCode());
        }
    };

    static Comparator<Object> hashCodeOrderV3=Comparator.comparingInt(o->o.hashCode());
}
