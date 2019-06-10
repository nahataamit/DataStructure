package otherProblems;

public class SearchInRotatedArray {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0)
            return false;

        if(nums.length  ==1)
            return nums[0] == target;

        int start = 0;
        int end = nums.length;


        while(start < end){

            int mid = (start + end )/2;

            if(target == nums[mid])
                return true;
            // {5,6,7,8,1,2,3}
            if(nums[mid] < target && nums[mid] <= nums[mid+1] ){
                //start = mid+1;
                return search(mid+1,end,nums,target);
            }else if(nums[mid]>target && nums[mid] >= nums[mid-1]){

                return search(start,mid-1,nums,target) || search(mid+1, end, nums, target);
            }
        }

        return false;
    }

    public boolean search(int start, int end,int[] nums,int target){
        if(nums.length  == 0)
            return false;


        while(start < end){
            int mid = (start+end)/2;

            if(nums[mid] == target)
                return true;

            if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return false;
    }

    public static void main(String[] args){
        //[2,5,6,0,0,1,2]
        //3
        int[] ar = new int[]{2,5,6,0,0,1,2};
        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        System.out.println(searchInRotatedArray.search(ar, 5));
    }
}
