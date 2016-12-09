public class MagicFast_3 {
    public static int magicFast(int[] array) {
        int n = array.length;
        int i=n/2;
        while( array[i] != i && i<n) {
            if (array[i] > i) {
                i = i/2;
            } else {
                i = i + (n-i)/2;
            }
        }
        if ( array[i] == i ) return i;
        else return -1;
    }

    public static int magicFast2(int[] array, int start, int end) {
        int mid = (end-start)/2;
        if (start == end) {
            if (array[start] == start) return start;
            else return -1;
        }
        if (array[mid] == mid)
            return mid;
        else if (array[mid] < mid)
            return magicFast2(array,start,mid);
        else
            return magicFast2(array,mid,end);
    }

    public static int magicFast3(int[] array, int start, int end) {
        int mid = (end-start)/2;
        if (start == end) {
            if (array[start] == start) return start;
            else return -1;
        }
        if (array[mid] == mid)
            return mid;
        else if (array[mid] < mid)
            return magicFast3(array,start,mid);
        else
            return magicFast3(array,mid,end);
    }

    public static void main(String[] args){
        int i = MagicFast_3.magicFast( new int[] { -40,-20, 1, 2, 3, 5, 7, 9, 12, 13 } );
        System.out.println("expecting:5 =>"+i);
        i = MagicFast_3.magicFast2( new int[] { -40,-20, 1, 2, 3, 5, 7, 9, 12, 13 },0,10 );
        System.out.println("expecting:5 =>"+i);
    }
}
