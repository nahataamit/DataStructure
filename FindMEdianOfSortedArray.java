package otherProblems;

public class FindMEdianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1,nums2);

        int length = merged.length;

        double median = length%2 == 0 ? (merged[(length/2)-1]+merged[length/2])/2.0 : merged[length/2];

        return median;
    }

    public int[] merge(int[] nums1, int[] nums2){
        int left = nums1.length;
        int right = nums2.length;

        int[] mergedArray = new int[left+right];
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while(leftIndex< left && rightIndex< right){
            if(nums1[leftIndex]< nums2[rightIndex]){
                mergedArray[index++] = nums1[leftIndex++];
            }else{
                mergedArray[index++] = nums2[rightIndex++];
            }
        }

        while(leftIndex <left){
            mergedArray[index++] = nums1[leftIndex++];
        }

        while(rightIndex< right){
            mergedArray[index++] = nums2[rightIndex++];
        }

        return mergedArray;

    }

    public static void main(String[] args){
        int [] nums1 =  {1,3};
        int [] nums2 =  {2};

        FindMEdianOfSortedArray findMEdianOfSortedArray = new FindMEdianOfSortedArray();
        System.out.println(findMEdianOfSortedArray.findMedianSortedArrays(nums1,nums2));

         nums1 = new int[]{};
         nums2 = new int[]{1};

        System.out.println(findMEdianOfSortedArray.findMedianSortedArrays(nums1,nums2));

        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};

        System.out.println(findMEdianOfSortedArray.findMedianSortedArrays(nums1,nums2));
    }
}
