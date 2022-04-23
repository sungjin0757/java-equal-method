package item14;

public class CaseInsensitiveString implements Comparable<CaseInsensitiveString>{

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

    @Override
    public int compareTo(CaseInsensitiveString o) {
        return String.CASE_INSENSITIVE_ORDER.compare(s,o.s);
    }
}
