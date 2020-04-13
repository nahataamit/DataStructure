package otherProblems.BinarySearch;

/**
 * Given an infinite sorted array (or and Array of unknown size), find out if a given number key is
 * present in the array
 */
public class SearchInInfiniteList {

    public static int search(ArrayReader reader,int key ){
        int start = 0;
        int end = 1;

        // find the appropriate bound first
        while (reader.get(end) <key){
            int newStart = end+1;
            end+= (end-start+1)*2;
            start = newStart;
        }

        return binarySearch(reader,start,end,key);
    }

    public static int binarySearch(ArrayReader reader, int start, int end, int key){

        while (start<=end){
            int mid = start+(end-start)/2;

            if(reader.get(mid) == key)
                return mid;

            if(reader.get(mid)>key){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(
                new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(SearchInInfiniteList.search(reader, 16));
        System.out.println(SearchInInfiniteList.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(SearchInInfiniteList.search(reader, 15));
        System.out.println(SearchInInfiniteList.search(reader, 200));
    }
}

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}
