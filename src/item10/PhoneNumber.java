package item10;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode,999,"지역번호");
        this.prefix = rangeCheck(prefix,999,"프리픽스");
        this.lineNum = rangeCheck(lineNum,9999,"가입자 번호");
    }

    private static short rangeCheck(int val,int max,String arg){
        if(val<0 || val>max){
            throw new IllegalArgumentException(arg+": "+val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if(o==this){
            return true;
        }
        if(!(o instanceof PhoneNumber)){
            return false;
        }
        PhoneNumber pn=(PhoneNumber) o;
        return pn.areaCode==this.areaCode && pn.lineNum==this.lineNum && pn.prefix==this.prefix;
    }

    @Override
    public int hashCode() {
        //최악의 해시코드. 모두 똑같은 해쉬코드를 가져 다 같은 버킷에 담기게 됨.
//        return 42;

        //직접 만든 해시코드 충분히 성능도 좋음
//        int result=Short.hashCode(areaCode);
//        result=31*result+Short.hashCode(prefix);
//        result=31*result+Short.hashCode(lineNum);
//        return result;
        //성능 아쉽
        return Objects.hash(lineNum,prefix,areaCode);
    }


    public static void main(String[] args){
        //해시 맵에서 객체를 꺼내는 방법은 같은 해시코드를 가진 버킷에 동치가 성립하면 된다.
        Map<PhoneNumber, String> m=new HashMap<>();
        m.put(new PhoneNumber((short) 1,(short)2,(short)3),"제니");

        //2개의 인스턴스가 사용된 것
        System.out.println(m.get(new PhoneNumber((short) 1,(short)2,(short)3)));
    }
}
