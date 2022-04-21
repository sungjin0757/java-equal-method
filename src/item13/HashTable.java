package item13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTable implements Cloneable{
    private Entry[] buckets;

    private static class Entry{
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy(){
            Entry result=new Entry(key,value,next);
            for( Entry p=result;p.next!=null;p=p.next){
                p.next=new Entry(p.next.key,p.next.value,p.next.next);
            }
            return result;
        }
    }


    // 복제본은 자신만의 버킷 배열을 갖지만, 이 배열은 원본과 같은 연결리스트를 참조하여 원본과 복제본 모두 예기치 않게 동작할 가능성이 생김.
    // 따라서 구성하는 연결리스트 또한 깊은 복사를 해야함.
//    @Override
//    public HashTable clone()  {
//        try{
//            HashTable cloneHashTable = (HashTable) super.clone();
//            cloneHashTable.buckets=buckets.clone();
//            return cloneHashTable;
//        }catch (Exception e){
//            throw new AssertionError();
//        }
//    }

    @Override
    public HashTable clone()  {
        try{
            HashTable cloneHashTable = (HashTable) super.clone();
            cloneHashTable.buckets=new Entry[buckets.length];
            for(int i=0;i<buckets.length;i++){
                if(buckets[i]!=null){
                    cloneHashTable.buckets[i]=buckets[i].deepCopy();
                }
            }
            return cloneHashTable;
        }catch (Exception e){
            throw new AssertionError();
        }
    }

}
