public class FindSubstring {
    public static int count(String s1, String s2) {
        String[] sp = s2.split(" ");
        char[] ch1 = s1.toCharArray();
        int count = 0;
        for( int i=0; i<ch1.length; i++ ) {
            for (int j=0; j<sp.length; j++) {
                char[] ch2 = sp[j].toCharArray();
                boolean matched = true;
                if (ch1.length-i < ch2.length) continue; // <- 빼먹음
                for( int k=0; k<ch2.length; k++ ) {
                    if (ch2[k] != ch1[k+i]) {
                        matched = false;
                        break;
                    }
                }
                if (matched) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "this is new moonsmoon suns";
        String s2 = "moon sun";
        System.out.println("expected: 3 => " +count(s1,s2));
    }
}
