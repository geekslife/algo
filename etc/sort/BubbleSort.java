import java.util.Arrays;

public class BubbleSort {
    static int[] sort(int[] data) {
        if (data == null || data.length <=1)
            return data;

        for (int i=0; i<data.length-1; i++) {
            for (int j=i; j<data.length-1; j++) {
                if ( data[j] > data[j+1] ) {
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }

        return data;
    }

    public static void main(String[] args) {
        assert Arrays.equals(new int[]{0}, sort(new int[]{0}));
        assert Arrays.equals(new int[]{-1,0}, sort(new int[]{0,-1}));
        System.err.println("all passed");
    }
}
