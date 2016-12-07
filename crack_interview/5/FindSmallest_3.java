public class FindSmallest_3 {
    static int findNumberOfN(int x) {
        int count = 0;
        for( int i=0; i<32; i++ ) {
            int n = ( x >> i ) & 0x01;
            if (n == 1) count++;
        }

        return count;
    }

    static int findSmallest(int x) {
        int n = findNumberOfN( x );
        while( true ) {
            x++;
            if ( findNumberOfN(x) == n )
                return x;
        }
    }

    static int findBiggest(int x) {
        int n = findNumberOfN( x );
        while( true ) {
            x--;
            if ( findNumberOfN(x) == n )
                return x;
        }
    }

    // TODO : Brutal Force 가 아닌.. 좀더 영리한 방법

    public static void main(String[] args) {
        for( int i=4; i<10; i++ ) {
            System.out.println("findNumberOfN("+i+") ="+findNumberOfN(i));
            System.out.println("findSmallest("+i+") ="+findSmallest(i));
            System.out.println("findBiggest("+i+") ="+findBiggest(i));
        }
    }
}
