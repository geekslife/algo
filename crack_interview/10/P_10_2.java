import java.util.Comparator;
import java.util.Arrays;

public class P_10_2 {
    class MyComp implements Comparator<String> {
        public int compare( String a , String b ) {
            char[] ca = ((String)a).toCharArray();
            char[] cb = ((String)b).toCharArray();
            Arrays.sort(ca);
            Arrays.sort(cb);
            System.out.println("ca=>"+new String(ca));
            System.out.println("cb=>"+new String(cb));
            if (new String(ca).equals(new String(cb)))
                return 0;
            else
                return ((String)a).compareTo((String)b);
        }
    };

    public String[] sort( String[] s ) {
        Arrays.sort(s,new MyComp());
        return s;
    }

    public static void main(String[] args) {
        String[] a = { "hello", "abz", "goodbye", "zab", "bza" };
        System.out.println("before:"+Arrays.asList(a));
        P_10_2 p = new P_10_2();
        a = p.sort(a);
        System.out.println("after:"+Arrays.asList(a));
    }
}
