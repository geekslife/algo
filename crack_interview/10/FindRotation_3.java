public class FindRotation_3 {
    public static int find(int[] array , int start, int end, int value) {
        int mid = start+(end-start)/2;
        System.out.println("find:("+start+","+end+")"+",mid="+mid+",array[start="+array[start]+",array[mid]="+array[mid]+",array[end]="+array[end]);
        if (array[mid] == value)
            return mid;

        if (array[mid] <= array[end]) { // 단순 증가
            if (array[mid] < value) 
                return find(array,mid,end,value);
            else
                return find(array,start,mid,value);
        } else { // 꺾어짐
            if (array[mid] > value)
                return find(array,start,mid,value);
            else
                return find(array,mid,end,value);
        }
    }
    public static void main(String[] args) {
        int[] data = { 15,16,19,20,25,1,4,4,5,7,10,14 };
        System.out.println("expecting:8 :"+find(data,0,data.length-1,5));
    }
}
