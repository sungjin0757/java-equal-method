package item14;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BigDecimalTest {

    public static void main(String[] args){
        BigDecimal b1=new BigDecimal("1.0");
        BigDecimal b2=new BigDecimal("1.00");

        Set<BigDecimal> treeSet=new TreeSet<>();
        treeSet.add(b1);
        treeSet.add(b2);

        Set<BigDecimal> hashSet=new HashSet<>();
        hashSet.add(b1);
        hashSet.add(b2);

        System.out.println("TreeSet : "+treeSet.size());
        System.out.println("HashSet : "+hashSet.size());
    }
}
