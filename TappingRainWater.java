package otherProblems;

public class TappingRainWater {
    public int trap(int[] A) {
        int area =0;

        int l =0;
        int r =  A.length-1;

        while (l<r && A[l]<=A[l+1])l++;
        while(l<r && A[r]<=A[r-1])r--;


        while(l<r){
            int left = A[l];
            int right = A[r];

            if(left<=right){

                while (l<r && left >= A[++l]){
                    area+= left-A[l];
                }
            }else {
                while (l<r && A[--r]<= right){
                    area+=right-A[r];
                }
            }
        }

        return area;
    }

    public static void main(String[] args){
        TappingRainWater tappingRainWater = new TappingRainWater();
        System.out.println(tappingRainWater.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
