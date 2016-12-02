import java.util.Arrays;

public class QuickSort {
    public static void sort( int[] data, int start, int end ) {
        if ( start >= end ) return;
        int pivot_index = (end-start)/2;
        int pivot = data[pivot_index];
        int i=0, j = data.length-1;
        while( true ) {
            for( i=i; data[i] < pivot && i<data.length; i++);
            for( j=j; data[j] > pivot && j>=0; j--);
            if (i<j) {
                int tmp=data[i];
                data[i] = data[j];
                data[j] = tmp;
            } else {
                break;
            }
        }
    }

    static void sort(int[] data) {
        System.out.println("before:"+Arrays.toString(data));
        sort(data, 0, data.length-1);
        System.out.println("after:"+Arrays.toString(data));
    }

    public static void main(String[] args) {
        QuickSort.sort( new int[] { 0,-1 } );
        QuickSort.sort( new int[] { 0 } );
        QuickSort.sort( new int[] { -1, 1, 0 } );
        QuickSort.sort( new int[] { 5,4,1,2,8,7,9 } );
    };
}
