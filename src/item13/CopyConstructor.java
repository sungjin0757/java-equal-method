package item13;

public class CopyConstructor {
    private int arg1;
    private int arg2;

    public CopyConstructor(int arg1, int arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    // 복사 생성자
    public CopyConstructor(CopyConstructor copyConstructor){
        this.arg1=copyConstructor.arg1;
        this.arg2=copyConstructor.arg2;
    }

    // 복사 팩터리
    public static CopyConstructor newInstance(CopyConstructor copyConstructor){
        return new CopyConstructor(copyConstructor.arg1,copyConstructor.arg2);
    }
}
