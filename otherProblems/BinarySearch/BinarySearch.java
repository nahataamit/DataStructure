package otherProblems.BinarySearch;

public class BinarySearch {

    public int search(int[] arr, int key){
        int start = 0;
        int end = arr.length-1;

        boolean isAscending = arr[start]<arr[end];

        while (start<=end){
            int mid = start+(end-start)/2;

            if(arr[mid] == key)
                return mid;

            if(isAscending){
                if(arr[mid] > key){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }else {
                if(arr[mid]>key){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[] {4,6,10},10));
        System.out.println(binarySearch.search(new int[] {1,2,3,4,5,6,7,8},5));
        System.out.println(binarySearch.search(new int[] {1,2,3,4,5,6,7,8},1));
    }
}
