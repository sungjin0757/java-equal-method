package item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof CaseInsensitiveString){
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if(o instanceof String){  //일반 문자열과도 비교. 만약 String 인스턴스에서 equals 를 실행할 때는 에러 발생.
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }

    public static void main(String[] args){
        CaseInsensitiveString cis=new CaseInsensitiveString("s");
        String s="s";
        System.out.println("CaseInsensitiveString equals : "+cis.equals(s));
        System.out.println("String equals : "+s.equals(cis)); //대칭성 위배

        List<CaseInsensitiveString> list=new ArrayList<>();
        list.add(cis);
        System.out.println(list.contains(s)); //equals를 String과 연동시키겠다는 꿈은 꾸지도 말자.
    }
}
