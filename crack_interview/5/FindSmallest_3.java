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
            if (x<0) return -1;
            if ( findNumberOfN(x) == n )
                return x;
        }
    }

    static int findSmallest2(int x) {
        int c0 = -1, c1=-1;
        //   |   c1V  Vc0   |
        //   |10000011100000|
        for (int i=0, p=0x01; i<32; i++, x>>=1) {
            if ( c0 < 0 && (x&0x01)==1 ) {
                c0=i;
                continue;
            }
            if ( c0 >= 0 && (x&0x01)==0) {
                c1=i;
                x |= 0x01;
                x <<= c1;
                break;
            }
        }
        //   |   c1V  Vc0   |
        //   |10000100000000|
        int i=c1-c0+1;
        return x | ((-1 << i)>> i);
    }

    static int findBiggest(int x) {
        int n = findNumberOfN( x );
        while( true ) {
            x--;
            if (x<0) return -1;
            if ( findNumberOfN(x) == n )
                return x;
        }
    }

    static int findBiggest2(int x) {
        int c0 = -1;
        //   |        Vc0   |
        //   |10000011100000|
        for (int i=0, p=0x01; i<32; i++, x>>=1) {
            if ( c0 < 0 && (x&0x01)==1 ) {
                c0=i;
                x |= 0x00;
                x <<= c0;
                break;
            }
        }
        //   |        Vc0   |
        //   |10000011000000|
        return x | 0x01<<(c0-1);
    }

    // TODO : Brutal Force 가 아닌.. 좀더 영리한 방법

    public static void main(String[] args) {
        for( int i=4; i<10; i++ ) {
            System.out.println("findNumberOfN("+i+") ="+findNumberOfN(i));
            System.out.println("findSmallest2("+i+") ="+findSmallest(i));
            System.out.println("findSmallest("+i+") ="+findSmallest(i));
            System.out.println("findBiggest("+i+") ="+findBiggest(i));
            System.out.println("findBiggest2("+i+") ="+findBiggest2(i));
        }
    }
}
