import java.util.HashMap;
/**
 * 반복이 없는 가장 긴 substring 의 길이를 구하시오.
**/
public class MaxSubstring {
    public static int getMaxLenSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlen = 0;
        int index = 0;
        for( int i=0; i<s.length(); i++ ) {
            char ch = s.charAt(i);
            if ( map.containsKey( ch ) ) {
                int dup_index = map.get(ch);
                if (maxlen <= i-dup_index) {
                    maxlen = i-dup_index;
                    index = dup_index+1;
                }
                map.put( ch, i );
            } else {
                map.put( ch, i );
            }
        }
        return (maxlen < s.length()-index ? s.length()-index : maxlen);
    }

    public static void main(String[] args) {
        assert getMaxLenSubstring("") == 0;
        assert getMaxLenSubstring("abc") == 3;
        assert getMaxLenSubstring("abcad") == 4;
        assert getMaxLenSubstring("abcabde") == 5;
    }
}
